/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ProjectPersonListForProjectDAO {

	public List<ProjectPersonLinkDetail> projectPersonList(
			ProjectDetail projectDetail) {
		List<ProjectPersonLinkDetail> projectPersonLinkDetailList = new ArrayList<ProjectPersonLinkDetail>();

		Connection connection = null;
		PersonDetail personDetail = null;
		ProjectPersonLinkDetail projectPersonLinkDetail = null;

		try {
			connection = DBConnection.getDBConnection();

			StringBuffer projectPersonLinkSQLStrBuf = new StringBuffer();
			
			projectPersonLinkSQLStrBuf.append("SELECT ");
			projectPersonLinkSQLStrBuf.append("p.FIRSTNAME, p.LASTNAME, p.STARTDATE, p.ENDDATE ,ppl.ROLE, pr.PROJECTID, pr.PROJECTNAME ");
			projectPersonLinkSQLStrBuf.append("FROM ");
			projectPersonLinkSQLStrBuf.append("PROJECTPERSONLINK ppl left outer join project pr on pr.projectID = ppl.projectID left outer join PERSON p   on p.PERSONID = ppl.PERSONID ");
			projectPersonLinkSQLStrBuf.append("WHERE ");
			projectPersonLinkSQLStrBuf.append(" ppl.projectID = ?");

			PreparedStatement preparedStatement = connection
					.prepareStatement(projectPersonLinkSQLStrBuf.toString());

			preparedStatement.setLong(1, projectDetail.getProjectID());
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

				projectDetail.setProjectID(resultSet.getLong("projectID"));
				projectDetail
						.setProjectName(resultSet.getString("projectName"));

				personDetail.setFirstName(resultSet.getString("firstName"));
				personDetail.setLastName(resultSet.getString("lastName"));

				projectPersonLinkDetail.setProjectDetail(projectDetail);
				projectPersonLinkDetail.setPersonDetail(personDetail);
				
				projectPersonLinkDetailList.add(projectPersonLinkDetail);
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}

		return projectPersonLinkDetailList;
	}
}
