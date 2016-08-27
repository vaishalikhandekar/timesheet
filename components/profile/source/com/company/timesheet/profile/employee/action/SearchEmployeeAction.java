package com.company.timesheet.profile.employee.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.SearchEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.company.timesheet.profile.employee.pojo.EmployeeSearchDetails;
import com.company.timesheet.profile.employee.pojo.EmployeeSearchResult;
import com.company.timesheet.profile.employee.pojo.EmployeeSearchDetails;
import com.company.timesheet.profile.employee.pojo.EmployeeSearchResult;
import com.company.timesheet.profile.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

public class SearchEmployeeAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	HttpServletRequest request;
	

	

	public  EmployeeSearchDetails employeeSearchDetails;
	public EmployeeSearchResult employeeSearchResult;

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
	public EmployeeSearchDetails getEmployeeSearchDetails() {
		return employeeSearchDetails;
	}

	/**
	 * @param personSearchDetails
	 *            the personSearchDetails to set
	 */
	public void setPersonSearchDetails(EmployeeSearchDetails employeeSearchDetails) {
		this.employeeSearchDetails = employeeSearchDetails;
	}


	/**
	 * @return the employeeSearchResult
	 */
	public EmployeeSearchResult getEmployeeSearchResult() {
		return employeeSearchResult;
	}

	/**
	 * @param personSearchResult the personSearchResult to set
	 */
	public void setEmployeeSearchResult(EmployeeSearchResult employeeSearchResult) {
		this.employeeSearchResult = employeeSearchResult;
	}
	
	
	public String execute() throws Exception {

		String pageForwardStr = "";

		SearchEmployeeDAO searchPersonDAO = new SearchEmployeeDAO();
		List<EmployeeDetail> employeeDetailList = searchPersonDAO.searchEmployeeInfo(employeeSearchDetails);

		long numberOfEmployee = employeeDetailList.size();
	

		this.employeeSearchResult = new EmployeeSearchResult();

		employeeSearchResult.setNumberOfEmployee(numberOfEmployee);
		employeeSearchResult.setEmployeeDetailList(employeeDetailList);

		//personSearchDetails.setPersonSearchResult(personSearchResult);
		
		
				//Set EmployeeID into ProjectPersonLinkDetail
				
				ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
					
				EmployeeDetail employeeDetail = employeeDetailList.get(0);
				projectPersonLinkDetail.setEmployeeDetail(employeeDetail);
			
		if (employeeDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

}
