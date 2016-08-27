package com.company.timesheet.profile.employee.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.RegisterEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.opensymphony.xwork2.ActionSupport;

public class CreateEmployeeAction extends ActionSupport implements
		SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	public EmployeeDetail employeeDetail;

	public void setSession(Map<String, Object> sessionInput) {
		this.session = sessionInput;
	}

	
	/**
	 * @return the personDetail
	 */
	public EmployeeDetail getEmployeeDetail() {
		return this.employeeDetail;
	}

	/**
	 * @param personDetail
	 *            the personDetail to set
	 */
	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		RegisterEmployeeDAO registerEmployeeDAO = new RegisterEmployeeDAO();
		String returnMassegeStr = registerEmployeeDAO
				.registerEmployee(employeeDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;
	}
	
	/*public void validate() {
	System.out.println("inside validate method");
	String letters = "/^[A-Za-z]+$/";
	// Validation for First Name

	if (personDetail.getFirstName() == null || personDetail.getFirstName().trim().equals("")) {
		addFieldError("personDetail.firstName", "The FirstName is required");
	} else if (!personDetail.getFirstName().matches(letters)) {

		addFieldError("personDetail.firstName", "FirstName must contain ablphabet");
	}

	// Validation for Middle Name

	if (personDetail.getMiddleName() == null || personDetail.getMiddleName().trim().equals("")) {
		addFieldError("personDetail.middleName", "The MiddleName is required");
	} else if (!personDetail.getMiddleName().matches(letters)) {

		addFieldError("personDetail.middleName", "MiddleName must contain ablphabet");
	}

	// Validation for Last Name

	if (personDetail.getLastName() == null || personDetail.getLastName().trim().equals("")) {
		addFieldError("personDetail.lastName", "The LastName is required");
	} else if (!personDetail.getLastName().matches(letters)) {

		addFieldError("personDetail.lastName", "LastName must contain ablphabet");
	}

	// Validation for User Name and Password

	if (personDetail.getUsersDetail().getUserName().length() == 0) {
		addFieldError("personDetail.usersDetail.userName", "UserName.required");
	} else if (!personDetail.getUsersDetail().getUserName().equals("")) {
		addFieldError("userName", "Invalid User");
	}
	if (personDetail.getUsersDetail().getPassword().length() == 0) {
		addFieldError("personDetail.usersDetail.password", getText("password.required"));
	} else if (personDetail.getUsersDetail().getPassword().length() < 6) {
		addFieldError("personDetail.usersDetail.password", "Password must be minimum of 6 characters");
	}
*/

}
