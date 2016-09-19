/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.profile.person.dao.PersonReadDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.dao.TimeSheetsForPersonDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetsForPersonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<TimeSheetDetail> timeSheetDetailList;

	private PersonDetail personDetail;

	public List<TimeSheetDetail> getTimeSheetDetailList() {
		return timeSheetDetailList;
	}

	public void setTimeSheetDetailList(List<TimeSheetDetail> timeSheetDetailList) {
		this.timeSheetDetailList = timeSheetDetailList;
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

		TimeSheetsForPersonDAO timeSheetsForPersonDAO = new TimeSheetsForPersonDAO();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetsForPersonDAO.listTimeSheet(personDetail);

		setTimeSheetDetailList(timeSheetDetailList);
		
		PersonReadDAO readPersonDAO = new PersonReadDAO();
        readPersonDAO.readperson(personDetail);
        
        setPersonDetail(personDetail);
        
		if (timeSheetDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
