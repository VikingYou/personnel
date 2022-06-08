package com.totoro.personnel.controller;

import com.totoro.personnel.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ycd20 on 2022/06/07
 */
@RestController
@RequestMapping("api/tenant")
public class TenantController {
    @Autowired
    private TenantService tenantService;


}
