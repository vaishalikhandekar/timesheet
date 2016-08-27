/**
 * 
 */
package com.company.timesheet.profile.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.project.dao.CreateProjectDAO;
import com.company.timesheet.profile.project.dao.ReadProjectDAO;
import com.company.timesheet.profile.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadProjectAction extends ActionSupport {

	private ProjectDetail projectDetail;
	String act = "";

	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
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

		ReadProjectDAO readProjectDAO = new ReadProjectDAO();
		String returnMassegeStr = readProjectDAO.readProject(projectDetail);
		
		if (act != null && act.equals("update")
				&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
