/**
 * 
 */
package com.company.timesheet.profile.person.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonReadAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private PersonDetail employeeDetail;
	String act = "";

	public PersonDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(PersonDetail employeeDetail) {
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

		PersonReadDAO readEmployeeDAO = new PersonReadDAO();
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
