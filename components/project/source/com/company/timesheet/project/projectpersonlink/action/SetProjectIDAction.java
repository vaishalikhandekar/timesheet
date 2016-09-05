/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class SetProjectIDAction extends ActionSupport {
		
	private static final long serialVersionUID = 1L;
	
	ProjectPersonLinkDetail projectPersonLinkDetail;
	
	public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}

	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}
	
	@Override
	public String execute() throws Exception {
		
		setProjectPersonLinkDetail(projectPersonLinkDetail);
		
		return SUCCESS;
	}

}
