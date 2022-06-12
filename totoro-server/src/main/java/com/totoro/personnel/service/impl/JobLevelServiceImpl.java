package com.totoro.personnel.service.impl;

import com.totoro.personnel.model.JobLevel;
import com.totoro.personnel.model.JobType;
import com.totoro.personnel.payload.request.JobLevelRequest;
import com.totoro.personnel.payload.response.JobLevelResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.repository.JobLevelRepository;
import com.totoro.personnel.repository.JobTypeRepository;
import com.totoro.personnel.service.JobLevelService;
import com.totoro.personnel.util.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ycd20 on 2022/06/12
 */
@Service
public class JobLevelServiceImpl implements JobLevelService {
    @Resource
    private JobLevelRepository jobLevelRepository;

    @Resource
    private JobTypeRepository jobTypeRepository;

    @Override
    public PagedResponse<JobLevelResponse> getAllJobLevels(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<JobLevel> jobLevels = jobLevelRepository.findAll(pageable);

        Map<Long, JobType> jobTypeMap = getJobTypeMap(jobLevels.getContent());

        List<JobLevelResponse> jobLevelResponses = jobLevels.map(jobLevel -> {
            return ModelMapper.mapJobLevelToJobLevelResponse(jobLevel, jobTypeMap.get(jobLevel.getJobType().getJobTypeId()));
        }).getContent();


        return new PagedResponse<>(jobLevelResponses, jobLevels.getNumber(), jobLevels.getSize(),
                jobLevels.getTotalElements(), jobLevels.getTotalPages(), jobLevels.isLast());
    }

    private Map<Long, JobType> getJobTypeMap(List<JobLevel> content) {
        List<Long> jobTypeIds = content.stream()
                .map(jobLevel -> jobLevel.getJobType().getJobTypeId())
                .distinct().collect(Collectors.toList());
        List<JobType> jobTypes = jobTypeRepository.findAllById(jobTypeIds);

        Map<Long, JobType> jobTypeMap = jobTypes.stream()
                .collect(Collectors.toMap(JobType::getId, Function.identity()));
        return jobTypeMap;
    }

    @Override
    public JobLevel createJobLevel(JobLevelRequest jobLevelRequest) {
        JobLevel jobLevel = new JobLevel();
        BeanUtils.copyProperties(jobLevelRequest, jobLevel);
        JobType jobType = new JobType();
        BeanUtils.copyProperties(jobLevelRequest.getJobType(), jobType);
        jobLevel.setJobType(jobType);
        return jobLevelRepository.save(jobLevel);
    }
}
