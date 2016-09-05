/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.projectpersonlink.dao.ReadProjectEmployeeLinkDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadProjectEmployeeLinkAction extends ActionSupport {
		
	ProjectPersonLinkDetail projectPersonLinkDetail;
	String act = "";
	
	public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}

	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@Override
	public String execute() throws Exception {
		
				String pageForwardStr = "";
				
		ReadProjectEmployeeLinkDAO readProjectEmployeeLinkDAO = new ReadProjectEmployeeLinkDAO();
		String returnMassegeStr = readProjectEmployeeLinkDAO.readProjectEmployeeLink(projectPersonLinkDetail);
		
		if (act != null && act.equals("update")
				&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
