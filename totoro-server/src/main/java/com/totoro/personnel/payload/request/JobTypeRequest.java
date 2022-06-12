package com.totoro.personnel.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by ycd20 on 2022/06/11
 */
@Data
public class JobTypeRequest {
    @NotBlank
    private String jobTypeName;
    @NotNull
    private Long jobTypeId;
}
