package com.company.timesheet.profile.person.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonSearchDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.PersonSearchDetails;
import com.company.timesheet.profile.person.pojo.PersonSearchResult;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PersonSearchAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;

	public  PersonDetail personDetail;
	public  PersonSearchDetails personSearchDetails;
	public PersonSearchResult personSearchResult;

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	public PersonSearchDetails getPersonSearchDetails() {
		return personSearchDetails;
	}

	public void setPersonSearchDetails(PersonSearchDetails personSearchDetails) {
		this.personSearchDetails = personSearchDetails;
	}

	public PersonSearchResult getPersonSearchResult() {
		return personSearchResult;
	}

	public void setPersonSearchResult(PersonSearchResult personSearchResult) {
		this.personSearchResult = personSearchResult;
	}

	public void setSession(Map<String, Object> sessionInput) {
		this.session = sessionInput;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	
	public String execute() throws Exception {

		String pageForwardStr = "";

		PersonSearchDAO searchPersonDAO = new PersonSearchDAO();
		List<PersonDetail> personDetailList = searchPersonDAO.searchpersonInfo(personSearchDetails);

		long numberOfperson = personDetailList.size();
	

		this.personSearchResult = new PersonSearchResult();

		personSearchResult.setNumberOfPerson(numberOfperson);
		personSearchResult.setPersonDetailList(personDetailList);

		//personSearchDetails.setPersonSearchResult(personSearchResult);
		
		
				//Set personID into ProjectPersonLinkDetail
				
				ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
					
				 personDetail = personDetailList.get(0);
				 setPersonDetail(personDetail);
				
				//projectPersonLinkDetail.setProjectDetail(personDetail);
			
		if (personDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

}
