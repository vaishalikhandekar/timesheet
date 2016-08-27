/**
 * 
 */
package com.company.timesheet.profile.employee.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.ReadEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadEmployeeAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EmployeeDetail employeeDetail;
	String act = "";

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";

		ReadEmployeeDAO readEmployeeDAO = new ReadEmployeeDAO();
		String returnMassegeStr = readEmployeeDAO.readEmployee(employeeDetail);
		
		// session.put("addressLinkDetail", addressLinkDetail);

		if (act != null && act.equals("update") && returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			
			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;
		}

		return pageForwardStr;
		
	}
	

}
