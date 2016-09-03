/**
 * 
 */
package com.company.timesheet.project.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class ReadProjectDAO {
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
	
		public String readProject(ProjectDetail projectDetail){
			
			String projectSQLStr = "SELECT * FROM PROJECT WHERE  projectID=\'" + projectDetail.getProjectID() + "\' ";

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
					projectDetail.setProjectID(resultSet.getLong("projectID"));
					projectDetail.setProjectName(resultSet.getString("projectName"));
					projectDetail.setDescription(resultSet.getString("description"));
					projectDetail.setComments(resultSet.getString("comments"));
					projectDetail.setRecordStatus(resultSet.getString("recordStatus"));
					projectDetail.setVersionNo(resultSet.getInt("versionNo"));
					projectDetail.setStartDate(resultSet.getDate("startDate"));
					projectDetail.setEndDate(resultSet.getDate("endDate"));
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
