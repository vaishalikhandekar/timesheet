package com.company.timesheet.profile.person.pojo;

public class PersonSearchDetails {

	private PersonSearchCriteria	personSearchCriteria;

	private PersonSearchResult		personSearchResult;
	
	private String errorMessage;

	public PersonSearchCriteria getpersonSearchCriteria() {

		return personSearchCriteria;
	}

	public void setpersonSearchCriteria(PersonSearchCriteria personSearchCriteria) {

		this.personSearchCriteria = personSearchCriteria;
	}

	public PersonSearchResult getpersonSearchResult() {

		return personSearchResult;
	}

	public void setpersonSearchResult(PersonSearchResult personSearchResult) {

		this.personSearchResult = personSearchResult;
	}

	
	public String getErrorMessage() {
	
		return errorMessage;
	}

	
	public void setErrorMessage(String errorMessage) {
	
		this.errorMessage = errorMessage;
	}

	
	

}
