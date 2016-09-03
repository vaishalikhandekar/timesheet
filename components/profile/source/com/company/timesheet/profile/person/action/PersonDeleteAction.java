/**
 * 
 */
package com.company.timesheet.profile.person.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonDeleteDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonDeleteAction extends ActionSupport {
	
	private PersonDetail employeeDetail;
	
	public PersonDetail getEmployeeDetail() {
		return employeeDetail;
	}



	public void setEmployeeDetail(PersonDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}



	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		PersonDeleteDAO deleteEmployeeDAO = new PersonDeleteDAO();
		String returnMassegeStr = deleteEmployeeDAO.deleteEmployee(employeeDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	
	}

}
