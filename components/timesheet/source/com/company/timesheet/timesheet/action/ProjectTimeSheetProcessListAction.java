/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.ProjectTimeSheetProcessListDAO;
import com.company.timesheet.timesheet.pojo.ProjectTimeSheetProcessDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectTimeSheetProcessListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<ProjectTimeSheetProcessDetail> projectTimeSheetProcessDetailList;

	private ProjectDetail projectDetail;
	
	public List<ProjectTimeSheetProcessDetail> getProjectTimeSheetProcessDetailList() {
		return projectTimeSheetProcessDetailList;
	}

	public void setProjectTimeSheetProcessDetailList(
			List<ProjectTimeSheetProcessDetail> projectTimeSheetProcessDetailList) {
		this.projectTimeSheetProcessDetailList = projectTimeSheetProcessDetailList;
	}

	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";
		
		ProjectTimeSheetProcessListDAO projectTimeSheetProcessListDAO = new ProjectTimeSheetProcessListDAO();
		List<ProjectTimeSheetProcessDetail> projectTimeSheetProcessDetailList = projectTimeSheetProcessListDAO.projectTimeSheetProcessList(projectDetail);

		setProjectTimeSheetProcessDetailList(projectTimeSheetProcessDetailList);
		
		if ( projectTimeSheetProcessDetailList!= null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
