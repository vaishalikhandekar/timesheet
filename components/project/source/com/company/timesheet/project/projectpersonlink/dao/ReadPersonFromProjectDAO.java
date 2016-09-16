/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ReadPersonFromProjectDAO {

	public ProjectPersonLinkDetail readPersonFromProject(
	        ProjectPersonLinkDetail projectPersonLinkDetail) {

		Connection connection = null;
		PersonDetail personDetail = null;
		ProjectDetail projectDetail = null;

		try {
			connection = DBConnection.getDBConnection();

			StringBuffer projectPersonLinkSQLStrBuf = new StringBuffer();
			
			projectPersonLinkSQLStrBuf.append("SELECT ");
			projectPersonLinkSQLStrBuf.append("p.TITLE, p.FIRSTNAME, p.MIDDLENAME, p.LASTNAME, p.GENDER, p.DATEOFBIRTH, p.registrationDate, p.personID, p.versionNo, ppl.ROLE, ppl.projectPersonLinkID, ppl.versionNo, ppl.personID, pr.PROJECTID, pr.PROJECTNAME ");
			projectPersonLinkSQLStrBuf.append("FROM ");
			projectPersonLinkSQLStrBuf.append("PROJECTPERSONLINK ppl left outer join project pr on pr.projectID = ppl.projectID left outer join PERSON p   on p.PERSONID = ppl.PERSONID ");
			projectPersonLinkSQLStrBuf.append("WHERE ");
			projectPersonLinkSQLStrBuf.append(" ppl.RecordStatus='Active'");
			projectPersonLinkSQLStrBuf.append(" AND ");
			projectPersonLinkSQLStrBuf.append(" ppl.projectPersonLinkID = ?");

			PreparedStatement preparedStatement = connection
					.prepareStatement(projectPersonLinkSQLStrBuf.toString());

			preparedStatement.setLong(1, projectPersonLinkDetail.getProjectPersonLinkID());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				projectPersonLinkDetail = new ProjectPersonLinkDetail();
				projectDetail = new ProjectDetail();
				personDetail = new PersonDetail();

				/*
				 * projectPersonLinkDetail.setPersonID(resultSet
				 * .getLong("personID"));
				 * projectPersonLinkDetail.setProjectID(resultSet
				 * .getLong("projectID"));
				 * projectPersonLinkDetail.setProjectPersonLinkID(resultSet
				 * .getLong("projectPersonLinkID"));
				 */

				projectPersonLinkDetail.setRole(resultSet.getString("role"));
				projectPersonLinkDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
				projectPersonLinkDetail.setVersionNo(resultSet.getInt("versionNo"));
				projectPersonLinkDetail.setPersonID(resultSet.getLong("personID"));

				projectDetail.setProjectID(resultSet.getLong("projectID"));
				projectDetail
						.setProjectName(resultSet.getString("projectName"));

				personDetail.setPersonID(resultSet.getLong("personID"));
				personDetail.setTitle(resultSet.getString("title"));
				personDetail.setFirstName(resultSet.getString("firstName"));
				personDetail.setMiddleName(resultSet.getString("middleName"));
				personDetail.setLastName(resultSet.getString("lastName"));
				personDetail.setGender(resultSet.getString("gender"));
				personDetail.setDateOfBirth(resultSet.getDate("dateOfBirth"));
				personDetail.setRegistrationDate(resultSet.getTimestamp("registrationDate"));
				personDetail.setVersionNo(resultSet.getInt("versionNo"));

				projectPersonLinkDetail.setProjectDetail(projectDetail);
				projectPersonLinkDetail.setPersonDetail(personDetail);
				
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}

		return projectPersonLinkDetail;
	}
}
