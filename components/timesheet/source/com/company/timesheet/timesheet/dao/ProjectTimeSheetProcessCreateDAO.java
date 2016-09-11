/**
 * 
 */
package com.company.timesheet.timesheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.pojo.ProjectSearchCriteria;
import com.company.timesheet.project.pojo.ProjectSearchDetails;
import com.company.timesheet.timesheet.pojo.ProjectTimeSheetProcessDetail;

/**
 * @author vaish
 *
 */
public class ProjectTimeSheetProcessCreateDAO {

	public String createProjectTimeSheetProcess(ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail) {
		String returnMassegeStr = "";

		PreparedStatement preparedStatement = null;

		 {

			Connection connection = null;
			try {
				connection = DBConnection.getDBConnection();

				String projectTimeSheetProcessSQLStr = "INSERT INTO ProjectTimeSheetProcess(projectTimeSheetProcessID, projectID, frequency, startDay, minimumApprovalLevelType, regularDailyHours, comments, startDate, endDate, recordStatus, versionNo) "
						+ "VALUES (?,?, '"
						+ projectTimeSheetProcessDetail.getFrequency()
						+ "','"
						+ projectTimeSheetProcessDetail.getStartDay()
						+ "', '"
						+ projectTimeSheetProcessDetail.getMinimumApprovalLevelType()
						+ "','"
						+ projectTimeSheetProcessDetail.getRegularDailyHours()
						+ "','"+projectTimeSheetProcessDetail.getComments()+"',?,?, 'Active',"
						+ " 1 )";

				 preparedStatement = connection
						.prepareStatement(projectTimeSheetProcessSQLStr);

				long projectTimeSheetProcessID = UniqueID.nextUniqueID();
				preparedStatement.setLong(1, projectTimeSheetProcessID);
				preparedStatement.setLong(2, projectTimeSheetProcessDetail.getProjectID());

				preparedStatement.setDate(3, JavaUtildates
						.convertUtilToSql(projectTimeSheetProcessDetail.getStartDate()));
				preparedStatement.setDate(4, JavaUtildates
						.convertUtilToSql(projectTimeSheetProcessDetail.getEndDate()));
				
				projectTimeSheetProcessDetail.setProjectTimeSheetProcessID(projectTimeSheetProcessID);

				preparedStatement.execute();

				// inserting data into AuditTrail Table for Project Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

				auditTrailDetails.setTableName("ProjectTimeSheetProcess");
				auditTrailDetails.setOperationType("Create");
				auditTrailDetails.setRelatedID(projectTimeSheetProcessDetail.getProjectTimeSheetProcessID());
				auditTrailDetails.setTransactionType("Online");

				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {

				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}
		return returnMassegeStr;

	}

	}
