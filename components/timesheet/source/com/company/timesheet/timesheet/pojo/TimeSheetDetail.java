package com.company.timesheet.timesheet.pojo;

import java.util.Date;
import java.util.List;

import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;

public class TimeSheetDetail {

    private Long timeSheetID;

    private Long projectTimeSheetProcessID;

    private Long projectPersonLinkID;

    private int totalRegularHours;

    private int totalNoOfHoursWorked;

    private Date createdDateTime;

    private Date submittedDateTime;

    private String timeSheetStatus;

    private String approvalLevelType;

    private String projectName;

    private String firstName;

    private String lastName;

    private Date startDate;

    private Date endDate;

    private String comments;

    private String recordStatus;

    private int versionNo;

    private String updateAction = "update";
    
    private List<TimeSheetLineItemDetail> timeSheetLineItemDetailList = null;

    public String getUpdateAction() {

        return updateAction;
    }

    public void setUpdateAction(String updateAction) {

        this.updateAction = updateAction;
    }

    public Long getTimeSheetID() {

        return timeSheetID;
    }

    public void setTimeSheetID(Long timeSheetID) {

        this.timeSheetID = timeSheetID;
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

    public int getTotalRegularHours() {

        return totalRegularHours;
    }

    public void setTotalRegularHours(int totalRegularHours) {

        this.totalRegularHours = totalRegularHours;
    }

    public int getTotalNoOfHoursWorked() {

        return totalNoOfHoursWorked;
    }

    public void setTotalNoOfHoursWorked(int totalNoOfHoursWorked) {

        this.totalNoOfHoursWorked = totalNoOfHoursWorked;
    }

    public Date getCreatedDateTime() {

        return createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {

        this.createdDateTime = createdDateTime;
    }

    public Date getSubmittedDateTime() {

        return submittedDateTime;
    }

    public void setSubmittedDateTime(Date submittedDateTime) {

        this.submittedDateTime = submittedDateTime;
    }

    public String getTimeSheetStatus() {

        return timeSheetStatus;
    }

    public void setTimeSheetStatus(String timeSheetStatus) {

        this.timeSheetStatus = timeSheetStatus;
    }

    public String getApprovalLevelType() {

        return approvalLevelType;
    }

    public void setApprovalLevelType(String approvalLevelType) {

        this.approvalLevelType = approvalLevelType;
    }

    public String getProjectName() {

        return projectName;
    }

    public void setProjectName(String projectName) {

        this.projectName = projectName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
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

    
    /**
     * @return the timeSheetLineItemDetailList
     */
    public List<TimeSheetLineItemDetail> getTimeSheetLineItemDetailList() {
    
        return timeSheetLineItemDetailList;
    }

    
    /**
     * @param timeSheetLineItemDetailList the timeSheetLineItemDetailList to set
     */
    public void setTimeSheetLineItemDetailList(List<TimeSheetLineItemDetail> timeSheetLineItemDetailList) {
    
        this.timeSheetLineItemDetailList = timeSheetLineItemDetailList;
    }

}