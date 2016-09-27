/**
 * 
 */
package com.company.timesheet.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class ProjectDeleteDAO {

    /**
     * 
     * @param projectDetail
     * @return
     */
    public String deleteProject(ProjectDetail projectDetail) {

        String returnMassegeStr = "";

        Connection connection = null;
        PreparedStatement preparedStatement = null;


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
            preparedStatement = connection.prepareStatement(projectSQLStr);
            preparedStatement.executeUpdate();

            // inserting data into AuditTrail Table for Person Table
            AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

            auditTrailDetails.setTableName("Project");
            auditTrailDetails.setOperationType("Delete");
            auditTrailDetails.setRelatedID(projectDetail.getProjectID());
            auditTrailDetails.setTransactionType("Online");

            CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
            createAuditTrailDAO.createAuditTrail(auditTrailDetails);

            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

        } catch (SQLException e) {

            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            e.printStackTrace();
        }

        return returnMassegeStr;

    }

}
