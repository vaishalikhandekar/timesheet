package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.UsersDetail;

/**
 * PersonLoginDAO class creating logic for person login
 * 
 * @author vaish
 */
public class PersonLoginDAO {

	PreparedStatement preparedStatement;

	ResultSet resultSet;

	/**
	 * method for login passing object of usersDetail class because we require
	 * username & password fields from usersDetail class
	 */
	// public String login(UsersDetail usersDetail) {
	public String login(UsersDetail usersDetail) {
		// UsersDetail usersDetail = personDetail.getUsersDetail();
		// List<String> errorMessageList = new ArrayList<String>();

		// string to return success or failure
		String returnMassegeStr = "";

		// query to find matched username & password
		String usersSQLStr = "SELECT USERNAME, PASSWORD, LOGINFAILURECOUNT, accountEnabled FROM USERS WHERE USERNAME='"
				+ usersDetail.getUserName() + "'";

		// create object of class DBConnection class
		Connection connection = null;

		try {
			// get database connection
			connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatementUsers = connection.prepareStatement(usersSQLStr);

			// store resultset object into the resultSet object
			resultSet = preparedStatementUsers.executeQuery();

			String personSQLStr = "SELECT personID FROM Users WHERE  USERNAME='" + usersDetail.getUserName() + "'";
			PreparedStatement preparedStatementPerson = connection.prepareStatement(personSQLStr);
			ResultSet resultSetPerson = preparedStatementPerson.executeQuery();

			if (resultSetPerson.next()) {
				usersDetail.setPersonID(resultSetPerson.getLong("personID"));
			}

			// if resultSet contain values then return success

			if (resultSet.next()) {

				int accountEnabled = resultSet.getInt("accountEnabled");
				int loginFailureCount = resultSet.getInt("loginFailureCount");

				if (accountEnabled == 1) {

					// account is enabled
					if (resultSet.getString("password").equals(usersDetail.getPassword())) {

						// password matched
						returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

						// if users login failure is greater than 0, on
						// successful login reset counter to 0.
						if (loginFailureCount > 0)
							updateLoginFailure(usersDetail, connection, 0);

					} else {

						//
						updateLoginFailure(usersDetail, connection, ++loginFailureCount);
						returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
					}
				} else {

					// errorMessageList.add("Your acoount is locked Please contact to administrator");
					updateLoginFailure(usersDetail, connection, ++loginFailureCount);
					returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;

				}

			} else {

				// user does not exist in the system
				updateAuthenticationLog(usersDetail, connection);
				usersDetail.getErrorMessageList().add("Please enter correct UserName and/or Password - Not Exist");
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;

			}

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;
	}

	/**
	 * @param usersDetail
	 * @param connection
	 * @throws SQLException
	 */
	protected void updateLoginFailure(UsersDetail usersDetail, Connection connection, int loginFailureCount) throws SQLException {

		int accountEnabled = (loginFailureCount >= 3) ? 0 : 1;

		String usersSQLStr = "UPDATE Users SET loginFailureCount = " + loginFailureCount + " , accountEnabled = " + accountEnabled
				+ " WHERE userName='" + usersDetail.getUserName() + "'";

		preparedStatement = connection.prepareStatement(usersSQLStr);

		preparedStatement.executeQuery();

		if (accountEnabled == 0) {

			usersDetail.getErrorMessageList().add("your account is locked Please contact to administrator");

		}

		if (accountEnabled == 1 && loginFailureCount > 0) {

			usersDetail.getErrorMessageList().add("Please enter correct UserName and/or Password");

		}

	}

	/**
	 * @param usersDetail
	 * @param connection
	 */
	private void updateAuthenticationLog(UsersDetail usersDetail, Connection connection) {


	}

}
