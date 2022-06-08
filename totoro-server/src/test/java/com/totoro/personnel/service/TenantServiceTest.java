package com.totoro.personnel.service;

import com.totoro.personnel.model.Administrator;
import com.totoro.personnel.model.Tenant;
import com.totoro.personnel.payload.TenantRequest;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.TenantResponse;
import com.totoro.personnel.repository.AdministratorRepository;
import com.totoro.personnel.repository.TenantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;

import static org.mockito.Mockito.*;

class TenantServiceTest {
    @Mock
    TenantRepository tenantRepository;
    @Mock
    AdministratorRepository administratorRepository;
    @Mock
    Logger log;
    @InjectMocks
    TenantService tenantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllTenant() {
        when(administratorRepository.findIdIn(any())).thenReturn(List.of(new Administrator()));

        PagedResponse<TenantResponse> result = tenantService.getAllTenant(0, 0);
        Assertions.assertEquals(new PagedResponse<TenantResponse>(List.of(new TenantResponse()), 0, 0, 0L, 0, true), result);
    }

    @Test
    void testCreateTenant() {
        Tenant result = tenantService.createTenant(new TenantRequest());
        Assertions.assertEquals(new Tenant(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme