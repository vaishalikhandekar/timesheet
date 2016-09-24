/**
 * 
 */
package com.company.timesheet.timesheetprocess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheetapproval.dao.TimeSheetAprovalLevelListDAO;
import com.company.timesheet.timesheetapproval.pojo.TimeSheetAprovalLevelDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessKey;

/**
 * 
 * @author vaish
 */
public class ProjectTimeSheetProcessReadDAO {

    /**
     * 
     * @param ProjectTimeSheetProcessKey projectTimeSheetProcessKey
     * @return
     */
    public ProjectTimeSheetProcessDetail readProjectTimeSheetProcessDetails(ProjectTimeSheetProcessKey projectTimeSheetProcessKey) {

        ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            connection = DBConnection.getDBConnection();

            StringBuffer projectTimeSheetProcessDetailSQLStrBuf = new StringBuffer();
            
            projectTimeSheetProcessDetailSQLStrBuf.append(" SELECT * FROM ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" ProjectTimeSheetProcess ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" WHERE ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" projectTimeSheetProcessID = ? ");
            //projectTimeSheetProcessDetailSQLStrBuf.append(" AND recordStatus = ? ");

            preparedStatement = connection.prepareStatement(projectTimeSheetProcessDetailSQLStrBuf.toString());

            preparedStatement.setLong(1, projectTimeSheetProcessKey.getProjectTimeSheetProcessID());
            //preparedStatement.setString(2, "Active");
            
            resultSet = preparedStatement.executeQuery();

            projectTimeSheetProcessDetail = new ProjectTimeSheetProcessDetail();
            
            while (resultSet.next()) {

                projectTimeSheetProcessDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
                projectTimeSheetProcessDetail.setFrequency(resultSet.getString("frequency"));
                projectTimeSheetProcessDetail.setStartDay(resultSet.getString("startDay"));
                projectTimeSheetProcessDetail.setMinimumApprovalLevelType(resultSet.getString("minimumApprovalLevelType"));
                projectTimeSheetProcessDetail.setRegularDailyHours(resultSet.getInt("regularDailyHours"));
                projectTimeSheetProcessDetail.setStartDate(resultSet.getDate("startDate"));
                projectTimeSheetProcessDetail.setEndDate(resultSet.getDate("endDate"));
                projectTimeSheetProcessDetail.setComments(resultSet.getString("comments"));
                projectTimeSheetProcessDetail.setRecordStatus(resultSet.getString("recordStatus"));

            }
            
            // Call ApprovalLevel List
            TimeSheetAprovalLevelListDAO timeSheetAprovalLevelListDAO = new TimeSheetAprovalLevelListDAO();
            List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = timeSheetAprovalLevelListDAO.getTimeSheetAprovalLevelDetailList(projectTimeSheetProcessKey);
            
            projectTimeSheetProcessDetail.setTimeSheetAprovalLevelDetailList(timeSheetAprovalLevelDetailList);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return projectTimeSheetProcessDetail;

    }
    
    /**
     * 
     * @param ProjectTimeSheetProcessKey projectTimeSheetProcessKey
     * @return
     */
    public ProjectTimeSheetProcessDetail readActiveProjectTimeSheetProcessDetails(ProjectTimeSheetProcessKey projectTimeSheetProcessKey) {

        ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            
            connection = DBConnection.getDBConnection();

            StringBuffer projectTimeSheetProcessDetailSQLStrBuf = new StringBuffer();
            
            projectTimeSheetProcessDetailSQLStrBuf.append(" SELECT * FROM ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" ProjectTimeSheetProcess ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" WHERE ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" projectID = ? ");
            projectTimeSheetProcessDetailSQLStrBuf.append(" AND recordStatus = ? ");

            preparedStatement = connection.prepareStatement(projectTimeSheetProcessDetailSQLStrBuf.toString());

            preparedStatement.setLong(1, projectTimeSheetProcessKey.getProjectID());
            preparedStatement.setString(2, "Active");
            
            resultSet = preparedStatement.executeQuery();

            projectTimeSheetProcessDetail = new ProjectTimeSheetProcessDetail();
            
            while (resultSet.next()) {

                projectTimeSheetProcessDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
                projectTimeSheetProcessDetail.setFrequency(resultSet.getString("frequency"));
                projectTimeSheetProcessDetail.setStartDay(resultSet.getString("startDay"));
                projectTimeSheetProcessDetail.setMinimumApprovalLevelType(resultSet.getString("minimumApprovalLevelType"));
                projectTimeSheetProcessDetail.setRegularDailyHours(resultSet.getInt("regularDailyHours"));
                projectTimeSheetProcessDetail.setStartDate(resultSet.getDate("startDate"));
                projectTimeSheetProcessDetail.setEndDate(resultSet.getDate("endDate"));
                projectTimeSheetProcessDetail.setComments(resultSet.getString("comments"));
                projectTimeSheetProcessDetail.setRecordStatus(resultSet.getString("recordStatus"));

            }
            
            projectTimeSheetProcessKey.setProjectTimeSheetProcessID(projectTimeSheetProcessDetail.getProjectTimeSheetProcessID());
            
            // Call ApprovalLevel List
            TimeSheetAprovalLevelListDAO timeSheetAprovalLevelListDAO = new TimeSheetAprovalLevelListDAO();
            List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = timeSheetAprovalLevelListDAO.getTimeSheetAprovalLevelDetailList(projectTimeSheetProcessKey);
            
            projectTimeSheetProcessDetail.setTimeSheetAprovalLevelDetailList(timeSheetAprovalLevelDetailList);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return projectTimeSheetProcessDetail;

    }
    
}
