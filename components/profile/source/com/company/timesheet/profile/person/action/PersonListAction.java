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

	private List<PersonDetail> personDetailList;

	private PersonDetail personDetail;

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	public List<PersonDetail> getPersonDetailList() {
		return personDetailList;
	}

	public void setPersonDetailList(List<PersonDetail> personDetailList) {
		this.personDetailList = personDetailList;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		PersonListDAO listPersonDAO = new PersonListDAO();
		List<PersonDetail> personDetailList = listPersonDAO.listPerson();

		setPersonDetailList(personDetailList);

		// personDetail = personDetailList.get(0);
		// setPersonDetail(personDetail);

		if (personDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;

	}

}
