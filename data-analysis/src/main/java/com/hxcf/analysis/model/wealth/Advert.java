package com.hxcf.analysis.model.wealth;

import javax.persistence.Id;
import java.util.Date;

public class Advert {
    @Id
    private Integer id;

    private String advertName;

    private Integer placeNo;

    private String advertImg;

    private String advertUrl;

    private String advertDesc;

    private Integer allowUser;

    private Date startTime;

    private Date endTime;

    private Integer priority;

    private Integer status;

    private Integer version;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName == null ? null : advertName.trim();
    }

    public Integer getPlaceNo() {
        return placeNo;
    }

    public void setPlaceNo(Integer placeNo) {
        this.placeNo = placeNo;
    }

    public String getAdvertImg() {
        return advertImg;
    }

    public void setAdvertImg(String advertImg) {
        this.advertImg = advertImg == null ? null : advertImg.trim();
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    public String getAdvertDesc() {
        return advertDesc;
    }

    public void setAdvertDesc(String advertDesc) {
        this.advertDesc = advertDesc == null ? null : advertDesc.trim();
    }

    public Integer getAllowUser() {
        return allowUser;
    }

    public void setAllowUser(Integer allowUser) {
        this.allowUser = allowUser;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}