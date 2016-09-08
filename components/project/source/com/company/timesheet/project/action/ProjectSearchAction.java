/**
 * 
 */
package com.company.timesheet.project.action;

import java.util.List;

import com.company.timesheet.project.dao.ProjectSearchDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.pojo.ProjectSearchDetails;
import com.company.timesheet.project.pojo.ProjectSearchResult;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectSearchAction extends ActionSupport {
	
		private ProjectSearchDetails projectSearchDetails;
		private ProjectSearchResult projectSearchResult;
	
		public ProjectSearchDetails getProjectSearchDetails() {
			return projectSearchDetails;
		}

		public void setProjectSearchDetails(ProjectSearchDetails projectSearchDetails) {
			this.projectSearchDetails = projectSearchDetails;
		}

		public ProjectSearchResult getProjectSearchResult() {
			return projectSearchResult;
		}

		public void setProjectSearchResult(ProjectSearchResult projectSearchResult) {
			this.projectSearchResult = projectSearchResult;
		}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ProjectSearchDAO searchProjectDAO = new ProjectSearchDAO();
		List<ProjectDetail> projectDetailList = searchProjectDAO.searchProjectInfo(projectSearchDetails);
		
		long numberOfProject = projectDetailList.size();
		

		this.projectSearchResult = new ProjectSearchResult();

		projectSearchResult.setNumberOfProject(numberOfProject);
		projectSearchResult.setProjectDetailList(projectDetailList);

		//personSearchDetails.setPersonSearchResult(personSearchResult);

		if (projectDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	}

		
	}


