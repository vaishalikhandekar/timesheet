/**
 * 
 */
package com.company.timesheet.profile.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class DeleteProjectDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	
	public String deleteProject(ProjectDetail projectDetail){
		
		
		String returnMassegeStr = "";
		
		try {
			/**
			 * get connected with database by calling getDBConnection() method
			 * of DBConnection class
			 */
			connection = DBConnection.getDBConnection();
			String projectSQLStr = "UPDATE	PROJECT SET	RECORDSTATUS='cancel'	WHERE	projectID=" + projectDetail.getProjectID();
			/**
			 * sending sql statement to the database
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(projectSQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for Person Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("Project");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setRelatedID(projectDetail.getProjectID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		return returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
		
	}

		
}
