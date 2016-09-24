/**
 * 
 */
package com.company.timesheet.timesheetlineitem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemUpdateDAO {


    /**
     * 
     * @param timeSheetDetail
     * @return
     */
    public String updateTimeSheetLineItem(TimeSheetDetail timeSheetDetail) {

        List<TimeSheetLineItemDetail> timeSheetLineItemDetailList = timeSheetDetail.getTimeSheetLineItemDetailList();

        PreparedStatement preparedStatement = null;
        Connection connection = null;

        TimeSheetLineItemDetail timeSheetLineItemDetail = null;
        
        String returnMassegeStr = "";

        for (int i = 0; i < timeSheetLineItemDetailList.size(); i++) {
            
            timeSheetLineItemDetail = timeSheetLineItemDetailList.get(i);
            
            int versionNoFromUpdate = timeSheetLineItemDetail.getVersionNo();

            int versionNoFromDatabase = returnVersionNumber(timeSheetLineItemDetail);

            if (versionNoFromUpdate == versionNoFromDatabase) {

                versionNoFromDatabase++;

                try {
                    connection = DBConnection.getDBConnection();
                    String projectSQLStr = "UPDATE	TimeSheetLineItem	SET category=?, comments=?, noOfHoursWorked = ?, versionNo ='"
                            + versionNoFromDatabase + "' " + "	where	timeSheetLineItemID=?";

                    preparedStatement = connection.prepareStatement(projectSQLStr);

                    preparedStatement.setString(1, timeSheetLineItemDetail.getCategory());
                    preparedStatement.setString(2, timeSheetLineItemDetail.getComments());
                    preparedStatement.setInt(3, timeSheetLineItemDetail.getNoOfHoursWorked());
                    preparedStatement.setLong(4, timeSheetLineItemDetail.getTimeSheetLineItemID());
                    
                    preparedStatement.executeUpdate();
                    
                    // update total number of worked
                    
                    timeSheetDetail.setTotalNoOfHoursWorked(timeSheetDetail.getTotalNoOfHoursWorked() + timeSheetLineItemDetail.getNoOfHoursWorked());

                    // inserting data into AuditTrail Table for Person Table
                    AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

                    auditTrailDetails.setTableName("Project");
                    auditTrailDetails.setOperationType("Update");
                    auditTrailDetails.setUserName("Rahul");
                    auditTrailDetails.setRelatedID(timeSheetLineItemDetail.getTimeSheetLineItemID());
                    auditTrailDetails.setTransactionType("Online");

                    CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
                    createAuditTrailDAO.createAuditTrail(auditTrailDetails);

                    returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

                } catch (SQLException e) {

                    e.printStackTrace();
                }

            } else {
                timeSheetLineItemDetail.getErrorMessageList().add("This Record has been already modified by another user, Please check");
                returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            }
        }

        return returnMassegeStr;

    }

    public int returnVersionNumber(TimeSheetLineItemDetail timeSheetLineItemDetail) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        
        int versionNumber = 0;
        try {
            connection = DBConnection.getDBConnection();

            String timeSheetLineItemSQLStr = "SELECT	versionNo	FROM	TimeSheetLineItem	WHERE	 timeSheetLineItemID='"
                    + timeSheetLineItemDetail.getTimeSheetLineItemID() + "'";
            preparedStatement = connection.prepareStatement(timeSheetLineItemSQLStr);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                versionNumber = resultSet.getInt("versionNo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return versionNumber;
    }

    public void versionNumberIncreament(TimeSheetLineItemDetail timeSheetLineItemDetail) {

        try {

            Connection connection = DBConnection.getDBConnection();
            // PersonDetail personDetail = new PersonDetail();
            String ProjectSQLStr = "UPDATE	TimeSheetLineItem	SET	versionNo	=	versionNo+1	WHERE	timeSheetLineItemID='"
                    + timeSheetLineItemDetail.getTimeSheetLineItemID() + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(ProjectSQLStr);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
