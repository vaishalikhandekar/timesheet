/**
 * 
 */
package com.company.timesheet.profile.projectpersonlink.action;

import java.util.List;

import com.company.timesheet.profile.projectpersonlink.dao.ListOfPersonInTheProjectDAO;
import com.company.timesheet.profile.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ListOfPersonInTheProjectAction extends ActionSupport {
			
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
				
				ListOfPersonInTheProjectDAO listOfPersonInTheProjectDAO = new ListOfPersonInTheProjectDAO();
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
