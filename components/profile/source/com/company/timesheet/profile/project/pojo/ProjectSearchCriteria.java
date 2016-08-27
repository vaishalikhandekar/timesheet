/**
 * 
 */
package com.company.timesheet.profile.project.pojo;

import java.util.Date;

/**
 * @author vaish
 *
 */
public class ProjectSearchCriteria {
	
	private String projectName;
	private Date startDate;
	private Date endDate;

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

}
