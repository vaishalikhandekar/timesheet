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
	 * @param personDetail
	 * @return
	 */
	public String registerPerson(PersonDetail personDetail) {

		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		String returnMassegeStr = "";
		boolean personExistInd = personExist(personDetail);
		boolean userNameExistInd = checkUserNameExist(personDetail);

		if (!personExistInd && !userNameExistInd) {

			UsersDetail usersDetail = personDetail.getUsersDetail();

			Connection connection = null;
			try {
				connection = DBConnection.getDBConnection();

				String usersSQLStr = "INSERT	INTO	USERS(userName, password, recordStatus, personID)	VALUES('" + usersDetail.getUserName()
						+ "','" + usersDetail.getPassword() + "','Active', ?)";
				preparedStatement = connection.prepareStatement(usersSQLStr);
				long personID = UniqueID.nextUniqueID();
				preparedStatement.setLong(1, personID);

				preparedStatement.execute();

				personDetail.setPersonID(personID);
				
				
				String personSQLStr = "INSERT INTO Person(personID, title, firstName, middleName, lastName, userName, gender, dateOfBirth, comments, emailAddress, phoneNumber, REGISTRATIONDATE, startDate, endDate, recordStatus, versionNo) "
						+ "VALUES (?, '"
						+ personDetail.getTitle()
						+ "', '"
						+ personDetail.getFirstName()
						+ "','"
						+ personDetail.getMiddleName()
						+ "','"
						+ personDetail.getLastName()
						+ "', "
						+ "'" + usersDetail.getUserName() + "','"
						
						+ personDetail.getGender()
						
						+ "' ,?,'"+personDetail.getComment()+"','"+personDetail.getEmailAddress()+"','"+personDetail.getPhoneNumber()+"',?,?,?, 'Active'," + " 1 )";

				 preparedStatement1 = connection.prepareStatement(personSQLStr);

				preparedStatement1.setLong(1, personDetail.getPersonID());
				preparedStatement1.setDate(2, JavaUtildates.convertUtilToSql(personDetail.getDateOfBirth()));

				String crrentDateTime = JavaUtildates.getCurrentDateTime();

				Timestamp timestamp = Timestamp.valueOf(crrentDateTime);
				preparedStatement1.setTimestamp(3, timestamp);
				
				preparedStatement1.setDate(4, JavaUtildates.convertUtilToSql(personDetail.getStartDate()));
				preparedStatement1.setDate(5, JavaUtildates.convertUtilToSql(personDetail.getEndDate()));


				preparedStatement1.execute();
				
				//inserting data into AuditTrail Table for person Table
				AuditTrailDetails auditTrailDetails = new AuditTrailDetails();
				
				auditTrailDetails.setTableName("person");
				auditTrailDetails.setOperationType("Create");
				auditTrailDetails.setUserName(usersDetail.getUserName());
				auditTrailDetails.setRelatedID(personDetail.getPersonID());
				auditTrailDetails.setTransactionType("Online");
				
				CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
				createAuditTrailDAO.createAuditTrail(auditTrailDetails);

				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

			} catch (SQLException e) {
				personDetail.getErrorMessageList().add("Username already exist");
				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;

			} catch (Exception e) {
				personDetail.getErrorMessageList().add("Main exception");
				e.printStackTrace();
				returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
			}
		}

		return returnMassegeStr;
	}

	/**
	 * 
	 * @param personDetail
	 */
	public boolean personExist(PersonDetail personDetail) {

		boolean personExistInd = false;

		try {

			PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria();

			personSearchCriteria.setFirstName(personDetail.getFirstName() == null ? "" : personDetail.getFirstName());
			personSearchCriteria.setMiddleName(personDetail.getMiddleName() == null ? "" : personDetail.getMiddleName());
			personSearchCriteria.setLastName(personDetail.getLastName() == null ? "" : personDetail.getLastName());

			PersonSearchDetails personSearchDetails = new PersonSearchDetails();
			personSearchDetails.setPersonSearchCriteria(personSearchCriteria);

			//
			PersonSearchDAO searchPersonDAO = new PersonSearchDAO();

			//
			List<PersonDetail> personDetailList = searchPersonDAO.searchpersonInfo(personSearchDetails);

			if (personDetailList.size() > 0) {

				personDetail.getErrorMessageList().add("Person already exist");

				personExistInd = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return personExistInd;

	}

	public boolean checkUserNameExist(PersonDetail personDetail) {

		Connection connection = null;
		try {
			connection = DBConnection.getDBConnection();

			String usersSQLStr = "SELECT userName FROM USERS where userName='" + personDetail.getUsersDetail().getUserName() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(usersSQLStr);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				personDetail.getErrorMessageList().add("UserName already exist");
				return true;

			}

		} catch (Exception E) {

		}

		return false;
	}

}
