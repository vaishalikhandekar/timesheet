/**
 * 
 */
package com.company.timesheet.profile.person.action;

import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonProjectListDAO;
import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.dao.PersonUpdateDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonProjectListAction extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
	private PersonDetail personDetail;
	List<ProjectPersonLinkDetail>  projectPersonLinkDetailList;
	

	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	
	public List<ProjectPersonLinkDetail> getProjectPersonLinkDetailList() {
		return projectPersonLinkDetailList;
	}

	public void setProjectPersonLinkDetailList(
			List<ProjectPersonLinkDetail> projectPersonLinkDetailList) {
		this.projectPersonLinkDetailList = projectPersonLinkDetailList;
	}

	@Override
	public String execute() throws Exception {
	
		String pageForwardStr = "";

		PersonProjectListDAO personProjectListDAO  = new PersonProjectListDAO();
		List<ProjectPersonLinkDetail>  projectPersonLinkDetailList = personProjectListDAO.listProject(personDetail);

		setProjectPersonLinkDetailList(projectPersonLinkDetailList);
		
		if (projectPersonLinkDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
		
	}

}
