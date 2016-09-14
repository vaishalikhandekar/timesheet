/**
 * 
 */
package com.company.timesheet.timesheet.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.dao.ProjectReadDAO;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.TimeSheetReadFromPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetReadFromPersonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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

		TimeSheetReadFromPersonDAO timeSheetReadFromPersonDAO = new TimeSheetReadFromPersonDAO();
		String returnMassegeStr = timeSheetReadFromPersonDAO.readTimeSheet(personDetail);
		setTimeSheetDetail(timeSheetDetail);
		
		if (act != null && act.equals("update")
				&& returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

			pageForwardStr = "SENTTOUPDATE";

		} else if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {
			pageForwardStr = SUCCESS;

		}

		return pageForwardStr;
	}

}
