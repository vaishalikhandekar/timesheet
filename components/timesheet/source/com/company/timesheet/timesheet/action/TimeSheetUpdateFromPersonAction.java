/**
 * 
 */
package com.company.timesheet.timesheet.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.project.dao.ProjectUpdateDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.TimeSheetUpdateFromPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetUpdateFromPersonAction extends ActionSupport {
		
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    TimeSheetDetail timeSheetDetail = null;
	
    public TimeSheetDetail getTimeSheetDetail() {
    
        return timeSheetDetail;
    }
    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
    
        this.timeSheetDetail = timeSheetDetail;
    }



    @Override
	public String execute() throws Exception {
	
		String pageForwardStr = "";
		
		TimeSheetUpdateFromPersonDAO timeSheetUpdateFromPersonDAO = new TimeSheetUpdateFromPersonDAO();
		String returnMassegeStr = timeSheetUpdateFromPersonDAO.updateTimeSheet(timeSheetDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	
		
	}

}
