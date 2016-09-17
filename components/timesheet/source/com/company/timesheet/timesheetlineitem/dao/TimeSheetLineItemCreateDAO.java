/**
 * 
 */
package com.company.timesheet.timesheetlineitem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.timesheet.pojo.TimeSheetLineItemDetail;

//import java.util.Date;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemCreateDAO {

    /**
     * 
     * @param timeSheetLineItemDetail
     * @return
     */
    public String createTimeSheetLineItem(TimeSheetLineItemDetail timeSheetLineItemDetail) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String returnMassegeStr = "";

        try {

            connection = DBConnection.getDBConnection();

            StringBuffer timeSheetLineItemSQLStrBuf = new StringBuffer();

            timeSheetLineItemSQLStrBuf.append(" INSERT INTO ");
            timeSheetLineItemSQLStrBuf.append(" TimeSheetLineItem (");
            timeSheetLineItemSQLStrBuf.append(" timeSheetLineItemID, timeSheetID, category, ");
            timeSheetLineItemSQLStrBuf.append(" attendenceDate, noOfHoursWorked, ");
            timeSheetLineItemSQLStrBuf.append(" comments, recordStatus, versionNo ");
            timeSheetLineItemSQLStrBuf.append(" ) VALUES ( ");
            timeSheetLineItemSQLStrBuf.append(" ?, ?, ?, ");
            timeSheetLineItemSQLStrBuf.append(" ?, ?, ");
            timeSheetLineItemSQLStrBuf.append(" ?, ?, ? )");

            preparedStatement = connection.prepareStatement(timeSheetLineItemSQLStrBuf.toString());

            long timeSheetLineItemID = UniqueID.nextUniqueID();

            preparedStatement.setLong(1, timeSheetLineItemID);

            preparedStatement.setLong(2, timeSheetLineItemDetail.getTimeSheetID());

            preparedStatement.setString(3, timeSheetLineItemDetail.getCategory());

            preparedStatement.setDate(4, JavaUtildates.convertUtilToSql(timeSheetLineItemDetail.getAttendenceDate()));

            preparedStatement.setInt(5, timeSheetLineItemDetail.getNoOfHoursWorked());

            preparedStatement.setString(6, timeSheetLineItemDetail.getComments());

            preparedStatement.setString(7, "Active");

            preparedStatement.setInt(8, 1);

            preparedStatement.execute();

            // inserting data into AuditTrail Table for TimeSheetLineItem Table
            CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();

            AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

            auditTrailDetails.setTableName("TimeSheetLineItem");
            auditTrailDetails.setOperationType("Create");
            auditTrailDetails.setRelatedID(timeSheetLineItemDetail.getTimeSheetLineItemID());
            auditTrailDetails.setTransactionType("Online");

            createAuditTrailDAO.createAuditTrail(auditTrailDetails);

            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

        } catch (Exception e) {

        }
        return returnMassegeStr;
    }

}
