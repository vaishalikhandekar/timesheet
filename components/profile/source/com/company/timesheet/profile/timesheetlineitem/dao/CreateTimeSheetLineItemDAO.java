/**
 * 
 */
package com.company.timesheet.profile.timesheetlineitem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.profile.timesheet.pojo.TimeSheetDetail;
import com.company.timesheet.profile.timesheetlineitem.pojo.TimeSheetLineItemDetail;

/**
 * @author vaish
 *
 */
public class CreateTimeSheetLineItemDAO {
	

	public String createTimeSheetLineItem(
			TimeSheetLineItemDetail timeSheetLineItemDetail) {

		TimeSheetDetail timeSheetDetail = timeSheetLineItemDetail
				.getTimeSheetDetail();

		PreparedStatement preparedStatement = null;
		String returnMassegeStr = "";

		Connection connection = null;
		try {

			

			connection = DBConnection.getDBConnection();

			String TimeSheetLineItemSQLStr = "INSERT	INTO	TimeSheetLineItem(timeSheetLineItemID, timeSheetID, category, attendenceDate, actualRegularHoursWorked, actualOvertimeHoursWorked, comments, startDate, endDate, recordStatus, versionNo)	"
					+ " VALUES(?,?'"
					+ timeSheetLineItemDetail.getCategory()
					+ "','"
					+ timeSheetLineItemDetail.getAttendenceDate()
					+ "','"
					+ timeSheetLineItemDetail.getActualRegularHoursWorked()
					+ "','"
					+ timeSheetLineItemDetail.getActualOvertimeHoursWorked()
					+ "','"
					+ timeSheetLineItemDetail.getComments()
					+ "',?,?,'Active', 1)";

			preparedStatement = connection
					.prepareStatement(TimeSheetLineItemSQLStr);

			long timeSheetLineItemID = UniqueID.nextUniqueID();

			preparedStatement.setLong(1, timeSheetLineItemID);

			Long timeSheetID = UniqueID.nextUniqueID();

			preparedStatement.setLong(2, timeSheetID);

			preparedStatement.setDate(3, JavaUtildates
					.convertUtilToSql(timeSheetLineItemDetail.getStartDate()));

			preparedStatement.setDate(4, JavaUtildates
					.convertUtilToSql(timeSheetLineItemDetail.getEndDate()));

			preparedStatement.execute();

			String TimeSheetSQLStr = "INSERT	INTO	TimeSheet(timeSheetID, totalRegularHours, totalActualHours, submittedDate, timeSheetStatus, recordStatus, versionNo, startDate, endDate)	"
					+ "VALUES(?,'"
					+ timeSheetDetail.getTotalRegularHours()
					+ "','"
					+ timeSheetDetail.getTotalActualHours()
					+ "',?,'Submitted','Active',1, ?,?,)";

			PreparedStatement preparedStatement1 = connection
					.prepareStatement(TimeSheetSQLStr);

			preparedStatement1.setLong(1, timeSheetID);

			String crrentDateTime = JavaUtildates.getCurrentDateTime();

			Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
			preparedStatement1.setTimestamp(2, timestamp);

			preparedStatement1.setDate(3, JavaUtildates
					.convertUtilToSql(timeSheetLineItemDetail.getStartDate()));

			preparedStatement1.setDate(4, JavaUtildates
					.convertUtilToSql(timeSheetLineItemDetail.getEndDate()));

			preparedStatement1.execute();

			// inserting data into AuditTrail Table for TimeSheetLineItem Table
			AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

			auditTrailDetails.setTableName("TimeSheetLineItem");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setRelatedID(timeSheetLineItemDetail
					.getTimeSheetLineItemID());
			auditTrailDetails.setTransactionType("Online");

			CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

			// inserting data into AuditTrail Table for TimeSheet Table

			auditTrailDetails.setTableName("TimeSheet");
			auditTrailDetails.setOperationType("Create");
			auditTrailDetails.setRelatedID(timeSheetDetail.getTimeSheetID());
			auditTrailDetails.setTransactionType("Online");

			createAuditTrailDAO.createAuditTrail(auditTrailDetails);

			returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

		} catch (Exception e) {

		}
		return returnMassegeStr;
	}
	
	public static List<Date> getDateRange(Date startDate, Date endDate) {
		
		TimeSheetLineItemDetail timeSheetLineItemDetail;

        List<Date> ret = new ArrayList<Date>();
        
         startDate = JavaUtildates
				.convertUtilToSql(timeSheetLineItemDetail.getStartDate());
         endDate = JavaUtildates
        		 .convertUtilToSql(timeSheetLineItemDetail.getEndDate());
        
        while(startDate.before(endDate) || startDate.equals(endDate)) {
            ret.add(startDate);
            startDate = startDate+1;
        }
        return ret;
    }

    public static void main(String[] args) {

        DateTime start = DateTime.parse("2012-1-1");
        System.out.println("Start: " + start);

        DateTime end = DateTime.parse("2012-12-31");
        System.out.println("End: " + end);

        List<DateTime> between = getDateRange(start, end);
        for (DateTime d : between) {
            System.out.println(" " + d);
        }
    }

}
// One Way

/*
 * //Monday, February 29 is a leap day in 2016 (otherwise, February only has 28
 * days) LocalDate start = LocalDate.parse("2016-02-28"), end =
 * LocalDate.parse("2016-03-02");
 * 
 * //4 days between (end is inclusive in this example) Stream.iterate(start,
 * date -> date.plusDays(1)) .limit(ChronoUnit.DAYS.between(start, end) + 1)
 * .forEach(System.out::println);
 */

// Second Way

/*
 * long oneDayMilSec = 86400000; // number of milliseconds in one day
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 * 
 * try {
 * 
 * Date startDate = sdf.parse("2012-02-15"); Date endDate =
 * sdf.parse("2012-03-15");
 * 
 * long startDateMilSec = startDate.getTime(); long endDateMilSec =
 * endDate.getTime();
 * 
 * for(long d=startDateMilSec; d<=endDateMilSec; d=d+oneDayMilSec){
 * System.out.println(new Date(d)); }
 * 
 * } catch (ParseException e) { e.printStackTrace(); }
 */

