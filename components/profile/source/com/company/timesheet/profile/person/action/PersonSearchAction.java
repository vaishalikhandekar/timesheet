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
import com.company.timesheet.profile.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class PersonSearchAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	

	

	public  PersonSearchDetails employeeSearchDetails;
	public PersonSearchResult employeeSearchResult;

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

	/**
	 * @return the personSearchDetails
	 */
	public PersonSearchDetails getEmployeeSearchDetails() {
		return employeeSearchDetails;
	}

	/**
	 * @param personSearchDetails
	 *            the personSearchDetails to set
	 */
	public void setPersonSearchDetails(PersonSearchDetails employeeSearchDetails) {
		this.employeeSearchDetails = employeeSearchDetails;
	}


	/**
	 * @return the employeeSearchResult
	 */
	public PersonSearchResult getEmployeeSearchResult() {
		return employeeSearchResult;
	}

	/**
	 * @param personSearchResult the personSearchResult to set
	 */
	public void setEmployeeSearchResult(PersonSearchResult employeeSearchResult) {
		this.employeeSearchResult = employeeSearchResult;
	}
	
	
	public String execute() throws Exception {

		String pageForwardStr = "";

		PersonSearchDAO searchPersonDAO = new PersonSearchDAO();
		List<PersonDetail> employeeDetailList = searchPersonDAO.searchEmployeeInfo(employeeSearchDetails);

		long numberOfEmployee = employeeDetailList.size();
	

		this.employeeSearchResult = new PersonSearchResult();

		employeeSearchResult.setNumberOfEmployee(numberOfEmployee);
		employeeSearchResult.setEmployeeDetailList(employeeDetailList);

		//personSearchDetails.setPersonSearchResult(personSearchResult);
		
		
				//Set EmployeeID into ProjectPersonLinkDetail
				
				ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
					
				PersonDetail employeeDetail = employeeDetailList.get(0);
				projectPersonLinkDetail.setEmployeeDetail(employeeDetail);
			
		if (employeeDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

}
