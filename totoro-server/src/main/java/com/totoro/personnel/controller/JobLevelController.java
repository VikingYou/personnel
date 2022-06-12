package com.totoro.personnel.controller;

import com.totoro.personnel.model.JobLevel;
import com.totoro.personnel.payload.request.JobLevelRequest;
import com.totoro.personnel.payload.response.ApiResponse;
import com.totoro.personnel.payload.response.JobLevelResponse;
import com.totoro.personnel.payload.response.PagedResponse;
import com.totoro.personnel.service.JobLevelService;
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
@RequestMapping("api/jobLevel")
public class JobLevelController {
    @Resource
    private JobLevelService jobLevelService;

    @GetMapping
    public PagedResponse<JobLevelResponse> getAllJobLevels(@RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                           @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return jobLevelService.getAllJobLevels(page, size);
    }

    @PostMapping
    public ResponseEntity<?> createJobLevels(@Valid @RequestBody JobLevelRequest jobLevelRequest) {
        JobLevel jobLevel = jobLevelService.createJobLevel(jobLevelRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{jobLevelId}")
                .buildAndExpand(jobLevel.getJobLevelId()).toUri();
        return ResponseEntity.created(location).body(
                new ApiResponse(true, "created jobLevel successfully")
        );
    }

}
