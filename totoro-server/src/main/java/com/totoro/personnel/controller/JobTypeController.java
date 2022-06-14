package com.totoro.personnel.controller;

import com.totoro.personnel.model.JobType;
import com.totoro.personnel.payload.request.JobTypeRequest;
import com.totoro.personnel.payload.response.ApiResponse;
import com.totoro.personnel.payload.response.JobTypeResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.service.impl.JobTypeServiceImpl;
import com.totoro.personnel.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

/**
 * Created by ycd20 on 2022/06/11
 */
@RestController
@RequestMapping("personnel/jobType")
public class JobTypeController {
    @Resource
    JobTypeServiceImpl jobTypeServiceImpl;

    @GetMapping()
    public PagedResponse<JobTypeResponse> getAllJobTypes(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return jobTypeServiceImpl.getAllJobType(page, size);
    }

    @PostMapping
    public ResponseEntity<?> createJobTypes(@Valid @RequestBody JobTypeRequest jobTypeRequest) {
        JobType jobType = jobTypeServiceImpl.createJobTypes(jobTypeRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{jobTypeId}")
                .buildAndExpand(jobType.getJobTypeId()).toUri();
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "JobType Created Successfully"));

    }
}
