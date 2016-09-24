/**
 * 
 */
package com.company.timesheet.timesheetlineitem.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheetlineitem.dao.TimeSheetLineItemUpdateDAO;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemUpdateAction extends ActionSupport {
			
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TimeSheetLineItemDetail timeSheetLineItemDetail = null;
	private TimeSheetDetail timeSheetDetail = null;
	
	public TimeSheetLineItemDetail getTimeSheetLineItemDetail() {
		return timeSheetLineItemDetail;
	}

	public void setTimeSheetLineItemDetail(
			TimeSheetLineItemDetail timeSheetLineItemDetail) {
		this.timeSheetLineItemDetail = timeSheetLineItemDetail;
	}

	
    public TimeSheetDetail getTimeSheetDetail() {
    
        return timeSheetDetail;
    }

    
    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
    
        this.timeSheetDetail = timeSheetDetail;
    }

    @Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
	
		TimeSheetLineItemUpdateDAO updateTimeSheetLineItemDAO = new TimeSheetLineItemUpdateDAO();
		String returnMassegeStr = updateTimeSheetLineItemDAO.updateTimeSheetLineItem(timeSheetDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	
		
	}

}
