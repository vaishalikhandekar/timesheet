package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;

public class PersonListDAO {

    /**
     * 
     * @return
     */
    public List<PersonDetail> listPerson() {

        List<PersonDetail> personDetailList = new ArrayList<PersonDetail>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        PersonDetail personDetail = null;
        
        try {
            
            connection = DBConnection.getDBConnection();

            String personSQLStr = "SELECT * FROM Person"; // WHERE	RECORDSTATUS='Active'";

            // statement = connection.createStatement();

            preparedStatement = connection.prepareStatement(personSQLStr);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                personDetail = new PersonDetail();

                personDetail.setTitle(resultSet.getString("title"));
                personDetail.setPersonID(resultSet.getLong("personID"));
                personDetail.setFirstName(resultSet.getString("firstName"));
                personDetail.setMiddleName(resultSet.getString("middleName"));
                personDetail.setLastName(resultSet.getString("lastName"));
                personDetail.setGender(resultSet.getString("gender"));
                personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
                personDetail.setStartDate(resultSet.getDate("startDate"));
                personDetail.setEndDate(resultSet.getDate("endDate"));
                personDetail.setRecordStatus(resultSet.getString("recordStatus"));

                personDetailList.add(personDetail);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return personDetailList;
    }

}
