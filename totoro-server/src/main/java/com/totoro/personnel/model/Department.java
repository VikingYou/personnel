package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ycd20 on 2022/06/13
 */
@Entity
@Table(name = "t_department")
public class Department extends UserDateAudit {
    @Id
    private Long departmentId;

    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
