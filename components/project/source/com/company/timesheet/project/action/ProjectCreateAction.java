/**
 * 
 */
package com.company.timesheet.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.dao.ProjectCreateDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectCreateAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private ProjectDetail projectDetail;
	
	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ProjectCreateDAO createProjectDAO = new ProjectCreateDAO();
		String returnMassegeStr = createProjectDAO.createProject(projectDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		
		return pageForwardStr;
	}

}
