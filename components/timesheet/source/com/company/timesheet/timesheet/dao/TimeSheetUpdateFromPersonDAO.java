/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetUpdateFromPersonDAO {
	
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
		
	public String updateTimeSheet(TimeSheetDetail timeSheetDetail){
		
		String returnMassegeStr = "";
		
		int versionNoFromUpdate = timeSheetDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(timeSheetDetail);
		
		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String timeSheetSQLStr = "UPDATE	TIMESHEET	SET totalRegularHours='" + timeSheetDetail.getTotalRegularHours() + "',	totalNoOfHoursWorked='"
						+ timeSheetDetail.getTotalNoOfHoursWorked() + "',startDate= ?, endDate = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	timeSheetID='" + timeSheetDetail.getTimeSheetID() + "'";

				preparedStatement = connection.prepareStatement(timeSheetSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(timeSheetDetail.getStartDate()));
				preparedStatement.setDate(2, JavaUtildates.convertUtilToSql(timeSheetDetail.getEndDate()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("TimeSheet");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(timeSheetDetail.getTimeSheetID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
		   // timeSheetDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(TimeSheetDetail timeSheetDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String timeSheetSQLStr = "SELECT	versionNo	FROM	TIMESHEET	WHERE	 timeSheetID='" + timeSheetDetail.getTimeSheetID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(timeSheetSQLStr);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(TimeSheetDetail timeSheetDetail) {

		try {

			Connection connection = DBConnection.getDBConnection();
			String timeSheetSQLStr = "UPDATE	TIMESHEET	SET	versionNo	=	versionNo+1	WHERE	timeSheetID='" + timeSheetDetail.getTimeSheetID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(timeSheetSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	


	}

