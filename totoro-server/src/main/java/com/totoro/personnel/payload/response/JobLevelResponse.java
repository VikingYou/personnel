package com.totoro.personnel.payload.response;

import com.totoro.personnel.payload.request.JobTypeRequest;
import lombok.Data;

/**
 * Created by ycd20 on 2022/06/12
 */
@Data
public class JobLevelResponse {
    private Long jobLevelId;
    private String jobLevelName;
    private JobTypeResponse jobType;
}
