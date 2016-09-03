/**
 * 
 */
package com.company.timesheet.profile.person.action;

import java.util.List;

import com.company.timesheet.profile.person.dao.PersonListDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<PersonDetail> employeeDetailList;
	
	private PersonDetail employeeDetail;
	
	public PersonDetail getEmployeeDetail() {
		return employeeDetail;
	}



	public void setEmployeeDetail(PersonDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}



	public List<PersonDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}



	public void setEmployeeDetailList(List<PersonDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}


	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		PersonListDAO listEmployeeDAO = new PersonListDAO();
		List<PersonDetail> employeeDetailList = listEmployeeDAO.listEmployee();
		
		setEmployeeDetailList(employeeDetailList);
		
		PersonDetail employeeDetail =  employeeDetailList.get(0);
		setEmployeeDetail(employeeDetail);
		
		
		if (employeeDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
		
	}

}
