/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetKey;
import com.company.timesheet.timesheet.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetReadDAO {

   
    /**
     * 
     * @param timeSheetKey
     * @return
     */
    public TimeSheetDetail readTimeSheet(TimeSheetKey timeSheetKey) {
        
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        TimeSheetDetail timeSheetDetail = null;

        String returnMassegeStr = "";

        try {

            connection = DBConnection.getDBConnection();

            StringBuffer timeSheetSQLStrBuf = new StringBuffer();

            timeSheetSQLStrBuf.append("SELECT ");
            timeSheetSQLStrBuf.append("timeSheet.timeSheetID, ");
            timeSheetSQLStrBuf.append("timeSheet.projectTimeSheetProcessID, ");
            timeSheetSQLStrBuf.append("timeSheet.projectPersonLinkID, ");
            timeSheetSQLStrBuf.append("timeSheet.totalRegularHours, ");
            timeSheetSQLStrBuf.append("timeSheet.totalNoOfHoursWorked, ");
            timeSheetSQLStrBuf.append("timeSheet.createdDateTime, ");
            timeSheetSQLStrBuf.append("timeSheet.submittedDateTime, ");
            timeSheetSQLStrBuf.append("timeSheet.startDate, ");
            timeSheetSQLStrBuf.append("timeSheet.endDate, ");
            timeSheetSQLStrBuf.append("timeSheet.timeSheetStatus, ");
            timeSheetSQLStrBuf.append("timeSheet.approvalLevelType,  ");
            timeSheetSQLStrBuf.append("timeSheet.versionNo,  ");
            timeSheetSQLStrBuf.append("timeSheet.recordStatus, ");
            timeSheetSQLStrBuf.append("project.projectName ");
            timeSheetSQLStrBuf.append("FROM ");
            timeSheetSQLStrBuf.append("TimeSheet timeSheet ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN ProjectPersonLink projectPersonLink ");
            timeSheetSQLStrBuf.append("ON timeSheet.projectPersonLinkID = projectPersonLink.projectPersonLinkID ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN Project project ");
            timeSheetSQLStrBuf.append("ON project.projectID = projectPersonLink.projectID ");
            timeSheetSQLStrBuf.append("WHERE ");
            timeSheetSQLStrBuf.append(" timeSheet.timeSheetID = ?");
            timeSheetSQLStrBuf.append(" AND timeSheet.recordStatus = 'Active'");

            preparedStatement = connection.prepareStatement(timeSheetSQLStrBuf.toString());

            preparedStatement.setLong(1, timeSheetKey.getTimeSheetID());

            resultSet = preparedStatement.executeQuery();

            timeSheetDetail = new TimeSheetDetail();
            
            while (resultSet.next()) {

                timeSheetDetail.setTimeSheetID(resultSet.getLong("timeSheetID"));
                timeSheetDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
                timeSheetDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
                timeSheetDetail.setTotalRegularHours(resultSet.getInt("totalRegularHours"));
                timeSheetDetail.setTotalNoOfHoursWorked(resultSet.getInt("totalNoOfHoursWorked"));
                timeSheetDetail.setCreatedDateTime(resultSet.getDate("createdDateTime"));
                timeSheetDetail.setSubmittedDateTime(resultSet.getDate("submittedDateTime"));
                timeSheetDetail.setStartDate(resultSet.getDate("startDate"));
                timeSheetDetail.setEndDate(resultSet.getDate("endDate"));
                timeSheetDetail.setTimeSheetStatus(resultSet.getString("timeSheetStatus"));
                timeSheetDetail.setApprovalLevelType(resultSet.getString("approvalLevelType"));
                timeSheetDetail.setRecordStatus(resultSet.getString("recordStatus"));
                timeSheetDetail.setProjectName(resultSet.getString("projectName"));
                timeSheetDetail.setVersionNo(resultSet.getInt("versionNo"));
                
            }
            
            ReadTimeSheetLineItemFromPersonDAO readTimeSheetLineItemFromPersonDAO = new ReadTimeSheetLineItemFromPersonDAO();
            List<TimeSheetLineItemDetail> timeSheetLineItemDetailList =  readTimeSheetLineItemFromPersonDAO.readTimeSheetLineItem(timeSheetKey);
            
            timeSheetDetail.setTimeSheetLineItemDetailList(timeSheetLineItemDetailList);

            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

        } catch (SQLException e) {
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            e.printStackTrace();
        }
        /**
         * personDetail contains all attribute values
         */
        return timeSheetDetail;
    }

}
