package com.totoro.personnel.service;

import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.payload.response.TenantResponse;

import javax.validation.constraints.Positive;

/**
 * Created by ycd20 on 2022/06/12
 */
public interface TenantService {
    PagedResponse<TenantResponse> getAllTenant(@Positive int page, @Positive int size);
}
