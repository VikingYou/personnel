package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.*;

/**
 * Created by ycd20 on 2022/06/14
 */
@Entity
@Table(name = "t_salary_account")
public class SalaryAccount extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long salaryAccountId;

    private String salaryAccountName;

    private boolean status;

    public Long getSalaryAccountId() {
        return salaryAccountId;
    }

    public void setSalaryAccountId(Long salaryAccountId) {
        this.salaryAccountId = salaryAccountId;
    }

    public String getSalaryAccountName() {
        return salaryAccountName;
    }

    public void setSalaryAccountName(String salaryAccountName) {
        this.salaryAccountName = salaryAccountName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
