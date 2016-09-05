package com.company.timesheet.timesheet.pojo;

import java.util.Date;

public class TimeSheetDetail {
	
	private String month;
	
	private Long timeSheetID;
	
	private int totalRegularHours ;

	private int totalActualHours ;

	private Date submittedDate ;
	
	private Date startDate ;
	
	private Date endDate ;

	private String timeSheetStatus;
	
	private String recordStatus;
	
	private int versionNo ;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getTimeSheetID() {
		return timeSheetID;
	}

	public void setTimeSheetID(Long timeSheetID) {
		this.timeSheetID = timeSheetID;
	}

	public int getTotalRegularHours() {
		return totalRegularHours;
	}

	public void setTotalRegularHours(int totalRegularHours) {
		this.totalRegularHours = totalRegularHours;
	}

	public int getTotalActualHours() {
		return totalActualHours;
	}

	public void setTotalActualHours(int totalActualHours) {
		this.totalActualHours = totalActualHours;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
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

	public String getTimeSheetStatus() {
		return timeSheetStatus;
	}

	public void setTimeSheetStatus(String timeSheetStatus) {
		this.timeSheetStatus = timeSheetStatus;
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