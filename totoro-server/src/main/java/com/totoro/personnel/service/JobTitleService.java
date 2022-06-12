package com.totoro.personnel.service;

import com.totoro.personnel.model.JobTitle;
import com.totoro.personnel.payload.request.JobTitleRequest;
import com.totoro.personnel.payload.request.JobTypeRequest;
import com.totoro.personnel.payload.response.JobTitleResponse;
import com.totoro.personnel.payload.response.PagedResponse;

/**
 * Created by ycd20 on 2022/06/12
 */
public interface JobTitleService {
    PagedResponse<JobTitleResponse> getAllJobTitles(int page,int size);

    JobTitle createJobTitle(JobTitleRequest jobTitleRequest);
}
