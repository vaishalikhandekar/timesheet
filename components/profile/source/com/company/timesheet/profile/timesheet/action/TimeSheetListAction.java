/**
 * 
 */
package com.company.timesheet.profile.timesheet.action;

import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.timesheet.dao.TimeSheetListDAO;
import com.company.timesheet.profile.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetListAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<TimeSheetDetail> timeSheetDetailList;

	

	public List<TimeSheetDetail> getTimeSheetDetailList() {
		return timeSheetDetailList;
	}



	public void setTimeSheetDetailList(List<TimeSheetDetail> timeSheetDetailList) {
		this.timeSheetDetailList = timeSheetDetailList;
	}



	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";
		
		TimeSheetListDAO timeSheetListDAO = new TimeSheetListDAO();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetListDAO.listTimeSheet();
		
		setTimeSheetDetailList(timeSheetDetailList);

		if (timeSheetDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
