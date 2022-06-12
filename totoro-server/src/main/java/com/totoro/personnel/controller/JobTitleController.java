package com.totoro.personnel.controller;

import com.totoro.personnel.model.JobTitle;
import com.totoro.personnel.payload.request.JobTitleRequest;
import com.totoro.personnel.payload.response.ApiResponse;
import com.totoro.personnel.payload.response.JobTitleResponse;
import com.totoro.personnel.payload.response.JobTypeResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.service.JobTitleService;
import com.totoro.personnel.util.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.URI;

/**
 * Created by ycd20 on 2022/06/12
 */
@RestController
@RequestMapping("personnel/jobTitle")
public class JobTitleController {
    @Resource
    private JobTitleService jobTitleService;

    @GetMapping
    public PagedResponse<JobTitleResponse> getAllJobTitle(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                          @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return jobTitleService.getAllJobTitles(page, size);
    }

    @PostMapping
    public ResponseEntity<?> createJobTitle(@Valid @RequestBody JobTitleRequest jobTitleRequest) {
        JobTitle jobTitle = jobTitleService.createJobTitle(jobTitleRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{jobLevelId}")
                .buildAndExpand(jobTitle.getId()).toUri();
        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "JobTile created successfully"));
    }
}
