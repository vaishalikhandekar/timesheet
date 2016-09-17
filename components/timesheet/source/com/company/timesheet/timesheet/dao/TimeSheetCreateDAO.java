/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.timesheet.pojo.TimeSheetCreateDetails;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetCreateDAO {

	/**
	 * 
	 * @param personDetail
	 * @return
	 */
	public TimeSheetDetail createTimeSheet(TimeSheetCreateDetails timeSheetCreateDetails) {

        TimeSheetDetail timeSheetDetail = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnection.getDBConnection();

            // get projectPersonLinkID from ProjectPersonLink table

            StringBuffer timeSheetSQLStrBuf = new StringBuffer();

            timeSheetSQLStrBuf.append(" INSERT INTO ");
            timeSheetSQLStrBuf.append(" TimeSheet (");
            timeSheetSQLStrBuf.append(" timeSheetID, projectTimeSheetProcessID, projectPersonLinkID, ");
            timeSheetSQLStrBuf.append(" startDate, endDate, createdDateTime, ");
            timeSheetSQLStrBuf.append(" approvalLevelType, timeSheetStatus, recordStatus, versionNo ");
            timeSheetSQLStrBuf.append(" ) VALUES ( ");
            timeSheetSQLStrBuf.append(" ?, ?, ?, ");
            timeSheetSQLStrBuf.append(" ?, ?, ?, ");
            timeSheetSQLStrBuf.append(" ?, ?, ?, ? )");

            preparedStatement = connection
					.prepareStatement(timeSheetSQLStrBuf.toString());

            Long timeSheetID = UniqueID.nextUniqueID();
            
			preparedStatement.setLong(1, timeSheetID);
			preparedStatement.setLong(2, 4001);
			preparedStatement.setLong(3, 3001);

			preparedStatement.setDate(4, JavaUtildates
					.convertUtilToSql(timeSheetCreateDetails.getStartDate()));
			
			preparedStatement.setDate(5, JavaUtildates
					.convertUtilToSql(timeSheetCreateDetails.getStartDate()));
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(6, timestamp);


			preparedStatement.setString(7, "Level2");
			preparedStatement.setString(8, "Created");
			preparedStatement.setString(9, "Active");
			preparedStatement.setInt(10, 1);

			preparedStatement.execute();

           // Create all new entries in TimeSheetLineItem entity
			
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return timeSheetDetail;

    }

	/**
	 * 
	 * @param timeSheetCreateDetails
	 * @return
	 */
	public TimeSheetDetail readTimeSheet(
			TimeSheetCreateDetails timeSheetCreateDetails) {

		TimeSheetDetail timeSheetDetail = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet;

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
			timeSheetSQLStrBuf
					.append("LEFT OUTER JOIN ProjectPersonLink projectPersonLink ");
			timeSheetSQLStrBuf
					.append("ON timeSheet.projectPersonLinkID = projectPersonLink.projectPersonLinkID ");
			timeSheetSQLStrBuf.append("LEFT OUTER JOIN Project project ");
			timeSheetSQLStrBuf
					.append("ON project.projectID = projectPersonLink.projectID ");
			timeSheetSQLStrBuf.append("LEFT OUTER JOIN Person person ");
			timeSheetSQLStrBuf
					.append("ON person.personID = projectPersonLink.personID ");
			timeSheetSQLStrBuf.append("WHERE ");
			timeSheetSQLStrBuf.append(" projectPersonLink.projectID = ?");
			timeSheetSQLStrBuf.append(" AND timeSheet.recordStatus = 'Active'");

			preparedStatement = connection.prepareStatement(timeSheetSQLStrBuf
					.toString());

			preparedStatement.setLong(1, timeSheetCreateDetails.getProjectID());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				timeSheetDetail = new TimeSheetDetail();

				timeSheetDetail
						.setTimeSheetID(resultSet.getLong("timeSheetID"));
				timeSheetDetail.setProjectTimeSheetProcessID(resultSet
						.getLong("projectTimeSheetProcessID"));
				timeSheetDetail.setProjectPersonLinkID(resultSet
						.getLong("projectPersonLinkID"));
				timeSheetDetail.setTotalRegularHours(resultSet
						.getInt("totalRegularHours"));
				timeSheetDetail.setTotalNoOfHoursWorked(resultSet
						.getInt("totalNoOfHoursWorked"));
				timeSheetDetail.setCreatedDateTime(resultSet
						.getDate("createdDateTime"));
				timeSheetDetail.setSubmittedDateTime(resultSet
						.getDate("submittedDateTime"));
				timeSheetDetail.setStartDate(resultSet.getDate("startDate"));
				timeSheetDetail.setEndDate(resultSet.getDate("endDate"));
				timeSheetDetail.setTimeSheetStatus(resultSet
						.getString("timeSheetStatus"));
				timeSheetDetail.setApprovalLevelType(resultSet
						.getString("approvalLevelType"));
				timeSheetDetail.setRecordStatus(resultSet
						.getString("recordStatus"));
				timeSheetDetail.setProjectName(resultSet
						.getString("projectName"));
				timeSheetDetail.setFirstName(resultSet.getString("firstName"));
				timeSheetDetail.setLastName(resultSet.getString("lastName"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return timeSheetDetail;

	}
}
