package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ycd20 on 2022/06/12
 */
@Entity
@Table(name = "t_job_title")
public class JobTitle extends UserDateAudit {
    private String jobTitleName;
    private String jobTitleId;

    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public String getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(String jobTitleId) {
        this.jobTitleId = jobTitleId;
    }
}
