package com.totoro.personnel.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by ycd20 on 2022/06/07
 */
@Data
public class AdministratorRequest {
    @NotBlank
    private String staffName;
    @NotBlank
    private String staffId;

    private String photoName;
}
