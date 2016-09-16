/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.company.timesheet.timesheet.dao.ProjectTimeSheetProcessListDAO;
import com.company.timesheet.timesheet.dao.TimeSheetAprovalLevelListDAO;
import com.company.timesheet.timesheet.pojo.ProjectTimeSheetProcessDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetAprovalLevelDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetAprovalLevelListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList;

	private ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail;
	
	private ProjectPersonLinkDetail projectPersonLinkDetail ;
	
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


    @Override
	public String execute() throws Exception {

		String pageForwardStr = "";
		
		TimeSheetAprovalLevelListDAO timeSheetAprovalLevelListDAO = new TimeSheetAprovalLevelListDAO();
		List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = timeSheetAprovalLevelListDAO.TimeSheetAprovalLevelDetailList(projectTimeSheetProcessDetail);

		
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
