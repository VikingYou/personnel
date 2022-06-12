package com.totoro.personnel.service;

import com.totoro.personnel.model.JobType;
import com.totoro.personnel.payload.request.JobTypeRequest;
import com.totoro.personnel.payload.response.JobTypeResponse;
import com.totoro.personnel.payload.response.PagedResponse;

/**
 * Created by ycd20 on 2022/06/12
 */
public interface JobTypeService {
    JobType createJobTypes(JobTypeRequest jobTypeRequest);

    PagedResponse<JobTypeResponse> getAllJobType(int page, int size);
}
