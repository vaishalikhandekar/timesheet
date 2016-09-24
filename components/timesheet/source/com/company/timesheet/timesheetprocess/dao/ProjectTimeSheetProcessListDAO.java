/**
 * 
 */
package com.company.timesheet.timesheetprocess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessDetail;

/**
 * @author vaish
 *
 */
public class ProjectTimeSheetProcessListDAO  {
	
	public List<ProjectTimeSheetProcessDetail> projectTimeSheetProcessList(ProjectDetail projectDetail){
		
		List<ProjectTimeSheetProcessDetail> projectTimeSheetProcessDetailList = new ArrayList<ProjectTimeSheetProcessDetail>();
		
		Connection connection = null;
		ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail = null;
		ResultSet resultSet;
		try {
			connection = DBConnection.getDBConnection();

			String projectTimeSheetProcessDetailSQLStr = "SELECT * FROM ProjectTimeSheetProcess WHERE projectID = '"+projectDetail.getProjectID()+"' and	RECORDSTATUS='Active'";

			PreparedStatement preparedStatement = connection.prepareStatement(projectTimeSheetProcessDetailSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				projectTimeSheetProcessDetail = new ProjectTimeSheetProcessDetail();
				
				projectTimeSheetProcessDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
				projectTimeSheetProcessDetail.setFrequency(resultSet.getString("frequency"));
				projectTimeSheetProcessDetail.setStartDay(resultSet.getString("startDay"));
				projectTimeSheetProcessDetail.setMinimumApprovalLevelType(resultSet.getString("minimumApprovalLevelType"));
				projectTimeSheetProcessDetail.setRegularDailyHours(resultSet.getInt("regularDailyHours"));
				projectTimeSheetProcessDetail.setStartDate(resultSet.getDate("startDate"));
				projectTimeSheetProcessDetail.setEndDate(resultSet.getDate("endDate"));
				projectTimeSheetProcessDetail.setRecordStatus(resultSet.getString("recordStatus"));
				
				projectTimeSheetProcessDetailList.add(projectTimeSheetProcessDetail);
			}
		
		}catch (SQLException e) {

			e.printStackTrace();
		}
	
		return projectTimeSheetProcessDetailList;
	

}
}
