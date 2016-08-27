package com.company.timesheet.profile.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;

public class UpdateEmployeeDAO {
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	
	public String updateEmployee(EmployeeDetail employeeDetail){
		
		
		String returnMassegeStr = "";

		int versionNoFromUpdate = employeeDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(employeeDetail);
		
		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String employeeSQLStr = "UPDATE	EMPLOYEE	SET title='" + employeeDetail.getTitle() + "',	firstName='"
						+ employeeDetail.getFirstName() + "', middleName='" + employeeDetail.getMiddleName() + "', lastName='"
						+ employeeDetail.getLastName() + "', gender='" + employeeDetail.getGender() + "', dateOfBirth = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	employeeID='" + employeeDetail.getEmployeeID() + "'";

				preparedStatement = connection.prepareStatement(employeeSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(employeeDetail.getDateOfBirth()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Person");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(employeeDetail.getEmployeeID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			employeeDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(EmployeeDetail employeeDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String employeeSQLStr = "SELECT	versionNo	FROM	EMPLOYEE	WHERE	 employeeID='" + employeeDetail.getEmployeeID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(employeeSQLStr);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(EmployeeDetail employeeDetail) {

		try {

			Connection connection = DBConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String PersonSQLStr = "UPDATE	EMPLOYEE	SET	versionNo	=	versionNo+1	WHERE	employeeID='" + employeeDetail.getEmployeeID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(PersonSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	


		
	}

