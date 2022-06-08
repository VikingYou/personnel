package com.totoro.personnel.model;

import com.totoro.personnel.model.audit.UserDateAudit;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ycd20 on 2022/06/07
 */
@Entity
@Table(name = "t_tenant")
@SQLDelete(sql = "UPDATE t_tenant set deleted = true where id=?")
@Where(clause = "deleted=false")
public abstract class Tenant extends UserDateAudit {

    @NotBlank(message = "组织ID不能为空")
    private String organizationId;
    @NotBlank(message = "组织名称不能为空")
    private String organizationName;
    @OneToMany(mappedBy = "tenant",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    private List<Administrator> administrators = new ArrayList<>();

    private boolean deleted = Boolean.FALSE;

    private void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
        administrator.setTenant(this);
    }

    private void removeAdministrator(Administrator administrator) {
        administrators.remove(administrator);
        administrator.setTenant(this);
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }
}
