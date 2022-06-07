package com.totoro.personnel.service;

import com.totoro.personnel.exception.BadRequestException;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.TenantResponse;
import com.totoro.personnel.repository.TenantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ycd20 on 2022/06/07
 */
@Service
@Slf4j
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    public PagedResponse<TenantResponse> getAllTenant(int page, int size) {
        validatePageNumberAndSize(page, size);
        return null;
    }

    private void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number can not be less than zero");
        }
    }
}
