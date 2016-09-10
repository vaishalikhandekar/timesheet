/**
 * 
 */
package com.company.timesheet.project.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ProjectDetail {

	private String projectName;
	
	private Long projectID;
	
	private Long personID;
	
	private String description;
	
	private String recordStatus;
	
	private int versionNo;
	
	private Date startDate;
	
	private Date endDate;
	
	private String comments;
	
	private String acronym;
	
	List<String> errorMessageList = new ArrayList<String>();
	
	private String updateAction = "update";
	
	private ProjectPersonLinkDetail projectPersonLinkDetail;
	
	private PersonDetail personDetail;
	
	public String getUpdateAction() {
		return updateAction;
	}

	public void setUpdateAction(String updateAction) {
		this.updateAction = updateAction;
	}


	
	public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}

	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public Long getPersonID() {
		return personID;
	}

	public void setPersonID(Long personID) {
		this.personID = personID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public List<String> getErrorMessageList() {
		return errorMessageList;
	}

	public void setErrorMessageList(List<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}
	
	
}
