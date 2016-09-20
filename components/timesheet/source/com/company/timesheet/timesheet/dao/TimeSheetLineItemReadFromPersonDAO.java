/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheet.pojo.TimeSheetKey;
import com.company.timesheet.timesheet.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemReadFromPersonDAO {
    
    
    /**
     * 
     * @param timeSheetKey
     * @return
     */
    public List<TimeSheetLineItemDetail> readTimeSheetLineItem(TimeSheetKey timeSheetKey) {

        List<TimeSheetLineItemDetail> timeSheetLineItemDetailList = new ArrayList<TimeSheetLineItemDetail>();

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet = null;

        String returnMassegeStr = "";

        TimeSheetLineItemDetail timeSheetLineItemDetail = null;

        String timeSheetLineSQLStr = "SELECT * FROM TimeSheetLineItem WHERE  timeSheetID=\'" + timeSheetKey.getTimeSheetID() + "\' ";

        try {

            connection = DBConnection.getDBConnection();

            preparedStatement = connection.prepareStatement(timeSheetLineSQLStr);

            // System.out.println(preparedStatement.);
            resultSet = preparedStatement.executeQuery();
            /**
             * if resultSet contains values then set it to the respected
             * attribute
             */

            while (resultSet.next()) {
                
                timeSheetLineItemDetail = new TimeSheetLineItemDetail();
                

                timeSheetLineItemDetail.setTimeSheetLineItemID(resultSet.getLong("timeSheetLineItemID"));
                timeSheetLineItemDetail.setTimeSheetID(resultSet.getLong("timeSheetID"));
                timeSheetLineItemDetail.setCategory(resultSet.getString("category"));
                timeSheetLineItemDetail.setAttendenceDate(resultSet.getDate("attendenceDate"));
                
                String dayOfWeek = JavaUtildates.getDayFromGivenDate(timeSheetLineItemDetail.getAttendenceDate());
                timeSheetLineItemDetail.setDayOfWeek(dayOfWeek);
                
                timeSheetLineItemDetail.setNoOfHoursWorked(resultSet.getInt("noOfHoursWorked"));
                timeSheetLineItemDetail.setComments(resultSet.getString("comments"));
                timeSheetLineItemDetail.setRecordStatus(resultSet.getString("recordStatus"));
                timeSheetLineItemDetail.setVersionNo(resultSet.getInt("versionNo"));
                

                timeSheetLineItemDetailList.add(timeSheetLineItemDetail);
            }
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

        } catch (SQLException e) {
            returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            e.printStackTrace();
        }
        /**
         * personDetail contains all attribute values
         */
        return timeSheetLineItemDetailList;
    }

}
