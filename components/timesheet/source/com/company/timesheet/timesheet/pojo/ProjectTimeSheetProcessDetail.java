package com.company.timesheet.timesheet.pojo;

import java.util.Date;

public class ProjectTimeSheetProcessDetail {

	private Long projectTimeSheetProcessID;
	
	private Long projectID;

	private String frequency;

	private String startDay;

	private String minimumApprovalLevelType;

	private int regularDailyHours;

	private Date startDate;

	private Date endDate;

	private String comments;

	private String recordStatus;

	private int versionNo;

	public Long getProjectTimeSheetProcessID() {
		return projectTimeSheetProcessID;
	}

	public void setProjectTimeSheetProcessID(Long projectTimeSheetProcessID) {
		this.projectTimeSheetProcessID = projectTimeSheetProcessID;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getMinimumApprovalLevelType() {
		return minimumApprovalLevelType;
	}

	public void setMinimumApprovalLevelType(String minimumApprovalLevelType) {
		this.minimumApprovalLevelType = minimumApprovalLevelType;
	}

	public int getRegularDailyHours() {
		return regularDailyHours;
	}

	public void setRegularDailyHours(int regularDailyHours) {
		this.regularDailyHours = regularDailyHours;
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
