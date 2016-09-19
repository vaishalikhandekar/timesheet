/**
 * 
 */
package com.company.timesheet.timesheet.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.dao.TimeSheetReadDAO;
import com.company.timesheet.timesheet.dao.TimeSheetReadFromPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetKey;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetReadAction extends ActionSupport {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private TimeSheetKey timeSheetKey = null;

    private PersonDetail personDetail = null;

    private TimeSheetDetail timeSheetDetail = null;

    String act = "";

    public PersonDetail getPersonDetail() {

        return personDetail;
    }

    public void setPersonDetail(PersonDetail personDetail) {

        this.personDetail = personDetail;
    }

    public TimeSheetDetail getTimeSheetDetail() {

        return timeSheetDetail;
    }

    public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {

        this.timeSheetDetail = timeSheetDetail;
    }

    /**
     * @return the timeSheetKey
     */
    public TimeSheetKey getTimeSheetKey() {

        return timeSheetKey;
    }

    /**
     * @param timeSheetKey
     *            the timeSheetKey to set
     */
    public void setTimeSheetKey(TimeSheetKey timeSheetKey) {

        this.timeSheetKey = timeSheetKey;
    }

    public String getAct() {

        return act;
    }

    public void setAct(String act) {

        this.act = act;
    }

    /**
	 * 
	 */
    @Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		TimeSheetReadDAO timeSheetReadDAO = new TimeSheetReadDAO();
		
		timeSheetDetail = timeSheetReadDAO.readTimeSheet(timeSheetKey);
		setTimeSheetDetail(timeSheetDetail);
		
		if (act != null && act.equals("update")) {
				//&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) 
		       

			pageForwardStr = "SENTTOUPDATE";

		} else {//if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}
}
