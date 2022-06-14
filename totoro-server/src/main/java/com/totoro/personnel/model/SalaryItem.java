package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.*;

/**
 * Created by ycd20 on 2022/06/14
 */
@Entity
@Table(name = "t_salary_item")
public class SalaryItem extends UserDateAudit {

    @Id
    private Long salaryItemId;

    private String salaryItemName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salary_type_id")
    private SalaryType salaryType;

    public Long getSalaryItemId() {
        return salaryItemId;
    }

    public void setSalaryItemId(Long salaryItemId) {
        this.salaryItemId = salaryItemId;
    }

    public String getSalaryItemName() {
        return salaryItemName;
    }

    public void setSalaryItemName(String salaryItemName) {
        this.salaryItemName = salaryItemName;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }
}
