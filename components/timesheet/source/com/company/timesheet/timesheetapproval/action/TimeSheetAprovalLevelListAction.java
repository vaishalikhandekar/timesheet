/**
 * 
 */
package com.company.timesheet.timesheetapproval.action;

import java.util.List;

import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.company.timesheet.timesheetapproval.dao.TimeSheetAprovalLevelListDAO;
import com.company.timesheet.timesheetapproval.pojo.TimeSheetAprovalLevelDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessKey;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetAprovalLevelListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = null;

	private ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail = null;
	
	private ProjectPersonLinkDetail projectPersonLinkDetail = null;
	
	private ProjectTimeSheetProcessKey projectTimeSheetProcessKey = null;
	
    public List<TimeSheetAprovalLevelDetail> getTimeSheetAprovalLevelDetailList() {
    
        return timeSheetAprovalLevelDetailList;
    }

    
    public void setTimeSheetAprovalLevelDetailList(List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList) {
    
        this.timeSheetAprovalLevelDetailList = timeSheetAprovalLevelDetailList;
    }

    public ProjectTimeSheetProcessDetail getProjectTimeSheetProcessDetail() {
    
        return projectTimeSheetProcessDetail;
    }
    
    public void setProjectTimeSheetProcessDetail(ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail) {
    
        this.projectTimeSheetProcessDetail = projectTimeSheetProcessDetail;
    }


    
    public ProjectPersonLinkDetail getProjectPersonLinkDetail() {
    
        return projectPersonLinkDetail;
    }


    
    public void setProjectPersonLinkDetail(ProjectPersonLinkDetail projectPersonLinkDetail) {
    
        this.projectPersonLinkDetail = projectPersonLinkDetail;
    }

    /**
     * @return the projectTimeSheetProcessKey
     */
    public ProjectTimeSheetProcessKey getProjectTimeSheetProcessKey() {
        
        return projectTimeSheetProcessKey;
    }
    
    
    /**
     * @param projectTimeSheetProcessKey the projectTimeSheetProcessKey to set
     */
    public void setProjectTimeSheetProcessKey(ProjectTimeSheetProcessKey projectTimeSheetProcessKey) {
        
        this.projectTimeSheetProcessKey = projectTimeSheetProcessKey;
    }

    @Override
	public String execute() throws Exception {

		String pageForwardStr = "";
		
		TimeSheetAprovalLevelListDAO timeSheetAprovalLevelListDAO = new TimeSheetAprovalLevelListDAO();
		
		List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = timeSheetAprovalLevelListDAO.getTimeSheetAprovalLevelDetailList(projectTimeSheetProcessKey);

		
		/*projectPersonLinkDetail = timeSheetAprovalLevelDetail.getProjectPersonLinkDetail();
		setProjectPersonLinkDetail(projectPersonLinkDetail);*/
		
		setTimeSheetAprovalLevelDetailList(timeSheetAprovalLevelDetailList);
		
		if ( timeSheetAprovalLevelDetailList!= null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}


    

}
