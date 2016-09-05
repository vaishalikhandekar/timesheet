/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.projectpersonlink.dao.DeleteProjectEmployeeLinkDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class DeleteProjectEmployeeLinkAction extends ActionSupport {
		
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
		
		DeleteProjectEmployeeLinkDAO deleteProjectEmployeeLinkDAO = new DeleteProjectEmployeeLinkDAO();
		String returnMassegeStr = deleteProjectEmployeeLinkDAO.DeleteProjectEmployeeLink(projectPersonLinkDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
		
	}

}
