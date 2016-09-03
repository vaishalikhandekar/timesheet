package com.company.timesheet.project.pojo;

public class ProjectSearchDetails {

	private ProjectSearchCriteria	projectSearchCriteria	= null;

	private ProjectSearchResult		projectSearchResult		= null;
	
	private String errorMessage;

	public ProjectSearchCriteria getProjectSearchCriteria() {
		return projectSearchCriteria;
	}


	public void setProjectSearchCriteria(ProjectSearchCriteria projectSearchCriteria) {
		this.projectSearchCriteria = projectSearchCriteria;
	}


	public ProjectSearchResult getProjectSearchResult() {
		return projectSearchResult;
	}


	public void setProjectSearchResult(ProjectSearchResult projectSearchResult) {
		this.projectSearchResult = projectSearchResult;
	}


	public String getErrorMessage() {
	
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
	
		this.errorMessage = errorMessage;
	}

	
	

}
