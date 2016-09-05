/**
 * 
 */
package com.company.timesheet.timesheetlineitem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class UpdateTimeSheetLineItemDAO {
		
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	
	public String updateTimeSheetLineItem(TimeSheetLineItemDetail timeSheetLineItemDetail){
		
		String returnMassegeStr = "";
		
		int versionNoFromUpdate = timeSheetLineItemDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(timeSheetLineItemDetail);
		
		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String projectSQLStr = "UPDATE	TimeSheetLineItem	SET category='" + timeSheetLineItemDetail.getCategory() + "',attendenceDate = ?, comments='" + timeSheetLineItemDetail.getComments() + "',actualRegularHoursWorked = '"+timeSheetLineItemDetail.getActualRegularHoursWorked()+"',actualOvertimeHoursWorked = '"+timeSheetLineItemDetail.getActualOvertimeHoursWorked()+"', versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	projectID='" + timeSheetLineItemDetail.getTimeSheetLineItemID() + "'";

				preparedStatement = connection.prepareStatement(projectSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(timeSheetLineItemDetail.getAttendenceDate()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Project");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(timeSheetLineItemDetail.getTimeSheetLineItemID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			timeSheetLineItemDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(TimeSheetLineItemDetail timeSheetLineItemDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String timeSheetLineItemSQLStr = "SELECT	versionNo	FROM	TimeSheetLineItem	WHERE	 timeSheetLineItemID='" + timeSheetLineItemDetail.getTimeSheetLineItemID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(timeSheetLineItemSQLStr);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(TimeSheetLineItemDetail timeSheetLineItemDetail) {

		try {

			Connection connection = DBConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String ProjectSQLStr = "UPDATE	TimeSheetLineItem	SET	versionNo	=	versionNo+1	WHERE	timeSheetLineItemID='" + timeSheetLineItemDetail.getTimeSheetLineItemID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(ProjectSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	



		
	}
	

