/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonLinkDeleteDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkDeleteAction extends ActionSupport {
		
	ProjectPersonLinkDetail projectPersonLinkDetail = null;
	PersonDetail personDetail = null;
	
    public PersonDetail getPersonDetail() {
    
        return personDetail;
    }

    
    public void setPersonDetail(PersonDetail personDetail) {
    
        this.personDetail = personDetail;
    }

    public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}

	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
		
		ProjectPersonLinkDeleteDAO deleteProjectEmployeeLinkDAO = new ProjectPersonLinkDeleteDAO();
		String returnMassegeStr = deleteProjectEmployeeLinkDAO.DeleteProjectEmployeeLink(personDetail);
		
		setPersonDetail(personDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
		
	}

}
