/**
 * 
 */
package com.company.timesheet.profile.person.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.dao.PersonUpdateDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonProjectListAction extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
	private PersonDetail personDetail;

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	
	@Override
	public String execute() throws Exception {
	
		String pageForwardStr = "";

		PersonUpdateDAO updatepersonDAO = new PersonUpdateDAO();
		String returnMassegeStr = updatepersonDAO.updatePerson(personDetail);
		setPersonDetail(personDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
		
	}

}
