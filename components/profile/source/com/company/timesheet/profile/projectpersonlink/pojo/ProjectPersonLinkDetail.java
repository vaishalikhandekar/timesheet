/**
 * 
 */
package com.company.timesheet.profile.projectpersonlink.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkDetail {
		
	private Long projectPersonLinkID;
	
	private Long projectID;
	
	private Long employeeID;
	
	private String role;
	
	private String comments;
	
	private Date startDate;
	
	private Date endDate;
	
	private int versionNo;
	
	private String recordStatus;
	
	private ProjectDetail projectDetail;
	
	private PersonDetail employeeDetail;
	
	List<String> errorMessageList = new ArrayList<String>();

	
	public Long getProjectPersonLinkID() {
		return projectPersonLinkID;
	}

	public void setProjectPersonLinkID(Long projectPersonLinkID) {
		this.projectPersonLinkID = projectPersonLinkID;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public Long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public int getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	public PersonDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(PersonDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}
	
	
}
