package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;

import javax.persistence.*;

/**
 * Created by ycd20 on 2022/06/07
 */
@Entity
@Table(name = "t_hr_administrator")
public class Administrator extends UserDateAudit {
    @Id
    private Long id;
    private String staffName;

    private String staffId;

    private String photoName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
