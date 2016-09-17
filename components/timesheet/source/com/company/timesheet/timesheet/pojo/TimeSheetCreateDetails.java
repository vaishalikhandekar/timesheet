package com.company.timesheet.timesheet.pojo;

import java.util.Date;


public class TimeSheetCreateDetails {

    private Long timeSheetID;

    private Long projectTimeSheetProcessID;

    private Long projectPersonLinkID;

    private Long personID;
    
    private Long projectID;
    
    private Date startDate;

	/**
	 * @return the timeSheetID
	 */
	public Long getTimeSheetID() {
		return timeSheetID;
	}

	/**
	 * @param timeSheetID the timeSheetID to set
	 */
	public void setTimeSheetID(Long timeSheetID) {
		this.timeSheetID = timeSheetID;
	}

	/**
	 * @return the projectTimeSheetProcessID
	 */
	public Long getProjectTimeSheetProcessID() {
		return projectTimeSheetProcessID;
	}

	/**
	 * @param projectTimeSheetProcessID the projectTimeSheetProcessID to set
	 */
	public void setProjectTimeSheetProcessID(Long projectTimeSheetProcessID) {
		this.projectTimeSheetProcessID = projectTimeSheetProcessID;
	}

	/**
	 * @return the projectPersonLinkID
	 */
	public Long getProjectPersonLinkID() {
		return projectPersonLinkID;
	}

	/**
	 * @param projectPersonLinkID the projectPersonLinkID to set
	 */
	public void setProjectPersonLinkID(Long projectPersonLinkID) {
		this.projectPersonLinkID = projectPersonLinkID;
	}

	/**
	 * @return the personID
	 */
	public Long getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(Long personID) {
		this.personID = personID;
	}

	/**
	 * @return the projectID
	 */
	public Long getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

    

}