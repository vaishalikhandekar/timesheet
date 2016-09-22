/**
 * 
 */
package com.company.timesheet.timesheet.action;

import java.util.List;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.dao.TimeSheetsForProjectDAO;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetsForProjectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<TimeSheetDetail> timeSheetDetailList;

	private ProjectDetail projectDetail = null;

	public List<TimeSheetDetail> getTimeSheetDetailList() {
		return timeSheetDetailList;
	}

	public void setTimeSheetDetailList(List<TimeSheetDetail> timeSheetDetailList) {
		this.timeSheetDetailList = timeSheetDetailList;
	}
	

	public ProjectDetail getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(ProjectDetail projectDetail) {
		this.projectDetail = projectDetail;
	}

	@Override
	public String execute() throws Exception {

		String pageForwardStr = "";

		TimeSheetsForProjectDAO timeSheetsForProjectDAO = new TimeSheetsForProjectDAO();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetsForProjectDAO.listTimeSheetForProject(projectDetail);

		setTimeSheetDetailList(timeSheetDetailList);

		if (timeSheetDetailList != null) {

			pageForwardStr = SUCCESS;

		} else {

			pageForwardStr = ERROR;

		}

		return pageForwardStr;
	}

}
