package com.cdleaf.job.entity;

import com.cdleaf.core.pojo.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "company_job", indexes = {@Index(name="idx_company_name",columnList = "companyName",unique = true)})
public class CompanyJob extends BaseEntity {

    private String companyName;
    private String phone;
    private String address;
    private String description;
    private Integer status;


    @Override
    public String toString() {
        return CompanyJob.class.toString() + " [id:" + id + ", companyName:" + companyName
                + ", phone:" + phone + ", address:" + address + ", description:" + description
                + ", status:" + status + ", createTime:" + createTime + ", updateTime:"
                + updateTime + "]";
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
