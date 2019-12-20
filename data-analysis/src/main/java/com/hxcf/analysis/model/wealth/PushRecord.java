package com.hxcf.analysis.model.wealth;

import javax.persistence.Id;
import java.util.Date;

public class PushRecord {
    @Id
    private Long id;

    private Long userId;

    private String pushRegId;

    private String pushTitle;

    private String pushContent;

    private Integer pushTarget;

    private String pushDay;

    private Long messageId;

    private Integer sendNo;

    private Integer status;

    private String errCode;

    private String errMsg;

    private String scheduleId;

    private Date pushTime;

    private Date createTime;

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

    public String getPushRegId() {
        return pushRegId;
    }

    public void setPushRegId(String pushRegId) {
        this.pushRegId = pushRegId == null ? null : pushRegId.trim();
    }

    public String getPushTitle() {
        return pushTitle;
    }

    public void setPushTitle(String pushTitle) {
        this.pushTitle = pushTitle == null ? null : pushTitle.trim();
    }

    public String getPushContent() {
        return pushContent;
    }

    public void setPushContent(String pushContent) {
        this.pushContent = pushContent == null ? null : pushContent.trim();
    }

    public Integer getPushTarget() {
        return pushTarget;
    }

    public void setPushTarget(Integer pushTarget) {
        this.pushTarget = pushTarget;
    }

    public String getPushDay() {
        return pushDay;
    }

    public void setPushDay(String pushDay) {
        this.pushDay = pushDay == null ? null : pushDay.trim();
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getSendNo() {
        return sendNo;
    }

    public void setSendNo(Integer sendNo) {
        this.sendNo = sendNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode == null ? null : errCode.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId == null ? null : scheduleId.trim();
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}