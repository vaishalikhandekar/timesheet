/**
 * 
 */
package com.company.timesheet.profile.employee.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.ReadEmployeeDAO;
import com.company.timesheet.profile.employee.dao.UpdateEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class UpdateEmployeeAction extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
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

		UpdateEmployeeDAO updateEmployeeDAO = new UpdateEmployeeDAO();
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
