package com.hxcf.analysis.model.wealth;

import javax.persistence.Id;
import java.util.Date;

public class RiskPaperStandard {
    @Id
    private Integer id;

    private Integer paperId;

    private Integer standardNo;

    private Integer scoreMin;

    private Integer scoreMax;

    private Integer riskTolerance;

    private Integer riskProductLevel;

    private String riskPreference;

    private String createUser;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getStandardNo() {
        return standardNo;
    }

    public void setStandardNo(Integer standardNo) {
        this.standardNo = standardNo;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    public Integer getScoreMax() {
        return scoreMax;
    }

    public void setScoreMax(Integer scoreMax) {
        this.scoreMax = scoreMax;
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