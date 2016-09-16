/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.DeleteTimeSheetFromProjectDAO;
import com.company.timesheet.timesheet.dao.DeleteTimeSheetFromPersonDAO;
import com.company.timesheet.timesheet.dao.TimeSheetsForPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class DeleteTimeSheetFromProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private TimeSheetDetail timeSheetDetail = null;

	private ProjectDetail projectDetail = null;

    public TimeSheetDetail getTimeSheetDetail() {
    
        return timeSheetDetail;
    }

    
    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
    
        this.timeSheetDetail = timeSheetDetail;
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

		DeleteTimeSheetFromProjectDAO deleteTimeSheetFromProjectDAO = new DeleteTimeSheetFromProjectDAO();
		String returnMassegeStr = deleteTimeSheetFromProjectDAO.deleteTimeSheet(projectDetail);
		
		setProjectDetail(projectDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
