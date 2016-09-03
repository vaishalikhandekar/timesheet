/**
 * 
 */
package com.company.timesheet.project.dao;

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

/**
 * @author vaish
 *
 */
public class UpdateProjectDAO {
	
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
		
	public String updateProject(ProjectDetail projectDetail){
		
		String returnMassegeStr = "";
		
		int versionNoFromUpdate = projectDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(projectDetail);
		
		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String projectSQLStr = "UPDATE	PROJECT	SET projectName='" + projectDetail.getProjectName() + "',	description='"
						+ projectDetail.getDescription() + "', comments='" + projectDetail.getComments() + "', startDate= ?, endDate = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	projectID='" + projectDetail.getProjectID() + "'";

				preparedStatement = connection.prepareStatement(projectSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(projectDetail.getStartDate()));
				preparedStatement.setDate(2, JavaUtildates.convertUtilToSql(projectDetail.getEndDate()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Project");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(projectDetail.getProjectID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			projectDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(ProjectDetail projectDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String projectSQLStr = "SELECT	versionNo	FROM	PROJECT	WHERE	 projectID='" + projectDetail.getProjectID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(projectSQLStr);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(ProjectDetail projectDetail) {

		try {

			Connection connection = DBConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String ProjectSQLStr = "UPDATE	PROJECT	SET	versionNo	=	versionNo+1	WHERE	projectID='" + projectDetail.getProjectID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(ProjectSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	


	}

