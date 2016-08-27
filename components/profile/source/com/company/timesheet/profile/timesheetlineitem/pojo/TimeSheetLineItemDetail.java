package com.company.timesheet.profile.timesheetlineitem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.timesheet.profile.timesheet.pojo.TimeSheetDetail;

public class TimeSheetLineItemDetail {
		
	private Long timeSheetLineItemID;
	
	private String category;
	
	private Date attendenceDate;
	
	private int actualRegularHoursWorked;
	
	private int actualOvertimeHoursWorked;
	
	private Date startDate;
	
	private Date endDate;
	
	private String comments;
	
	private String recordStatus;

	private int versionNo;
	
	private TimeSheetDetail timeSheetDetail;
	
	private String updateAction = "update";
	
	List<String> errorMessageList = new ArrayList<String>();

	public Long getTimeSheetLineItemID() {
		return timeSheetLineItemID;
	}

	public void setTimeSheetLineItemID(Long timeSheetLineItemID) {
		this.timeSheetLineItemID = timeSheetLineItemID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getAttendenceDate() {
		return attendenceDate;
	}

	public void setAttendenceDate(Date attendenceDate) {
		this.attendenceDate = attendenceDate;
	}

	public int getActualRegularHoursWorked() {
		return actualRegularHoursWorked;
	}

	public void setActualRegularHoursWorked(int actualRegularHoursWorked) {
		this.actualRegularHoursWorked = actualRegularHoursWorked;
	}

	public int getActualOvertimeHoursWorked() {
		return actualOvertimeHoursWorked;
	}

	public void setActualOvertimeHoursWorked(int actualOvertimeHoursWorked) {
		this.actualOvertimeHoursWorked = actualOvertimeHoursWorked;
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

	public TimeSheetDetail getTimeSheetDetail() {
		return timeSheetDetail;
	}

	public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
		this.timeSheetDetail = timeSheetDetail;
	}

	public String getUpdateAction() {
		return updateAction;
	}

	public void setUpdateAction(String updateAction) {
		this.updateAction = updateAction;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
		
}
