package com.company.timesheet.profile.person.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;

public class PersonSearchResult {

	List<PersonDetail>	EmployeeDetailList	= new ArrayList<PersonDetail>();

	Long				numberOfEmployee;

	public List<PersonDetail> getEmployeeDetailList() {

		return EmployeeDetailList;
	}

	public void setEmployeeDetailList(List<PersonDetail> EmployeeDetailList) {

		this.EmployeeDetailList = EmployeeDetailList;
	}

	public Long getNumberOfEmployee() {

		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Long numberOfEmployee) {

		this.numberOfEmployee = numberOfEmployee;
	}

}
