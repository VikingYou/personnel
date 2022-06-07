package com.totoro.personnel.service;

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


}
