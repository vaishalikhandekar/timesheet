/**
 * 
 */
package com.company.timesheet.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.dao.ProjectReadDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectTeamsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	private ProjectDetail projectDetail = null;
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

	/**
	 * 
	 */
	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		ProjectReadDAO readProjectDAO = new ProjectReadDAO();
		String returnMassegeStr = readProjectDAO.readProject(projectDetail);
		setProjectDetail(projectDetail);
		
		if (act != null && act.equals("update")
				&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
