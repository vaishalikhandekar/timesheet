package com.company.timesheet.timesheet.pojo;

import java.util.Date;

import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;


public class TimeSheetAprovalLevelDetail {
    
    private Long timeSheetApprovalLevelID;
    
    private Long projectTimeSheetProcessID;
    
    private Long projectPersonLinkID;
    
    private String approvalLevelType;
    
    private String approvalCriteria;
    
    private Date startDate;
    
    private Date endDate;
    
    private String comments;
    
    private String recordStatus;
    
    public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
    
        return projectPersonLinkDetail;
    }


    
    public void setProjectPersonLinkDetail(ProjectPersonLinkDetail projectPersonLinkDetail) {
    
        this.projectPersonLinkDetail = projectPersonLinkDetail;
    }

    private ProjectPersonLinkDetail projectPersonLinkDetail;
    
    
    public Long getTimeSheetApprovalLevelID() {
    
        return timeSheetApprovalLevelID;
    }

    
    public void setTimeSheetApprovalLevelID(Long timeSheetApprovalLevelID) {
    
        this.timeSheetApprovalLevelID = timeSheetApprovalLevelID;
    }

    
    public Long getProjectTimeSheetProcessID() {
    
        return projectTimeSheetProcessID;
    }

    
    public void setProjectTimeSheetProcessID(Long projectTimeSheetProcessID) {
    
        this.projectTimeSheetProcessID = projectTimeSheetProcessID;
    }

    
    public Long getProjectPersonLinkID() {
    
        return projectPersonLinkID;
    }

    
    public void setProjectPersonLinkID(Long projectPersonLinkID) {
    
        this.projectPersonLinkID = projectPersonLinkID;
    }

    
    public String getApprovalLevelType() {
    
        return approvalLevelType;
    }

    
    public void setApprovalLevelType(String approvalLevelType) {
    
        this.approvalLevelType = approvalLevelType;
    }

    
    public String getApprovalCriteria() {
    
        return approvalCriteria;
    }

    
    public void setApprovalCriteria(String approvalCriteria) {
    
        this.approvalCriteria = approvalCriteria;
    }

    
    public Date getStartDate() {
    
        return startDate;
    }

    
    public void setStartDate(Date startDate) {
    
        this.startDate = startDate;
    }

    
    public Date getEndDate() {
    
        return endDate;
    }

    
    public void setEndDate(Date endDate) {
    
        this.endDate = endDate;
    }

    
    public String getComments() {
    
        return comments;
    }

    
    public void setComments(String comments) {
    
        this.comments = comments;
    }

    
    public String getRecordStatus() {
    
        return recordStatus;
    }

    
    public void setRecordStatus(String recordStatus) {
    
        this.recordStatus = recordStatus;
    }

    
    public int getVersionNo() {
    
        return versionNo;
    }

    
    public void setVersionNo(int versionNo) {
    
        this.versionNo = versionNo;
    }

    private int versionNo;
    

}
