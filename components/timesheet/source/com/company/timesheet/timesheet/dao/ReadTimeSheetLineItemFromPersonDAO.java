/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class ReadTimeSheetLineItemFromPersonDAO {
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Statement statement = null;
	String returnMassegeStr = "";
	TimeSheetLineItemDetail timeSheetLineItemDetail = null;
		
		public TimeSheetLineItemDetail ReadTimeSheetLineItem(TimeSheetDetail timeSheetDetail){
				
			String timeSheetLineSQLStr = "SELECT * FROM TimeSheetLineItem WHERE  timeSheetID=\'" + timeSheetDetail.getTimeSheetID() + "\' ";

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
				    timeSheetLineItemDetail = new TimeSheetLineItemDetail();
				    
					timeSheetLineItemDetail.setTimeSheetLineItemID(resultSet.getLong("timeSheetLineItemID"));
					timeSheetLineItemDetail.setTimeSheetID(resultSet.getLong("timeSheetID"));
					timeSheetLineItemDetail.setCategory(resultSet.getString("category"));
					timeSheetLineItemDetail.setAttendenceDate(resultSet.getDate("attendenceDate"));
					timeSheetLineItemDetail.setNoOfHoursWorked(resultSet.getInt("noOfHoursWorked"));
					timeSheetLineItemDetail.setComments(resultSet.getString("comments"));
					timeSheetLineItemDetail.setRecordStatus(resultSet.getString("recordStatus"));
					timeSheetLineItemDetail.setVersionNo(resultSet.getInt("versionNo"));
				}
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
				e.printStackTrace();
			}
			/**
			 * personDetail contains all attribute values
			 */
			return timeSheetLineItemDetail;
		}

				
		}
	

