/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.projectpersonlink.dao.CreateProjectEmployeeLinkDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class CreateProjectEmployeeLinkAction extends ActionSupport {
	
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
		
		System.out.println("projectPersonLinkDetail.projectDetail.projectID");
		
		CreateProjectEmployeeLinkDAO createProjectEmployeeLinkDAO = new CreateProjectEmployeeLinkDAO();
		String returnMassegeStr = createProjectEmployeeLinkDAO.CreateProjectEmployeeLink(projectPersonLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		
		return pageForwardStr;
		
	}

}
