package com.company.timesheet.timesheet.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeSheetLineItemDetail {
		
	private Long timeSheetLineItemID;
	
	private Long timeSheetID;
	
	private String category;
	
	private Date attendenceDate;
	
	private int noOfHoursWorked;
	
	private String comments;
	
	private String recordStatus;

	private int versionNo;
	
	private TimeSheetDetail timeSheetDetail;
	
	private String updateAction = "update";
	
	List<String> errorMessageList = new ArrayList<String>();

	private String dayOfWeek;
    
    public Long getTimeSheetLineItemID() {
    
        return timeSheetLineItemID;
    }

    
    public void setTimeSheetLineItemID(Long timeSheetLineItemID) {
    
        this.timeSheetLineItemID = timeSheetLineItemID;
    }

    
    public Long getTimeSheetID() {
    
        return timeSheetID;
    }

    
    public void setTimeSheetID(Long timeSheetID) {
    
        this.timeSheetID = timeSheetID;
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

    
    public int getNoOfHoursWorked() {
    
        return noOfHoursWorked;
    }

    
    public void setNoOfHoursWorked(int noOfHoursWorked) {
    
        this.noOfHoursWorked = noOfHoursWorked;
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


    
    public String getDayOfWeek() {
    
        return dayOfWeek;
    }


    
    public void setDayOfWeek(String dayOfWeek) {
    
        this.dayOfWeek = dayOfWeek;
    }
	
	
	

	}
