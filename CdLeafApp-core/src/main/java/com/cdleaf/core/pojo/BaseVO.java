package com.cdleaf.core.pojo;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseVO {
    public Long id;
    public Date createTime;
    public Date updateTime;

    public Map<String,String> errors;

    public BaseVO(){
        errors = new HashMap();
    }

    public Map setError(String key, String message){
        errors.put(key, message);
        return errors;
    }
    public Map setError(String key){
        errors.put(key, "");
        return errors;
    }
    public String getError(String key){
        return errors.get(key);
    }
    public boolean isError(String key){
        return errors.containsKey(key);
    }
    @Override
    public abstract String toString();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
