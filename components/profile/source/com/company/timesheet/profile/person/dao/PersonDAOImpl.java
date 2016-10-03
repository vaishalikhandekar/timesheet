/**
 * 
 */
package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;

/**
 * @author Chetan Khandekar
 *
 */
public class PersonDAOImpl implements PersonDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.company.timesheet.profile.person.dao.PersonDAO#liveProjectCount()
	 */
	@Override
	public String liveProjectCount() {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String projectCount = "0";
		try {

			connection = DBConnection.getDBConnection();

			String personSQLStr = "select count(*) from project";
			preparedStatement = connection.prepareStatement(personSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				projectCount = resultSet.getString(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return projectCount;
	}
}
