/**
 * 
 */
package com.company.timesheet.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.dao.ProjectUpdateDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectUpdateAction extends ActionSupport {
		
	ProjectDetail projectDetail;
	
	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String execute() throws Exception {
	
		String pageForwardStr = "";
		
		ProjectUpdateDAO updateProjectDAO = new ProjectUpdateDAO();
		String returnMassegeStr = updateProjectDAO.updateProject(projectDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	
		
	}

}
