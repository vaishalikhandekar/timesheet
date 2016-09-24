/**
 * 
 */
package com.company.timesheet.timesheetapproval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.company.timesheet.timesheetapproval.pojo.TimeSheetAprovalLevelDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetAprovalLevelListDAO  {
	
	public List<TimeSheetAprovalLevelDetail> TimeSheetAprovalLevelDetailList(ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail){
		
		List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = new ArrayList<TimeSheetAprovalLevelDetail>();
		
		Connection connection = null;
		TimeSheetAprovalLevelDetail timeSheetAprovalLevelDetail = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet;
		ResultSet resultSet1;
		try {
			connection = DBConnection.getDBConnection();

			String timeSheetAprovalLevelDetailSQLStr = "SELECT * FROM TimeSheetApprovalLevel WHERE projectTimeSheetProcessID = '"+projectTimeSheetProcessDetail.getProjectTimeSheetProcessID()+"' and	RECORDSTATUS='Active'";

			 preparedStatement = connection.prepareStatement(timeSheetAprovalLevelDetailSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
			    timeSheetAprovalLevelDetail = new TimeSheetAprovalLevelDetail();
				
				timeSheetAprovalLevelDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
				timeSheetAprovalLevelDetail.setTimeSheetApprovalLevelID(resultSet.getLong("timeSheetApprovalLevelID"));
				timeSheetAprovalLevelDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
				timeSheetAprovalLevelDetail.setApprovalLevelType(resultSet.getString("approvalLevelType"));
				timeSheetAprovalLevelDetail.setApprovalCriteria(resultSet.getString("approvalCriteria"));
				timeSheetAprovalLevelDetail.setStartDate(resultSet.getDate("startDate"));
				timeSheetAprovalLevelDetail.setEndDate(resultSet.getDate("endDate"));
				timeSheetAprovalLevelDetail.setComments(resultSet.getString("comments"));
				timeSheetAprovalLevelDetail.setRecordStatus(resultSet.getString("recordStatus"));
				timeSheetAprovalLevelDetail.setVersionNo(resultSet.getInt("versionNo"));
				
				String projectPersonLinkDetailSQLStr = "SELECT projectID FROM ProjectPersonLink WHERE projectPersonLinkID = '"+timeSheetAprovalLevelDetail.getProjectPersonLinkID()+"' and   RECORDSTATUS='Active'";

	             preparedStatement1 = connection.prepareStatement(projectPersonLinkDetailSQLStr);

	            resultSet1 = preparedStatement1.executeQuery();
	            while(resultSet1.next()){
	                ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
	                projectPersonLinkDetail.setProjectID(resultSet1.getLong("projectID"));
	                
	                timeSheetAprovalLevelDetail.setProjectPersonLinkDetail(projectPersonLinkDetail);
	            }
				
				timeSheetAprovalLevelDetailList.add(timeSheetAprovalLevelDetail);
			}
		
		}catch (SQLException e) {

			e.printStackTrace();
		}
	
		return timeSheetAprovalLevelDetailList;
	

}
}
