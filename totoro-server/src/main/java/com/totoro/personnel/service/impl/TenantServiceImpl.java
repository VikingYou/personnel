package com.totoro.personnel.service.impl;

import com.totoro.personnel.model.Administrator;
import com.totoro.personnel.model.Tenant;
import com.totoro.personnel.payload.request.TenantRequest;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.TenantResponse;
import com.totoro.personnel.repository.AdministratorRepository;
import com.totoro.personnel.repository.TenantRepository;
import com.totoro.personnel.service.TenantService;
import com.totoro.personnel.util.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.Positive;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ycd20 on 2022/06/07
 */
@Service
@Slf4j
public class TenantServiceImpl implements TenantService {
    @Resource
    private TenantRepository tenantRepository;
    @Resource
    private AdministratorRepository administratorRepository;

    public PagedResponse<TenantResponse> getAllTenant(@Positive int page, @Positive int size) {


        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<Tenant> tenants = tenantRepository.findAll(pageable);
        if (tenants.getTotalElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), tenants.getNumber(),
                    tenants.getSize(), tenants.getTotalElements(), tenants.getTotalPages(), tenants.isLast());
        }

        List<Long> tenantIds = tenants.map(Tenant::getId).getContent();
        Map<Long, Administrator> administratorMap = getTenantAdministratorMap(tenants.getContent());

        List<TenantResponse> tenantResponses = tenants.map(tenant -> {
            return ModelMapper.mapTenantToTenantResponse(tenant, administratorMap);
        }).getContent();
        return new PagedResponse<>(tenantResponses, tenants.getNumber(), tenants.getSize(),
                tenants.getTotalElements(), tenants.getTotalPages(), tenants.isLast());
    }


    private Map<Long, Administrator> getTenantAdministratorMap(List<Tenant> content) {
        List<Long> tenantIds = content.stream()
                .map(Tenant::getId)
                .distinct()
                .collect(Collectors.toList());
        List<Administrator> administrators = administratorRepository.findByIdIn(tenantIds);

        Map<Long, Administrator> administratorMap = administrators.stream()
                .collect(Collectors.toMap(Administrator::getId, Function.identity()));
        return administratorMap;

    }


}
