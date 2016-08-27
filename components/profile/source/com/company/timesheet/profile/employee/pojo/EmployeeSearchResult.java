package com.company.timesheet.profile.employee.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.profile.employee.pojo.EmployeeDetail;

public class EmployeeSearchResult {

	List<EmployeeDetail>	EmployeeDetailList	= new ArrayList<EmployeeDetail>();

	Long				numberOfEmployee;

	public List<EmployeeDetail> getEmployeeDetailList() {

		return EmployeeDetailList;
	}

	public void setEmployeeDetailList(List<EmployeeDetail> EmployeeDetailList) {

		this.EmployeeDetailList = EmployeeDetailList;
	}

	public Long getNumberOfEmployee() {

		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Long numberOfEmployee) {

		this.numberOfEmployee = numberOfEmployee;
	}

}
