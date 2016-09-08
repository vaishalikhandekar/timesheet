package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.profile.person.pojo.PersonSearchCriteria;
import com.company.timesheet.profile.person.pojo.PersonSearchDetails;

public class PersonSearchDAO {

	Connection connection = null;

	public List<PersonDetail> searchpersonInfo(PersonSearchDetails personSearchDetails) {

		List<PersonDetail> personDetailList = new ArrayList<PersonDetail>();
		PersonSearchCriteria personSearchCriteria = personSearchDetails.getPersonSearchCriteria();
		PersonDetail personDetail = null;

		String whereStr = "";

		String emptyStr = "";

		if (personSearchCriteria.getFirstName() != null && !personSearchCriteria.getFirstName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " firstName = '" + personSearchCriteria.getFirstName() + "'";
		}
		if (personSearchCriteria.getMiddleName() != null && !personSearchCriteria.getMiddleName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " middleName = '" + personSearchCriteria.getMiddleName() + "'";
		}
		if (personSearchCriteria.getLastName() != null && !personSearchCriteria.getLastName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " lastName = '" + personSearchCriteria.getLastName() + "'";
		}

		if (!whereStr.equals(emptyStr)) {

			try {
				connection = DBConnection.getDBConnection();
				String personSQLStr = "SELECT * " + " FROM person " + whereStr;

				PreparedStatement preparedstatement = connection.prepareStatement(personSQLStr);

				ResultSet resultSet = preparedstatement.executeQuery();

				while (resultSet.next()) {

					personDetail = new PersonDetail();
					personDetail.setPersonID(resultSet.getLong("personID"));
					personDetail.setTitle(resultSet.getString("title"));
					personDetail.setFirstName(resultSet.getString("firstName"));
					personDetail.setMiddleName(resultSet.getString("middleName"));
					personDetail.setLastName(resultSet.getString("lastName"));
					personDetail.setGender(resultSet.getString("gender"));
					personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
					personDetailList.add(personDetail);
				}

			} catch (Exception exception) {
				exception.printStackTrace();
			}

		} else {
			String errorMessage = "";

			errorMessage = "Please enter at least one attribute";
			personSearchDetails.setErrorMessage(errorMessage);
			;

		}

		return personDetailList;

	}
}
