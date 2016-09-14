/**
 * 
 */
package com.company.timesheet.profile.person.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;

/**
 * @author vaish
 *
 */
public class PersonReadDAO {
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
	
	public String readperson(PersonDetail personDetail){
		
		String personSQLStr = "SELECT * FROM person WHERE  personID=\'" + personDetail.getPersonID() + "\' ";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);

			// System.out.println(preparedStatement.);
			resultSet = preparedStatement.executeQuery();
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {

				personDetail.setPersonID(resultSet.getLong("personID"));
				personDetail.setTitle(resultSet.getString("title"));
				personDetail.setFirstName(resultSet.getString("firstName"));
				personDetail.setMiddleName(resultSet.getString("middleName"));
				personDetail.setLastName(resultSet.getString("lastName"));
				personDetail.setEmailAddress(resultSet.getString("emailAddress"));
				personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				personDetail.setGender(resultSet.getString("gender"));
				personDetail.setRecordStatus(resultSet.getString("recordStatus"));
				personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));
				personDetail.setStartDate(resultSet.getDate("startDate"));
				personDetail.setEndDate(resultSet.getDate("endDate"));
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
