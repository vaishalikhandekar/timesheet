/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetsForPersonDAO {

    public List<TimeSheetDetail> listTimeSheet(PersonDetail personDetail) {

        List<TimeSheetDetail> timeSheetDetailList = new ArrayList<TimeSheetDetail>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        TimeSheetDetail timeSheetDetail = null;
        try {
            connection = DBConnection.getDBConnection();

            // get projectPersonLinkID from ProjectPersonLink table

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
            timeSheetSQLStrBuf.append("timeSheet.recordStatus, ");
            timeSheetSQLStrBuf.append("project.projectName ");
            timeSheetSQLStrBuf.append("FROM ");
            timeSheetSQLStrBuf.append("TimeSheet timeSheet ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN ProjectPersonLink projectPersonLink ");
            timeSheetSQLStrBuf.append("ON timeSheet.projectPersonLinkID = projectPersonLink.projectPersonLinkID ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN Project project ");
            timeSheetSQLStrBuf.append("ON project.projectID = projectPersonLink.projectID ");
            timeSheetSQLStrBuf.append("WHERE ");
            timeSheetSQLStrBuf.append(" projectPersonLink.personID = ?");
            timeSheetSQLStrBuf.append(" AND timeSheet.recordStatus = 'Active'");

            preparedStatement = connection.prepareStatement(timeSheetSQLStrBuf.toString());

            preparedStatement.setLong(1, personDetail.getPersonID());

            String timeSheetSQLStr = "select * from TIMESHEET t  left outer join ProjectPersonLink pr on t.projectPersonLinkID = pr.projectPersonLinkID left outer join PERSON p on p.personID = pr.personID WHERE p.personID = 1001 and	RECORDSTATUS='Active'";

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                timeSheetDetail = new TimeSheetDetail();

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

                timeSheetDetailList.add(timeSheetDetail);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return timeSheetDetailList;

    }
}
