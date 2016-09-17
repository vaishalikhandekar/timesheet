/**
 * 
 */
package com.company.timesheet.timesheet.action;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.dao.TimeSheetCreateDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetCreateDetails;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Rahul
 */
public class TimeSheetCreateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private TimeSheetCreateDetails timeSheetCreateDetails = null;

	private TimeSheetDetail timeSheetDetail = null;

	private PersonDetail personDetail;

	public TimeSheetDetail getTimeSheetDetail() {
		return timeSheetDetail;
	}

	public void setTimeSheetDetail(TimeSheetDetail timeSheetDetail) {
		this.timeSheetDetail = timeSheetDetail;
	}

	/**
	 * @return
	 */
	public PersonDetail getPersonDetail() {
		return personDetail;
	}

	public void setPersonDetail(PersonDetail personDetail) {
		this.personDetail = personDetail;
	}

	/**
	 * @return the timeSheetCreateDetails
	 */
	public TimeSheetCreateDetails getTimeSheetCreateDetails() {
		return timeSheetCreateDetails;
	}

	/**
	 * @param timeSheetCreateDetails
	 *            the timeSheetCreateDetails to set
	 */
	public void setTimeSheetCreateDetails(
			TimeSheetCreateDetails timeSheetCreateDetails) {
		this.timeSheetCreateDetails = timeSheetCreateDetails;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		TimeSheetCreateDAO timeSheetCreateDAO  = new TimeSheetCreateDAO();
		TimeSheetDetail timeSheetDetail = timeSheetCreateDAO
				.createTimeSheet(timeSheetCreateDetails);

		//getPersonDetail().setPersonID(timeSheetCreateDetails.getPersonID());
		setTimeSheetCreateDetails(timeSheetCreateDetails);
		//setPersonDetail(personDetail);

		if (timeSheetCreateDetails != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
