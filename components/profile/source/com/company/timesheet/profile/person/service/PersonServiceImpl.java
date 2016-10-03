/**
 * 
 */
package com.company.timesheet.profile.person.service;

import com.company.timesheet.profile.person.dao.PersonDAO;

/**
 * @author Admin
 *
 */
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;
	
	

	public PersonDAO getPersonDAO() {
		return personDAO;
	}



	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}



	@Override
	public String liveProjectCount() {
		// TODO Auto-generated method stub
		return this.personDAO.liveProjectCount();
	}

	

}
