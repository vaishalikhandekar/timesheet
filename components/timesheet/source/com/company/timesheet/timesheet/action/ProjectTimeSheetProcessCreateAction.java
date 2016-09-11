/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.ProjectTimeSheetProcessCreateDAO;
import com.company.timesheet.timesheet.dao.ProjectTimeSheetProcessListDAO;
import com.company.timesheet.timesheet.pojo.ProjectTimeSheetProcessDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectTimeSheetProcessCreateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail;

	
	public ProjectTimeSheetProcessDetail getProjectTimeSheetProcessDetail() {
		return projectTimeSheetProcessDetail;
	}

	public void setProjectTimeSheetProcessDetail(
			ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail) {
		this.projectTimeSheetProcessDetail = projectTimeSheetProcessDetail;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";
		
		ProjectTimeSheetProcessCreateDAO projectTimeSheetProcessCreateDAO = new ProjectTimeSheetProcessCreateDAO();
		
		String returnMassegeStr = projectTimeSheetProcessCreateDAO.createProjectTimeSheetProcess(projectTimeSheetProcessDetail);
		
		if ( returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
