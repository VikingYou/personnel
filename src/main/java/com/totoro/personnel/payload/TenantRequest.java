package com.totoro.personnel.payload;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/07
 */
@Data
public class TenantRequest {

    @NotBlank
    private String organizationId;

    @NotBlank
    private String organizationName;

    @NotNull
    @Valid
    private List<AdministratorRequest> administratorRequests;


}
