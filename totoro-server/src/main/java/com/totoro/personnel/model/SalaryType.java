package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/14
 */
@Entity
@Table(name = "t_salary_type")
public class SalaryType extends UserDateAudit {
    @Id
    private Long salaryTypeId;

    private String salaryTypeName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "salaryType")
    private List<SalaryItem> salaryItemList;

    public Long getSalaryTypeId() {
        return salaryTypeId;
    }

    public void setSalaryTypeId(Long salaryTypeId) {
        this.salaryTypeId = salaryTypeId;
    }

    public String getSalaryTypeName() {
        return salaryTypeName;
    }

    public void setSalaryTypeName(String salaryTypeName) {
        this.salaryTypeName = salaryTypeName;
    }
}
