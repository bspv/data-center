package com.hxcf.analysis.model.pre;

import javax.persistence.Id;
import java.util.Date;

public class AppForceHistory {
    @Id
    private Integer id;

    private Integer versionId;

    private Integer oldVersionId;

    private String oldNumber;

    private String createUser;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Integer getOldVersionId() {
        return oldVersionId;
    }

    public void setOldVersionId(Integer oldVersionId) {
        this.oldVersionId = oldVersionId;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber == null ? null : oldNumber.trim();
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
}