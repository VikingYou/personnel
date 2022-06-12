package com.totoro.personnel.util;

import com.totoro.personnel.model.Administrator;
import com.totoro.personnel.model.JobLevel;
import com.totoro.personnel.model.JobType;
import com.totoro.personnel.model.Tenant;
import com.totoro.personnel.payload.response.JobLevelResponse;
import com.totoro.personnel.payload.response.JobTypeResponse;
import com.totoro.personnel.payload.response.TenantResponse;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * Created by ycd20 on 2022/06/08
 */
public class ModelMapper {
//    public <T> T mapModelToRequest(T t) {
//
//        BeanUtils.copyProperties();
//    }

    public static JobLevelResponse mapJobLevelToJobLevelResponse(JobLevel jobLevel, JobType jobType) {
        JobLevelResponse jobLevelResponse = new JobLevelResponse();
        BeanUtils.copyProperties(jobLevel, jobLevelResponse);
        JobTypeResponse jobTypeResponse = new JobTypeResponse();
        BeanUtils.copyProperties(jobType, jobTypeResponse);
        jobLevelResponse.setJobType(jobTypeResponse);
        return jobLevelResponse;
    }

    public static JobTypeResponse mapJobTypeToJobTypeResponse(JobType jobType) {
        JobTypeResponse jobTypeResponse = new JobTypeResponse();
        jobTypeResponse.setJobTypeId(jobType.getJobTypeId());
        jobTypeResponse.setJobTypeName(jobType.getJobTypeName());
        jobTypeResponse.setId(jobType.getId());
        return jobTypeResponse;
    }

    public static TenantResponse mapTenantToTenantResponse(Tenant tenant, Map<Long, Administrator> administratorMap) {
        return null;
    }
}
