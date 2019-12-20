package com.hxcf.analysis.model.wealth;

import javax.persistence.Id;
import java.util.Date;

public class RiskPaperAnswer {
    @Id
    private Long id;

    private Long userId;

    private String realName;

    private String userMobile;

    private Integer certificateType;

    private String certificateNumber;

    private Integer productType;

    private Integer paperId;

    private String paperName;

    private String paperNo;

    private Integer paperVer;

    private Integer score;

    private Integer standardId;

    private Integer riskTolerance;

    private Integer riskProductLevel;

    private String riskPreference;

    private Integer status;

    private Integer period;

    private Integer version;

    private Date createTime;

    private Date expireTime;

    private Date invalidTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public String getPaperNo() {
        return paperNo;
    }

    public void setPaperNo(String paperNo) {
        this.paperNo = paperNo == null ? null : paperNo.trim();
    }

    public Integer getPaperVer() {
        return paperVer;
    }

    public void setPaperVer(Integer paperVer) {
        this.paperVer = paperVer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Integer getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(Integer riskTolerance) {
        this.riskTolerance = riskTolerance;
    }

    public Integer getRiskProductLevel() {
        return riskProductLevel;
    }

    public void setRiskProductLevel(Integer riskProductLevel) {
        this.riskProductLevel = riskProductLevel;
    }

    public String getRiskPreference() {
        return riskPreference;
    }

    public void setRiskPreference(String riskPreference) {
        this.riskPreference = riskPreference == null ? null : riskPreference.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}