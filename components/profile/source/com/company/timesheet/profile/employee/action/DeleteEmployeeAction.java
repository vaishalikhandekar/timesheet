/**
 * 
 */
package com.company.timesheet.profile.employee.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.DeleteEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class DeleteEmployeeAction extends ActionSupport {
	
	private EmployeeDetail employeeDetail;
	
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}



	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}



	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		DeleteEmployeeDAO deleteEmployeeDAO = new DeleteEmployeeDAO();
		String returnMassegeStr = deleteEmployeeDAO.deleteEmployee(employeeDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	
	}

}
