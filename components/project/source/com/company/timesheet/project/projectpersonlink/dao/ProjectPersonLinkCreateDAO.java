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
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkCreateDAO {
			
	public String createProjectEmployeeLink(ProjectPersonLinkDetail projectPersonLinkDetail){
		
		ProjectDetail projectDetail = projectPersonLinkDetail.getProjectDetail();
		
		String returnMassegeStr = "";
		
		PreparedStatement preparedStatement = null;
		
		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();
			
			
			String projectSQLStr = "INSERT INTO ProjectPersonLink(projectPersonLinkID, projectID, personID, role, comments, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES (?,?,?, '"
					+ projectPersonLinkDetail.getRole()
					+ "','"
					+ projectPersonLinkDetail.getComments()
					+ "',?,?, 'Active'," + " 1 )";

			preparedStatement = connection.prepareStatement(projectSQLStr);
			
			long projectPersonLinkID = UniqueID.nextUniqueID();
			preparedStatement.setLong(1, projectPersonLinkID);
			
			preparedStatement.setLong(2, projectPersonLinkDetail.getProjectID());
			preparedStatement.setLong(3, projectPersonLinkDetail.getPersonID());
			
			projectPersonLinkDetail.setProjectPersonLinkID(projectPersonLinkID);
			
			preparedStatement.setDate(4, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getStartDate()));
			preparedStatement.setDate(5, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getEndDate()));


			preparedStatement.execute();
			
			
			//inserting data into AuditTrail Table for Employee Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("ProjectEmployeeLinkID");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setRelatedID(projectPersonLinkDetail.getProjectPersonLinkID());
			auditTrailDetails.setTransactionType("Online");
			
			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);
			
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		}catch(SQLException e){
			
			e.printStackTrace();
			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
		}
	
	return returnMassegeStr;	
		

		
	}
}
