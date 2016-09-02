/**
 * 
 */
package com.company.timesheet.profile.employee.action;

import java.util.List;

import com.company.timesheet.profile.employee.dao.ListEmployeeDAO;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ListEmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<EmployeeDetail> employeeDetailList;
	
	private EmployeeDetail employeeDetail;
	
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}



	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}



	public List<EmployeeDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}



	public void setEmployeeDetailList(List<EmployeeDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}


	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ListEmployeeDAO listEmployeeDAO = new ListEmployeeDAO();
		List<EmployeeDetail> employeeDetailList = listEmployeeDAO.listEmployee();
		
		setEmployeeDetailList(employeeDetailList);
		
		EmployeeDetail employeeDetail =  employeeDetailList.get(0);
		setEmployeeDetail(employeeDetail);
		
		
		if (employeeDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
		
	}

}
