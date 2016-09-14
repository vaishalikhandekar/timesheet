/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetReadFromPersonDAO {

    PreparedStatement preparedStatement = null;
    
    TimeSheetDetail timeSheetDetail = null;

    ResultSet resultSet = null;

    Statement statement = null;

    String returnMassegeStr = "";

    public String readTimeSheet(PersonDetail personDetail) {

        try {

            Connection connection = DBConnection.getDBConnection();

            StringBuffer timeSheetSQLStrBuf = new StringBuffer();

            timeSheetSQLStrBuf.append("SELECT ");
            timeSheetSQLStrBuf
                    .append("t.totalRegularHours, t.totalNoOfHoursWorked, t.startDate, t.endDate, t.timeSheetID, t.versionNo");
            timeSheetSQLStrBuf.append("FROM ");
            timeSheetSQLStrBuf
                    .append("TIMESHEET t left outer join PROJECTPERSONLINK pr on t.projectPersonLinkID = pr.projectPersonLinkID left outer join PERSON p   on p.PERSONID = pr.PERSONID ");
            timeSheetSQLStrBuf.append("WHERE ");
            timeSheetSQLStrBuf.append(" p.personID = ?");

            PreparedStatement preparedStatement = connection.prepareStatement(timeSheetSQLStrBuf.toString());

            preparedStatement.setLong(1, personDetail.getPersonID());

            resultSet = preparedStatement.executeQuery();
            /**
             * if resultSet contains values then set it to the respected
             * attribute
             */

            if (resultSet.next()) {
                
                timeSheetDetail = new TimeSheetDetail();
                
                timeSheetDetail.setTimeSheetID(resultSet.getLong("timeSheetID"));
                timeSheetDetail.setTotalRegularHours(resultSet.getInt("totalRegularHours"));
                timeSheetDetail.setTotalNoOfHoursWorked(resultSet.getInt("totalNoOfHoursWorked"));
                timeSheetDetail.setStartDate(resultSet.getDate("startDate"));
                timeSheetDetail.setEndDate(resultSet.getDate("endDate"));
                timeSheetDetail.setVersionNo(resultSet.getInt("versionNo"));
            }
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

        } catch (SQLException e) {
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            e.printStackTrace();
        }
        /**
         * personDetail contains all attribute values
         */
        return returnMassegeStr;
    }

}
