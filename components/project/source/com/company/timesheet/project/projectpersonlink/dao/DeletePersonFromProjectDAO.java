/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class DeletePersonFromProjectDAO {

	/**
	 * 
	 * @param projectPersonLinkDetail
	 * @return
	 */
	public String DeletePersonFromProjectLink(
	        ProjectDetail projectDetail) {

		Connection connection = null;
		String returnMassegeStr = "";

		try {
			/**
			 * get connected with database by calling getDBConnection() method
			 * of DBConnection class
			 */
			connection = DBConnection.getDBConnection();
			String projectSQLStr = "UPDATE	ProjectPersonLink SET	RECORDSTATUS='cancel'	WHERE	projectID="
					+ projectDetail.getProjectID();
			/**
			 * sending sql statement to the database
			 */
			PreparedStatement preparedStatement = connection
					.prepareStatement(projectSQLStr);
			preparedStatement.executeUpdate();

			// inserting data into AuditTrail Table for Person Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

			auditTrailDetails.setTableName("ProjectPersonLink");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setRelatedID(projectDetail
					.getProjectID());
			auditTrailDetails.setTransactionType("Online");

			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;

		}

		return returnMassegeStr;
	}

}
