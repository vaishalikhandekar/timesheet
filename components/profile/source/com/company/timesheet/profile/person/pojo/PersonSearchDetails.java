package com.company.timesheet.profile.person.pojo;

public class PersonSearchDetails {

	private PersonSearchCriteria	employeeSearchCriteria;

	private PersonSearchResult		employeeSearchResult;
	
	private String errorMessage;

	public PersonSearchCriteria getEmployeeSearchCriteria() {

		return employeeSearchCriteria;
	}

	public void setEmployeeSearchCriteria(PersonSearchCriteria employeeSearchCriteria) {

		this.employeeSearchCriteria = employeeSearchCriteria;
	}

	public PersonSearchResult getEmployeeSearchResult() {

		return employeeSearchResult;
	}

	public void setEmployeeSearchResult(PersonSearchResult employeeSearchResult) {

		this.employeeSearchResult = employeeSearchResult;
	}

	
	public String getErrorMessage() {
	
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
	
		this.errorMessage = errorMessage;
	}

	
	

}
