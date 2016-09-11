/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.dao.TimeSheetListDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetListAction extends ActionSupport {

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

		TimeSheetListDAO timeSheetListDAO = new TimeSheetListDAO();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetListDAO.listTimeSheet(personDetail);

		setTimeSheetDetailList(timeSheetDetailList);

		if (timeSheetDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
