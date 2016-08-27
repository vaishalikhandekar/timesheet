package com.company.timesheet.profile.employee.pojo;

public class EmployeeSearchDetails {

	private EmployeeSearchCriteria	employeeSearchCriteria;

	private EmployeeSearchResult		employeeSearchResult;
	
	private String errorMessage;

	public EmployeeSearchCriteria getEmployeeSearchCriteria() {

		return employeeSearchCriteria;
	}

	public void setEmployeeSearchCriteria(EmployeeSearchCriteria employeeSearchCriteria) {

		this.employeeSearchCriteria = employeeSearchCriteria;
	}

	public EmployeeSearchResult getEmployeeSearchResult() {

		return employeeSearchResult;
	}

	public void setEmployeeSearchResult(EmployeeSearchResult employeeSearchResult) {

		this.employeeSearchResult = employeeSearchResult;
	}

	
	public String getErrorMessage() {
	
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
	
		this.errorMessage = errorMessage;
	}

	
	

}
