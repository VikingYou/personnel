package com.totoro.personnel.service.impl;

import com.totoro.personnel.model.JobType;
import com.totoro.personnel.payload.request.JobTypeRequest;
import com.totoro.personnel.payload.response.JobTypeResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.repository.JobTypeRepository;
import com.totoro.personnel.service.JobTypeService;
import com.totoro.personnel.util.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/11
 */
@Service
@Slf4j
public class JobTypeServiceImpl implements JobTypeService {
    @Resource
    private JobTypeRepository jobTypeRepository;

    public PagedResponse<JobTypeResponse> getAllJobType(@Positive int page, @NegativeOrZero int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

        Page<JobType> jobTypes = jobTypeRepository.findAll(pageable);

        List<JobTypeResponse> jobTypeResponses = jobTypes.map(ModelMapper::mapJobTypeToJobTypeResponse).getContent();

        return new PagedResponse<>(jobTypeResponses, jobTypes.getNumber(), jobTypes.getSize(),
                jobTypes.getTotalElements(), jobTypes.getTotalPages(), jobTypes.isLast());
    }

    public JobType createJobTypes(JobTypeRequest jobTypeRequest) {
        JobType jobType = new JobType();
        jobType.setJobTypeId(jobTypeRequest.getJobTypeId());
        jobType.setJobTypeName(jobTypeRequest.getJobTypeName());
        return jobTypeRepository.save(jobType);
    }
}
