/**
 * 
 */
package com.company.timesheet.profile.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.employee.dao.UpdateEmployeeDAO;
import com.company.timesheet.profile.project.dao.UpdateProjectDAO;
import com.company.timesheet.profile.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class UpdateProjectAction extends ActionSupport {
		
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
		
		UpdateProjectDAO updateProjectDAO = new UpdateProjectDAO();
		String returnMassegeStr = updateProjectDAO.updateProject(projectDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	
		
	}

}
