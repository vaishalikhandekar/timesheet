/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.dao.TimeSheetDeleteFromPersonDAO;
import com.company.timesheet.timesheet.dao.TimeSheetsForPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetDeleteFromPersonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private TimeSheetDetail timeSheetDetail;

	private PersonDetail personDetail;

    public TimeSheetDetail getTimeSheetDetail() {
    
        return timeSheetDetail;
    }

    
    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
    
        this.timeSheetDetail = timeSheetDetail;
    }

    public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		TimeSheetDeleteFromPersonDAO timeSheetDeleteFromPersonDAO = new TimeSheetDeleteFromPersonDAO();
		String returnMassegeStr = timeSheetDeleteFromPersonDAO.deleteTimeSheet(personDetail);

		if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
