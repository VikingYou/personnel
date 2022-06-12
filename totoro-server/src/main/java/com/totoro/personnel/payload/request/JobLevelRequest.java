package com.totoro.personnel.payload.request;

import com.totoro.personnel.model.JobType;
import lombok.Data;

import java.util.List;

/**
 * Created by ycd20 on 2022/06/12
 */
@Data
public class JobLevelRequest {
    private String jobLevelName;
    private String jobLevelId;
    private JobTypeRequest jobType;
}
