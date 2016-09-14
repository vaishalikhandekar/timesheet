/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonLinkReadDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkReadAction extends ActionSupport {
		
	ProjectPersonLinkDetail projectPersonLinkDetail;
	
	PersonDetail personDetail;
	
	String act = "";
	
	public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
		return projectPersonLinkDetail;
	}

	public void setProjectPersonLinkDetail(
			ProjectPersonLinkDetail projectPersonLinkDetail) {
		this.projectPersonLinkDetail = projectPersonLinkDetail;
	}

    public PersonDetail getPersonDetail() {
    
        return personDetail;
    }

    
    public void setPersonDetail(PersonDetail personDetail) {
    
        this.personDetail = personDetail;
    }

    public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@Override
	public String execute() throws Exception {
		
				String pageForwardStr = "";
				
		ProjectPersonLinkReadDAO readProjectPersonLinkDAO = new ProjectPersonLinkReadDAO();
		ProjectPersonLinkDetail projectPersonLinkDetail = readProjectPersonLinkDAO.readProjectEmployeeLink(personDetail);
		
		setProjectPersonLinkDetail(projectPersonLinkDetail);
		
		if (act != null && act.equals("update")
				&& projectPersonLinkDetail != null) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (projectPersonLinkDetail != null) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
