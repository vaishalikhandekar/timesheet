/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import java.util.List;

import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonLinkListPersonInTheProjectDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkListPersonInTheProjectAction extends ActionSupport {
			
			private static final long serialVersionUID = 1L;
			
			List<ProjectPersonLinkDetail> ProjectPersonLinkDetailList;

			public List<ProjectPersonLinkDetail> getProjectPersonLinkDetailList() {
				return ProjectPersonLinkDetailList;
			}

			public void setProjectPersonLinkDetailList(
					List<ProjectPersonLinkDetail> projectPersonLinkDetailList) {
				ProjectPersonLinkDetailList = projectPersonLinkDetailList;
			}

			@Override
			public String execute() throws Exception {
					
					String pageForwardStr = "";
				
				ProjectPersonLinkListPersonInTheProjectDAO listOfPersonInTheProjectDAO = new ProjectPersonLinkListPersonInTheProjectDAO();
				List<ProjectPersonLinkDetail> projectPersonLinkDetailList = listOfPersonInTheProjectDAO.listOfPersonInTheProject();
				
				setProjectPersonLinkDetailList(projectPersonLinkDetailList);
				
				if (projectPersonLinkDetailList != null) {

					pageForwardStr = SUCCESS;

				} else {

					pageForwardStr = ERROR;

				}
				
				return pageForwardStr;
				
			}
			
			
}
