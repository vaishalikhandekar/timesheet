package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.PersonSearchCriteria;
import com.company.timesheet.profile.person.pojo.PersonSearchDetails;
import com.company.timesheet.profile.person.pojo.UsersDetail;

/**
 * PersonRegistrationDAO class create logic for person registration
 */
public class PersonCreateDAO {

	/**
	 * 
	 * @param employeeDetail
	 * @return
	 */
	public String registerEmployee(PersonDetail employeeDetail) {

		PreparedStatement preparedStatement = null;
		String returnMassegeStr = "";
		boolean employeeExistInd = employeeExist(employeeDetail);
		boolean userNameExistInd = checkUserNameExist(employeeDetail);

		if (!employeeExistInd && !userNameExistInd) {

			UsersDetail usersDetail = employeeDetail.getUsersDetail();

			Connection connection = null;
			try {
				connection = DBConnection.getDBConnection();

				String usersSQLStr = "INSERT	INTO	USERS(userName, password, recordStatus, employeeID)	VALUES('" + usersDetail.getUserName()
						+ "','" + usersDetail.getPassword() + "','Active', ?)";
				preparedStatement = connection.prepareStatement(usersSQLStr);
				long employeeID = UniqueID.nextUniqueID();
				preparedStatement.setLong(1, employeeID);

				preparedStatement.execute();

				employeeDetail.setEmployeeID(employeeID);
				
				
				String employeeSQLStr = "INSERT INTO EMPLOYEE(employeeID, title, firstName, middleName, lastName, userName, gender, dateOfBirth, comments, REGISTRATIONDATE, recordStatus, versionNo) "
						+ "VALUES (?, '"
						+ employeeDetail.getTitle()
						+ "', '"
						+ employeeDetail.getFirstName()
						+ "','"
						+ employeeDetail.getMiddleName()
						+ "','"
						+ employeeDetail.getLastName()
						+ "', "
						+ "'" + usersDetail.getUserName() + "','"
						
						+ employeeDetail.getGender()
						
						+ "' ,?,'"+employeeDetail.getComment()+"',?, 'Active'," + " 1 )";

				PreparedStatement preparedStatement1 = connection.prepareStatement(employeeSQLStr);

				preparedStatement1.setLong(1, employeeDetail.getEmployeeID());
				preparedStatement1.setDate(2, JavaUtildates.convertUtilToSql(employeeDetail.getDateOfBirth()));

				String crrentDateTime = JavaUtildates.getCurrentDateTime();

				Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
				preparedStatement1.setTimestamp(3, timestamp);
				
				/*preparedStatement1.setDate(4, JavaUtildates.convertUtilToSql(employeeDetail.getStartDate()));
				preparedStatement1.setDate(5, JavaUtildates.convertUtilToSql(employeeDetail.getEndDate()));*/


				preparedStatement1.execute();
				
				//inserting data into AuditTrail Table for Employee Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("Employee");
				auditTrailDetails.setOperationType("Create");
				auditTrailDetails.setUserName(usersDetail.getUserName());
				auditTrailDetails.setRelatedID(employeeDetail.getEmployeeID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {
				employeeDetail.getErrorMessageList().add("Username already exist");
				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;

			} catch (Exception e) {
				employeeDetail.getErrorMessageList().add("Main exception");
				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;
	}

	/**
	 * 
	 * @param employeeDetail
	 */
	public boolean employeeExist(PersonDetail employeeDetail) {

		boolean employeeExistInd = false;

		try {

			PersonSearchCriteria employeeSearchCriteria = new PersonSearchCriteria();

			employeeSearchCriteria.setFirstName(employeeDetail.getFirstName() == null ? "" : employeeDetail.getFirstName());
			employeeSearchCriteria.setMiddleName(employeeDetail.getMiddleName() == null ? "" : employeeDetail.getMiddleName());
			employeeSearchCriteria.setLastName(employeeDetail.getLastName() == null ? "" : employeeDetail.getLastName());

			PersonSearchDetails employeeSearchDetails = new PersonSearchDetails();
			employeeSearchDetails.setEmployeeSearchCriteria(employeeSearchCriteria);

			//
			PersonSearchDAO searchPersonDAO = new PersonSearchDAO();

			//
			List<PersonDetail> employeeDetailList = searchPersonDAO.searchEmployeeInfo(employeeSearchDetails);

			if (employeeDetailList.size() > 0) {

				employeeDetail.getErrorMessageList().add("Person already exist");

				employeeExistInd = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return employeeExistInd;

	}

	public boolean checkUserNameExist(PersonDetail employeeDetail) {

		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String usersSQLStr = "SELECT userName FROM USERS where userName='" + employeeDetail.getUsersDetail().getUserName() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(usersSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				employeeDetail.getErrorMessageList().add("UserName already exist");
				return true;

			}

		} catch (Exception E) {

		}

		return false;
	}

}
