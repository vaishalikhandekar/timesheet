/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkUpdateDAO {
					
	PreparedStatement preparedStatement = null;
	Connection connection = null;
	ResultSet resultSet = null;
	
	public String updateProjectEmployeeLink(ProjectPersonLinkDetail projectPersonLinkDetail){
		
String returnMassegeStr = "";
		
		int versionNoFromUpdate = projectPersonLinkDetail.getVersionNo();

		int versionNoFromDatabase = returnVersionNumber(projectPersonLinkDetail);
		
		if (versionNoFromUpdate == versionNoFromDatabase) {

			versionNoFromDatabase++;

			try {
				connection = DBConnection.getDBConnection();
				String projectPersonLinkSQLStr = "UPDATE	ProjectPersonLink	SET role='" + projectPersonLinkDetail.getRole() + "', startDate= ?, endDate = ? , versionNo ='"
						+ versionNoFromDatabase + "' " + "	where	projectPersonLinkID='" + projectPersonLinkDetail.getProjectPersonLinkID() + "'";

				preparedStatement = connection.prepareStatement(projectPersonLinkSQLStr);

				preparedStatement.setDate(1, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getStartDate()));
				preparedStatement.setDate(2, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getEndDate()));
				preparedStatement.executeUpdate();
				
				//inserting data into AuditTrail Table for Person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("ProjectPersonLink");
				auditTrailDetails.setOperationType("Update");
				auditTrailDetails.setUserName("Rahul");
				auditTrailDetails.setRelatedID(projectPersonLinkDetail.getProjectPersonLinkID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else {
			projectPersonLinkDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}

		return returnMassegeStr;

	}

	public int returnVersionNumber(ProjectPersonLinkDetail projectPersonLinkDetail) {

		int versionNumber = 0;
		try {
			Connection connection = DBConnection.getDBConnection();

			String projectPersonLinkSQLStr = "SELECT	versionNo	FROM	ProjectPersonLink	WHERE	 projectPersonLinkID='" + projectPersonLinkDetail.getProjectID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(projectPersonLinkSQLStr);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				versionNumber = resultSet.getInt("versionNo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return versionNumber;
	}

	public void versionNumberIncreament(ProjectPersonLinkDetail projectPersonLinkDetail) {

		try {

			Connection connection = DBConnection.getDBConnection();
			// PersonDetail personDetail = new PersonDetail();
			String projectPersonLinkSQLStr = "UPDATE	ProjectPersonLink	SET	versionNo	=	versionNo+1	WHERE	projectPersonLinkID='" + projectPersonLinkDetail.getProjectPersonLinkID() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(projectPersonLinkSQLStr);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

		
	}
