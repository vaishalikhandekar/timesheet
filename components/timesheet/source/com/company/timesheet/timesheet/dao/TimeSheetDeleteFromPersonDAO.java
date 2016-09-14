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

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetDeleteFromPersonDAO {

	/**
	 * 
	 * @param personDetail
	 * @return
	 */
    public String deleteTimeSheet(PersonDetail personDetail) {

        String returnMassegeStr = "";
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
            timeSheetSQLStrBuf.append("person.firstName, ");
            timeSheetSQLStrBuf.append("person.lastName, ");
            timeSheetSQLStrBuf.append("project.projectName ");
            timeSheetSQLStrBuf.append("FROM ");
            timeSheetSQLStrBuf.append("TimeSheet timeSheet ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN ProjectPersonLink projectPersonLink ");
            timeSheetSQLStrBuf.append("ON timeSheet.projectPersonLinkID = projectPersonLink.projectPersonLinkID ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN Project project ");
            timeSheetSQLStrBuf.append("ON project.projectID = projectPersonLink.projectID ");
            timeSheetSQLStrBuf.append("LEFT OUTER JOIN Person person ");
            timeSheetSQLStrBuf.append("ON person.personID = projectPersonLink.personID ");
            timeSheetSQLStrBuf.append("WHERE ");
            timeSheetSQLStrBuf.append(" projectPersonLink.projectID = ?");
            timeSheetSQLStrBuf.append(" AND timeSheet.recordStatus = 'Active'");

            preparedStatement = connection.prepareStatement(timeSheetSQLStrBuf.toString());

           preparedStatement.executeUpdate();

           

                returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
            

        } catch (SQLException e) {

            e.printStackTrace();
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
        }

        return returnMassegeStr;

    }
}
