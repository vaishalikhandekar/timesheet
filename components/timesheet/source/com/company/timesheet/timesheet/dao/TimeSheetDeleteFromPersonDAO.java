/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetDeleteFromPersonDAO {

	/**
	 * 
	 * @param personDetail
	 * @return
	 */
    public String deleteTimeSheet(PersonDetail personDetail) {

        String returnMassegeStr = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet;
        TimeSheetDetail timeSheetDetail = null;
        try {
            connection = DBConnection.getDBConnection();

            String projectPersonLinkSQLStr = "SELECT projectPersonLinkID FROM projectPersonLink  WHERE   personID=" + personDetail.getPersonID();
            
            preparedStatement = connection.prepareStatement(projectPersonLinkSQLStr);
            resultSet =  preparedStatement.executeQuery();
            
             
             while(resultSet.next()){
                 timeSheetDetail = new TimeSheetDetail();
                 timeSheetDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
             }
            
             String timeSheetSQLStr = "UPDATE  TIMESHEET SET RECORDSTATUS='cancel'   WHERE   projectPersonLinkID=" + timeSheetDetail.getProjectPersonLinkID();
             /**
              * sending sql statement to the database
              */
             preparedStatement1 = connection.prepareStatement(timeSheetSQLStr);
             preparedStatement1.executeUpdate();
             
             
            //inserting data into AuditTrail Table for Person Table
           /* AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
            
            auditTrailDetails.setTableName("TimeSheet");
            auditTrailDetails.setOperationType("Delete");
           // auditTrailDetails.setRelatedID(timeSheetDetail.getTimeSheetID());
            auditTrailDetails.setTransactionType("Online");
            
            CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
            createAuditTrailDAO.createAuditTrail(auditTrailDetails);*/

            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;
            
        } catch (SQLException e) {

            e.printStackTrace();
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
        }

        return returnMassegeStr;

    }
}
