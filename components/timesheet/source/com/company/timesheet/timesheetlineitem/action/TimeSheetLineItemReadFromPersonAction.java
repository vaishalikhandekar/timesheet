/**
 * 
 */
package com.company.timesheet.timesheetlineitem.action;

import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetKey;
import com.company.timesheet.timesheetlineitem.dao.TimeSheetLineItemReadFromPersonDAO;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemReadFromPersonAction extends ActionSupport {
		
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    PersonDetail personDetail = null;
    
    List<TimeSheetLineItemDetail> timeSheetLineItemDetailList = null;
	
    TimeSheetDetail timeSheetDetail = null;
    
    TimeSheetKey timeSheetKey = null;
	
    String act = "";
	
    
    public PersonDetail getPersonDetail() {
    
        return personDetail;
    }



    
    public void setPersonDetail(PersonDetail personDetail) {
    
        this.personDetail = personDetail;
    }



    public List<TimeSheetLineItemDetail> getTimeSheetLineItemDetailList() {
    
        return timeSheetLineItemDetailList;
    }


    
    public void setTimeSheetLineItemDetailList(List<TimeSheetLineItemDetail> timeSheetLineItemDetailList) {
    
        this.timeSheetLineItemDetailList = timeSheetLineItemDetailList;
    }


    public TimeSheetDetail getTimeSheetDetail() {
    
        return timeSheetDetail;
    }

    
    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
    
        this.timeSheetDetail = timeSheetDetail;
    }

    
    public TimeSheetKey getTimeSheetKey() {
    
        return timeSheetKey;
    }

    
    public void setTimeSheetKey(TimeSheetKey timeSheetKey) {
    
        this.timeSheetKey = timeSheetKey;
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
			
		TimeSheetLineItemReadFromPersonDAO readTimeSheetLineItemFromPersonDAO = new TimeSheetLineItemReadFromPersonDAO();
		timeSheetLineItemDetailList = readTimeSheetLineItemFromPersonDAO.readTimeSheetLineItem(timeSheetKey);
		
		 setTimeSheetLineItemDetailList(timeSheetLineItemDetailList);
		
		if (act != null && act.equals("update")) {

			pageForwardStr = "SENTTOUPDATE";

		} else {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
		
	}
		
	
}
