package com.totoro.personnel.service;

import com.totoro.personnel.model.JobLevel;
import com.totoro.personnel.payload.request.JobLevelRequest;
import com.totoro.personnel.payload.response.JobLevelResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.repository.JobLevelRepository;

/**
 * Created by ycd20 on 2022/06/12
 */
public interface JobLevelService {
    PagedResponse<JobLevelResponse> getAllJobLevels(int page, int size);

    JobLevel createJobLevel(JobLevelRequest jobLevelRequest);

}
