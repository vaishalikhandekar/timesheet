/**
 * 
 */
package com.company.timesheet.timesheetlineitem.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.timesheetlineitem.dao.TimeSheetLineItemReadDAO;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemReadAction extends ActionSupport {
		
	TimeSheetLineItemDetail timeSheetLineItemDetail;
	String act = "";
	
	public TimeSheetLineItemDetail getTimeSheetLineItemDetail() {
		return timeSheetLineItemDetail;
	}

	public void setTimeSheetLineItemDetail(
			TimeSheetLineItemDetail timeSheetLineItemDetail) {
		this.timeSheetLineItemDetail = timeSheetLineItemDetail;
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
			
		TimeSheetLineItemReadDAO readTimeSheetLineItemDAO = new TimeSheetLineItemReadDAO();
		String returnMassegeStr = readTimeSheetLineItemDAO.ReadTimeSheetLineItem(timeSheetLineItemDetail);
		
		if (act != null && act.equals("update")
				&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
		
	}
		
	
}
