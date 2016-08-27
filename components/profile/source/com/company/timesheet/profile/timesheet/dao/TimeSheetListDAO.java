/**
 * 
 */
package com.company.timesheet.profile.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.timesheet.pojo.TimeSheetDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class TimeSheetListDAO  {
	
	public List<TimeSheetDetail> listTimeSheet(){
		
		List<TimeSheetDetail> timeSheetDetailList = new ArrayList<TimeSheetDetail>();
		
		Connection connection = null;
		ResultSet resultSet;
		try {
			connection = DBConnection.getDBConnection();

			String timeSheetSQLStr = "SELECT * FROM TIMESHEET WHERE	RECORDSTATUS='Active'";

			// statement = connection.createStatement();

			PreparedStatement preparedStatement = connection.prepareStatement(timeSheetSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				TimeSheetDetail timeSheetDetail = new TimeSheetDetail();
				
				timeSheetDetail.setMonth(resultSet.getString("month"));
				timeSheetDetail.setMaximumTotalHours(resultSet.getInt("maximumTotalHours"));
				timeSheetDetail.setActualTotalHours(resultSet.getInt("actualTotalHours"));
				timeSheetDetail.setSubmittedDate(resultSet.getDate("submittedDate"));
				timeSheetDetail.setStartDate(resultSet.getDate("startDate"));
				timeSheetDetail.setEndDate(resultSet.getDate("endDate"));
				timeSheetDetail.setTimeSheetStatus(resultSet.getString("timeSheetStatus"));
				
				timeSheetDetailList.add(timeSheetDetail);
			}
		
		}catch (SQLException e) {

			e.printStackTrace();
		}
	
		return timeSheetDetailList;
	

}
}
