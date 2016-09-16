/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.action;

import java.util.List;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.dao.PersonListForProjectDAO;
import com.company.timesheet.project.projectpersonlink.dao.ReadPersonFromProjectDAO;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadPersonFromProjectAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	ProjectPersonLinkDetail projectPersonLinkDetail = null;
	String act = "";
	
    public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
    
        return projectPersonLinkDetail;
    }

    public void setProjectPersonLinkDetail(ProjectPersonLinkDetail projectPersonLinkDetail) {
    
        this.projectPersonLinkDetail = projectPersonLinkDetail;
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
		
		ReadPersonFromProjectDAO readPersonFromProjectDAO = new ReadPersonFromProjectDAO();
		 projectPersonLinkDetail =  readPersonFromProjectDAO.readPersonFromProject(projectPersonLinkDetail);
		
		    setProjectPersonLinkDetail(projectPersonLinkDetail);
		
		if (act != null && act.equals("update") && projectPersonLinkDetail != null) {

			pageForwardStr = "SENTTOUPDATE";

		} else {

			pageForwardStr = ERROR;

		}
		
		return pageForwardStr;
	}

}
