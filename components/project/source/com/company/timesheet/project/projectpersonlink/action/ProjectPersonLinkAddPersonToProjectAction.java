/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonSearchDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.PersonSearchDetails;
import com.company.timesheet.profile.person.pojo.PersonSearchResult;
import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonLinkCreateDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkAddPersonToProjectAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	ProjectPersonLinkDetail projectPersonLinkDetail;

	

		public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}
	
	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}
	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		//System.out.println("projectPersonLinkDetail.projectDetail.projectID");
		
		
		
		
		
		ProjectPersonLinkCreateDAO createProjectEmployeeLinkDAO = new ProjectPersonLinkCreateDAO();
		String returnMassegeStr = createProjectEmployeeLinkDAO.CreateProjectEmployeeLink(projectPersonLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		
		
		return pageForwardStr;
		
	}
	

}
