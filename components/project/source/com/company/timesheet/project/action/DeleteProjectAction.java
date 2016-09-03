/**
 * 
 */
package com.company.timesheet.project.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.dao.DeleteProjectDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class DeleteProjectAction extends ActionSupport {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProjectDetail projectDetail = null;
	
	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String execute() throws Exception {
		
		System.out.println("projectId" +projectDetail.getProjectID());
		
		String pageForwardStr = "";
		
		DeleteProjectDAO deleteProjectDAO = new DeleteProjectDAO();
		String returnMassegeStr = deleteProjectDAO.deleteProject(projectDetail);
		
		
		// 
		
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		

		return pageForwardStr;
	
		
	}
	
}
