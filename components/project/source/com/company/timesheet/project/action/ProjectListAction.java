/**
 * 
 */
package com.company.timesheet.project.action;

import java.util.List;

import com.company.timesheet.project.dao.ProjectListDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectListAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<ProjectDetail> projectDetailList;
	
	public List<ProjectDetail> getProjectDetailList() {
		return projectDetailList;
	}

	public void setProjectDetailList(List<ProjectDetail> projectDetailList) {
		this.projectDetailList = projectDetailList;
	}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ProjectListDAO listProjectDAO = new ProjectListDAO();
		List<ProjectDetail> projectDetailList = listProjectDAO.listProject();
		
		setProjectDetailList(projectDetailList);
		
		
		if (projectDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		
		return pageForwardStr;
	}

}
