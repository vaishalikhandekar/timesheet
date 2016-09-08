/**
 * 
 */
package com.company.timesheet.timesheetlineitem.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheetlineitem.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class TimeSheetLineItemReadDAO {
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
		
		public String ReadTimeSheetLineItem(TimeSheetLineItemDetail timeSheetLineItemDetail){
				
			String timeSheetLineSQLStr = "SELECT * FROM TimeSheetLineItem WHERE  projectID=\'" + timeSheetLineItemDetail.getTimeSheetLineItemID() + "\' ";

			try {

				Connection connection = DBConnection.getDBConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(timeSheetLineSQLStr);

				// System.out.println(preparedStatement.);
				resultSet = preparedStatement.executeQuery();
				/**
				 * if resultSet contains values then set it to the respected
				 * attribute
				 */

				if (resultSet.next()) {
					timeSheetLineItemDetail.setTimeSheetLineItemID(resultSet.getLong("timeSheetLineItemID"));
					timeSheetLineItemDetail.setCategory(resultSet.getString("category"));
					timeSheetLineItemDetail.setAttendenceDate(resultSet.getDate("attendenceDate"));
					timeSheetLineItemDetail.setComments(resultSet.getString("comments"));
					timeSheetLineItemDetail.setRecordStatus(resultSet.getString("recordStatus"));
					timeSheetLineItemDetail.setVersionNo(resultSet.getInt("versionNo"));
					timeSheetLineItemDetail.setActualRegularHoursWorked(resultSet.getInt("actualRegularHoursWorked"));
					timeSheetLineItemDetail.setActualOvertimeHoursWorked(resultSet.getInt("actualOvertimeHoursWorked"));
				}
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
				e.printStackTrace();
			}
			/**
			 * personDetail contains all attribute values
			 */
			return returnMassegeStr;
		}

				
		}
	

