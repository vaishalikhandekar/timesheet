
package com.company.timesheet.profile.person.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonLoginDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.UsersDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rahul
 */
public class PersonLoginAction extends ActionSupport implements SessionAware, ServletRequestAware {

    /**
     * 
     */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	private Map<String, Object> session;
	HttpServletRequest request;
	private UsersDetail usersDetail;
	private PersonDetail personDetail;

	/**
	 * @return the usersDetail
	 */
	public UsersDetail getUsersDetail() {
		return usersDetail;
	}

	/**
	 * @param usersDetail
	 *            the usersDetail to set
	 */
	public void setUsersDetail(UsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}

	public void setSession(Map<String, Object> sessionInput) {

		this.session = sessionInput;

	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getServletRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	public String execute() throws Exception {

		String pageForwardStr = "";

		/*
		 * boolean errorInd = validateLoginDetails(request, usersDetail); if
		 * (errorInd) {
		 * 
		 * pageForwardStr = ERROR;
		 * 
		 * } else {
		 */

		PersonLoginDAO loginPersonDAO = new PersonLoginDAO();
		String returnMassegeStr = loginPersonDAO.login(usersDetail);
		session.put("personID", usersDetail.getPersonID());
		
		//personDetail.setPersonID(usersDetail.getPersonID());
		//setPersonDetail(personDetail);

		if (returnMassegeStr.equals(CRUDConstants.RETURN_MESSAGE_SUCCESS)) {

			pageForwardStr = SUCCESS;
		 //pageForwardStr += "?personID=" + usersDetail.getPersonID();

		} else {

			pageForwardStr = ERROR;

		}
		// }
		return pageForwardStr;
	}

	/*
	 * private boolean validateLoginDetails(HttpServletRequest request,
	 * UsersDetail usersDetail)
	 * 
	 * { List<String> errorMessageList = new ArrayList<String>();
	 * 
	 * String userName = (String) getServletRequest().getParameter("userName");
	 * if (userName == null || userName.equals("")) {
	 * errorMessageList.add("Please	enter	username."); } else { try {
	 * usersDetail.setUserName(userName);
	 * 
	 * } catch (Exception E) {
	 * 
	 * } } String password = (String)
	 * getServletRequest().getParameter("password"); if (password == null ||
	 * password.equals("")) { errorMessageList.add("Please	enter	password."); }
	 * else { try { usersDetail.setPassword(password);
	 * 
	 * } catch (Exception E) {
	 * 
	 * } }
	 * 
	 * personDetail.setUsersDetail(usersDetail);
	 * usersDetail.setErrorMessageList(errorMessageList);
	 * session.put("usersDetail", usersDetail); return
	 * !errorMessageList.isEmpty(); }
	 */

}
