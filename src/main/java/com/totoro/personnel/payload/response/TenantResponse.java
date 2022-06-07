package com.totoro.personnel.payload.response;

import lombok.Data;

import java.util.List;

/**
 * Created by ycd20 on 2022/06/08
 */
@Data
public class TenantResponse {
    private Long id;
    private String organizationId;
    private String organizationName;
    private List<AdministratorResponse> administratorResponses;
}
