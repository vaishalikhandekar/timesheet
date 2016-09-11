package com.company.timesheet.timesheet.pojo;

import java.util.Date;

public class TimeSheetDetail {
	
	private Long timeSheetID;
	
	private Long projectTimeSheetProcessID;
	
	private Long projectPersonLinkID;
	
	private int totalRegularHours ;

	private int totalNoOfHoursWorked ;

	private Date createdDateTime ;
	
	private Date submittedDateTime ;
	
	private String timeSheetStatus;
	
	private String approvalLevelType;
	
	private String projectName;
	
	private Date startDate ;
	
	private Date endDate ;

	private String comments;
	
	private String recordStatus;
	
	private int versionNo ;

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

	}