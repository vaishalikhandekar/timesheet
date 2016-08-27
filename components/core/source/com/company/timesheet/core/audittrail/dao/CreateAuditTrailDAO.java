package com.company.timesheet.core.audittrail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;

public class CreateAuditTrailDAO {
	
	public String createAuditTrail(AuditTrailDetails auditTrailDetails)
	{
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			connection = DBConnection.getDBConnection();
			
			String auditTrailSQLStr = "INSERT INTO AuditTrail (tableName, operationType, userName, timeEntered, relatedID, transactionType) "
					+ "VALUES( ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(auditTrailSQLStr);

			preparedStatement.setString(1, auditTrailDetails.getTableName());
			preparedStatement.setString(2, auditTrailDetails.getOperationType());
			preparedStatement.setString(3, auditTrailDetails.getUserName());
			
			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement.setTimestamp(4, timestamp);
			preparedStatement.setLong(5,   auditTrailDetails.getRelatedID());
			preparedStatement.setString(6,   auditTrailDetails.getTransactionType());
			preparedStatement.executeQuery();
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;	
		}catch (SQLException e) {
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
		return returnMassegeStr;
	}

}
