/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.DeletePersonFromProjectDAO;
import com.company.timesheet.project.projectpersonlink.dao.ProjectPersonLinkDeleteDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class DeletePersonFromProjectAction extends ActionSupport {
		
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    ProjectPersonLinkDetail projectPersonLinkDetail = null;
	ProjectDetail projectDetail = null;
	
    public ProjectDetail getProjectDetail() {
    
        return projectDetail;
    }

    
    public void setProjectDetail(ProjectDetail projectDetail) {
    
        this.projectDetail = projectDetail;
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
		
		DeletePersonFromProjectDAO deletePersonFromProjectDAO = new DeletePersonFromProjectDAO();
		String returnMassegeStr = deletePersonFromProjectDAO.DeletePersonFromProjectLink(projectDetail);
		
       setProjectDetail(projectDetail);
       
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
		
	}

}
