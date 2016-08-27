/**
 * 
 */
package com.company.timesheet.profile.timesheetlineitem.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.timesheetlineitem.dao.CreateTimeSheetLineItemDAO;
import com.company.timesheet.profile.timesheetlineitem.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class CreateTimeSheetLineItemAction extends ActionSupport {
	
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
		
		CreateTimeSheetLineItemDAO timeSheetLineItemDAO = new CreateTimeSheetLineItemDAO();
		String returnMassegeStr = timeSheetLineItemDAO.createTimeSheetLineItem(timeSheetLineItemDetail);
		
		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}
		return pageForwardStr;
	}

}
