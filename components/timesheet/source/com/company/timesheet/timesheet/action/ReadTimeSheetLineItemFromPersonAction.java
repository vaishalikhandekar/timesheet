/**
 * 
 */
package com.company.timesheet.timesheet.action;

import com.company.timesheet.timesheet.dao.ReadTimeSheetLineItemFromPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ReadTimeSheetLineItemFromPersonAction extends ActionSupport {
		
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    TimeSheetLineItemDetail timeSheetLineItemDetail = null;
	
    TimeSheetDetail timeSheetDetail = null;
	
    String act = "";
	
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

    public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	@Override
	public String execute() throws Exception {
		
				String pageForwardStr = "";
			
		ReadTimeSheetLineItemFromPersonDAO readTimeSheetLineItemFromPersonDAO = new ReadTimeSheetLineItemFromPersonDAO();
		 timeSheetLineItemDetail = readTimeSheetLineItemFromPersonDAO.ReadTimeSheetLineItem(timeSheetLineItemDetail);
		 
		 setTimeSheetLineItemDetail(timeSheetLineItemDetail);
		
		if (act != null && act.equals("update")
				&& timeSheetLineItemDetail !=null) {

			pageForwardStr = "SENTTOUPDATE";

		} else if(timeSheetLineItemDetail !=null) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
		
	}
		
	
}
