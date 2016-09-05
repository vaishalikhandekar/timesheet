/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ReadProjectEmployeeLinkDAO {
			
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
	
	public String readProjectEmployeeLink(ProjectPersonLinkDetail projectPersonLinkDetail){
						
		String projectSQLStr = "SELECT * FROM ProjectPersonLink WHERE  projectPersonLinkID=\'" + projectPersonLinkDetail.getProjectPersonLinkID() + "\' ";

		try {

			Connection connection = DBConnection.getDBConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(projectSQLStr);

			// System.out.println(preparedStatement.);
			resultSet = preparedStatement.executeQuery();
			/**
			 * if resultSet contains values then set it to the respected
			 * attribute
			 */

			if (resultSet.next()) {
				projectPersonLinkDetail.setProjectID(resultSet.getLong("projectID"));
				//projectPersonLinkDetail.setEmployeeID(resultSet.getLong("employeeID"));
				projectPersonLinkDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
				projectPersonLinkDetail.setRole(resultSet.getString("role"));
				projectPersonLinkDetail.setComments(resultSet.getString("comments"));
				projectPersonLinkDetail.setStartDate(resultSet.getDate("startDate"));
				projectPersonLinkDetail.setEndDate(resultSet.getDate("endDate"));
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


