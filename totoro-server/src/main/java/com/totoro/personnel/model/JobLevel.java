package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.*;

/**
 * Created by ycd20 on 2022/06/12
 */

@Entity
@Table(name = "t_job_level")
public class JobLevel extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobLevelId;

    private String jobLevelName;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "job_type_id",nullable = false)
    private JobType jobType;

    public String getJobLevelName() {
        return jobLevelName;
    }

    public void setJobLevelName(String jobLevelName) {
        this.jobLevelName = jobLevelName;
    }

    public Long getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Long jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }
}
