/**
 * 
 */
package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;

/**
 * @author vaish
 *
 */
public class PersonDeleteDAO {
	
	Connection connection = null;
	ResultSet resultSet = null;
	
	public String deletePerson(PersonDetail personDetail){
		
		String returnMassegeStr = "";
		
		try {
			/**
			 * get connected with database by calling getDBConnection() method
			 * of DBConnection class
			 */
			connection = DBConnection.getDBConnection();
			String personSQLStr = "UPDATE	Person SET	RECORDSTATUS='cancel'	WHERE	personID=" + personDetail.getPersonID();
			/**
			 * sending sql statement to the database
			 */
			PreparedStatement preparedStatement = connection.prepareStatement(personSQLStr);
			preparedStatement.executeUpdate();
			
			//inserting data into AuditTrail Table for Person Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
			
			auditTrailDetails.setTableName("Person");
			auditTrailDetails.setOperationType("Delete");
			auditTrailDetails.setRelatedID(personDetail.getPersonID());
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
