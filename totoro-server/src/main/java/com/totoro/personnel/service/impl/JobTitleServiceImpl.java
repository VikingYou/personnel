package com.totoro.personnel.service.impl;

import com.totoro.personnel.model.JobTitle;
import com.totoro.personnel.payload.request.JobTitleRequest;
import com.totoro.personnel.payload.request.JobTypeRequest;
import com.totoro.personnel.payload.response.JobTitleResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.repository.JobTitleRepository;
import com.totoro.personnel.service.JobTitleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/12
 */
@Service
public class JobTitleServiceImpl implements JobTitleService {

    @Resource
    private JobTitleRepository jobTitleRepository;

    @Override
    public PagedResponse<JobTitleResponse> getAllJobTitles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<JobTitle> jobTitles = jobTitleRepository.findAll(pageable);
        List<JobTitleResponse> jobTitleResponses = jobTitles.map(jobTitle -> {
            JobTitleResponse jobTitleResponse = new JobTitleResponse();
            BeanUtils.copyProperties(jobTitle, jobTitleResponse);
            return jobTitleResponse;
        }).getContent();
        return new PagedResponse<>(jobTitleResponses, jobTitles.getNumber(), jobTitles.getSize(),
                jobTitles.getTotalElements(), jobTitles.getTotalPages(), jobTitles.isLast());
    }

    @Override
    public JobTitle createJobTitle(JobTitleRequest jobTypeRequest) {
        JobTitle jobTitle = new JobTitle();
        BeanUtils.copyProperties(jobTypeRequest, jobTitle);
        return jobTitleRepository.save(jobTitle);
    }
}
