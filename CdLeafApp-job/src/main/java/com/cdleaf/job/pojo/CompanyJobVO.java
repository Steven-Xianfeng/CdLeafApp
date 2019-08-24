package com.cdleaf.job.pojo;

import com.cdleaf.core.pojo.BaseVO;
import com.cdleaf.job.entity.CompanyJob;

import java.sql.Date;

public class CompanyJobVO extends BaseVO {
    private String companyName;
    private String phone;
    private String address;
    private String description;
    private Integer status;


    public CompanyJobVO(){

    }

    public CompanyJobVO(CompanyJob entity){
        if(entity != null){
            this.id = entity.getId();
            this.createTime = entity.getCreateTime();
            this.updateTime = entity.getUpdateTime();
            this.companyName = entity.getCompanyName();
            this.phone = entity.getPhone();
            this.address = entity.getAddress();
            this.description = entity.getDescription();
            this.status = entity.getStatus();
        }
    }

    public CompanyJob parseEntity(){
        CompanyJob entity = new CompanyJob();

        entity.setId(this.getId());
        entity.setCreateTime( new Date(System.currentTimeMillis()));
        entity.setUpdateTime( new Date(System.currentTimeMillis()));

        entity.setCompanyName(this.getCompanyName());
        entity.setPhone(this.getPhone());
        entity.setAddress(this.getAddress());
        entity.setDescription(this.getDescription());

        entity.setStatus(this.getStatus());

        return entity;
    }

    public boolean validate(){
        boolean flag = true;

        if(companyName == null || "".equals(companyName.trim())){
            this.setError("companyName.empty");
            flag = false;
        }
        if(description == null || "".equals(description.trim())){
            this.setError("description.empty");
            flag = false;
        }

        return flag;
    }

    @Override
    public String toString(){
        return CompanyJobVO.class.toString() + " [id:" + id + ", companyName:" + companyName
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
