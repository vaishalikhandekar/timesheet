/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.dao.PersonUpdateDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.UpdatePersonFromProjectDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class UpdatePersonFromProjectAction extends ActionSupport {
	
private static final long serialVersionUID = 1L;
	
	private ProjectPersonLinkDetail projectPersonLinkDetail = null;
	private ProjectDetail projectDetail = null;

    public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
    
        return projectPersonLinkDetail;
    }
    public void setProjectPersonLinkDetail(ProjectPersonLinkDetail projectPersonLinkDetail) {
    
        this.projectPersonLinkDetail = projectPersonLinkDetail;
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

		UpdatePersonFromProjectDAO updatePersonFromProjectDAO = new UpdatePersonFromProjectDAO();
		String returnMassegeStr = updatePersonFromProjectDAO.updatePersonFromProject(projectPersonLinkDetail);

		setProjectDetail(projectDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
		
	}

}
