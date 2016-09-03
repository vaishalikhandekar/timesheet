/**
 * 
 */
package com.company.timesheet.profile.person.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.dao.PersonUpdateDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonUpdateAction extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
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

		PersonUpdateDAO updateEmployeeDAO = new PersonUpdateDAO();
		String returnMassegeStr = updateEmployeeDAO.updateEmployee(employeeDetail);
		setEmployeeDetail(employeeDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
		
	}

}
