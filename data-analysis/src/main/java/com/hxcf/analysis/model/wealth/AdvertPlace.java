package com.hxcf.analysis.model.wealth;

import javax.persistence.Id;
import java.util.Date;

public class AdvertPlace {
    @Id
    private Integer id;

    private String pageName;

    private Integer pageType;

    private String placeName;

    private Integer placeNo;

    private String placeSize;

    private String schematicUrl;

    private Integer single;

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

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName == null ? null : pageName.trim();
    }

    public Integer getPageType() {
        return pageType;
    }

    public void setPageType(Integer pageType) {
        this.pageType = pageType;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName == null ? null : placeName.trim();
    }

    public Integer getPlaceNo() {
        return placeNo;
    }

    public void setPlaceNo(Integer placeNo) {
        this.placeNo = placeNo;
    }

    public String getPlaceSize() {
        return placeSize;
    }

    public void setPlaceSize(String placeSize) {
        this.placeSize = placeSize == null ? null : placeSize.trim();
    }

    public String getSchematicUrl() {
        return schematicUrl;
    }

    public void setSchematicUrl(String schematicUrl) {
        this.schematicUrl = schematicUrl == null ? null : schematicUrl.trim();
    }

    public Integer getSingle() {
        return single;
    }

    public void setSingle(Integer single) {
        this.single = single;
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