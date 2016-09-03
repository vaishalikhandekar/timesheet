/**
 * 
 */
package com.company.timesheet.profile.projectpersonlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.profile.projectpersonlink.pojo.ProjectPersonLinkDetail;
import com.company.timesheet.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class CreateProjectEmployeeLinkDAO {
			
	public String CreateProjectEmployeeLink(ProjectPersonLinkDetail projectPersonLinkDetail){
		
		ProjectDetail projectDetail = projectPersonLinkDetail.getProjectDetail();
		
		String returnMassegeStr = "";
		
		PreparedStatement preparedStatement = null;
		
		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String projectSQLStr = "INSERT INTO ProjectPersonLink(projectPersonLinkID, projectID, role, comments, startDate, endDate, recordStatus, versionNo) "
					+ "VALUES (?,?, '"
					+ projectPersonLinkDetail.getRole()
					+ "','"
					+ projectPersonLinkDetail.getComments()
					+ "',?,?, 'Active'," + " 1 )";

			PreparedStatement preparedStatement1 = connection.prepareStatement(projectSQLStr);
			
			long projectPersonLinkID = UniqueID.nextUniqueID();
			preparedStatement1.setLong(1, projectPersonLinkID);
			
			preparedStatement1.setLong(2, projectDetail.getProjectID());
			
			projectPersonLinkDetail.setProjectPersonLinkID(projectPersonLinkID);
			
			preparedStatement1.setDate(3, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getStartDate()));
			preparedStatement1.setDate(4, JavaUtildates.convertUtilToSql(projectPersonLinkDetail.getEndDate()));


			preparedStatement1.execute();
			
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
