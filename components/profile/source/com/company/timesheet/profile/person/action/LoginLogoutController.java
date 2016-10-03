package com.company.timesheet.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.company.timesheet.profile.person.dao.PersonDAOImpl;
import com.company.timesheet.profile.person.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginLogoutController extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String execute() throws Exception {

		String pageForwardStr = "success";
		
		
		return pageForwardStr;
	}
	
	public String checkLogin() throws Exception {
		
		try{
		
		PersonDAOImpl personDAOImpl = new PersonDAOImpl();
		HttpServletRequest request = ServletActionContext.getRequest();
		String projectCount = personDAOImpl.liveProjectCount();
		
		request.setAttribute("projectCount",projectCount);
		} catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		return "success";
		
	
	}
	

}
