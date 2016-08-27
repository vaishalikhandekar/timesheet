/**
 * 
 */
package com.company.timesheet.profile.employee.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;

/**
 * @author vaish
 *
 */
public class ReadEmployeeDAO {
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
	
	public String readEmployee(EmployeeDetail employeeDetail){
		
		String employeeSQLStr = "SELECT * FROM EMPLOYEE WHERE  employeeID=\'" + employeeDetail.getEmployeeID() + "\' ";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(employeeSQLStr);

			// System.out.println(preparedStatement.);
			resultSet = preparedStatement.executeQuery();
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {

				employeeDetail.setEmployeeID(resultSet.getLong("employeeID"));
				employeeDetail.setTitle(resultSet.getString("title"));
				employeeDetail.setFirstName(resultSet.getString("firstName"));
				employeeDetail.setMiddleName(resultSet.getString("middleName"));
				employeeDetail.setLastName(resultSet.getString("lastName"));
				employeeDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				employeeDetail.setGender(resultSet.getString("gender"));
				employeeDetail.setRecordStatus(resultSet.getString("recordStatus"));
				employeeDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				employeeDetail.setVersionNo(resultSet.getInt("versionNo"));
				employeeDetail.setStartDate(resultSet.getDate("startDate"));
				employeeDetail.setEndDate(resultSet.getDate("endDate"));
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
