package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/11
 */
@Entity
@Table(name = "t_job_type")
public class JobType extends UserDateAudit {


    private String jobTypeName;
    @Id
    private Long jobTypeId;

    @OneToMany(mappedBy = "jobType",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<JobLevel> jobLevelList = new ArrayList<>();

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public Long getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(Long jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public void addJobLevel(JobLevel jobLevel) {
        jobLevelList.add(jobLevel);
        jobLevel.setJobType(this);
    }

    public void removeJobLevel(JobLevel jobLevel) {
        jobLevelList.remove(jobLevel);
        jobLevel.setJobType(this);
    }
}
