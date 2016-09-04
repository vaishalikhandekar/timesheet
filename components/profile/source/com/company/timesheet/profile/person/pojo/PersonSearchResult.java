package com.company.timesheet.profile.person.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;

public class PersonSearchResult {

	List<PersonDetail>	PersonDetailList	= new ArrayList<PersonDetail>();

	Long				numberOfPerson;

	public List<PersonDetail> getPersonDetailList() {

		return PersonDetailList;
	}

	public void setPersonDetailList(List<PersonDetail> PersonDetailList) {

		this.PersonDetailList = PersonDetailList;
	}

	public Long getNumberOfPerson() {

		return numberOfPerson;
	}

	public void setNumberOfPerson(Long numberOfPerson) {

		this.numberOfPerson = numberOfPerson;
	}

}
