/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import java.util.List;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonListForProjectDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectPersonListForProjectAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private List<ProjectPersonLinkDetail> projectPersonLinkDetailList;
	
	private ProjectDetail projectDetail = null;
	

	public List<ProjectPersonLinkDetail> getProjectPersonLinkDetailList() {
		return projectPersonLinkDetailList;
	}

	public void setProjectPersonLinkDetailList(
			List<ProjectPersonLinkDetail> projectPersonLinkDetailList) {
		this.projectPersonLinkDetailList = projectPersonLinkDetailList;
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
		
		ProjectPersonListForProjectDAO projectPersonListForProjectDAO = new ProjectPersonListForProjectDAO();
		List<ProjectPersonLinkDetail> projectPersonLinkDetailList = projectPersonListForProjectDAO.projectPersonList(projectDetail);
		
		setProjectPersonLinkDetailList(projectPersonLinkDetailList);
		
		
		if (projectPersonLinkDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		
		return pageForwardStr;
	}

}
