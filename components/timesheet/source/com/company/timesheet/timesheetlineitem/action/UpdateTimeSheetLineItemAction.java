/**
 * 
 */
package com.company.timesheet.timesheetlineitem.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.timesheetlineitem.dao.UpdateTimeSheetLineItemDAO;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class UpdateTimeSheetLineItemAction extends ActionSupport {
			
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TimeSheetLineItemDetail timeSheetLineItemDetail;
	
	public TimeSheetLineItemDetail getTimeSheetLineItemDetail() {
		return timeSheetLineItemDetail;
	}

	public void setTimeSheetLineItemDetail(
			TimeSheetLineItemDetail timeSheetLineItemDetail) {
		this.timeSheetLineItemDetail = timeSheetLineItemDetail;
	}

	@Override
	public String execute() throws Exception {
		
		String pageForwardStr = "";
	
		UpdateTimeSheetLineItemDAO updateTimeSheetLineItemDAO = new UpdateTimeSheetLineItemDAO();
		String returnMassegeStr = updateTimeSheetLineItemDAO.updateTimeSheetLineItem(timeSheetLineItemDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {
			pageForwardStr = ERROR;
		}
		return pageForwardStr;
	
		
	}

}
