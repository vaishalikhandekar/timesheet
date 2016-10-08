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

public class ProjectListForPersonDAO {

	public List<ProjectPersonLinkDetail> listProject(PersonDetail personDetail) {

		List<ProjectPersonLinkDetail> projectPersonLinkDetailList = new ArrayList<ProjectPersonLinkDetail>();

		Connection connection = null;
		ProjectPersonLinkDetail projectPersonLinkDetail = null;
		ProjectDetail projectDetail = null;
		ResultSet resultSet;
		try {
			connection = DBConnection.getDBConnection();

			String ProjectPersonLinkSQLStr = "select ppl.PROJECTPERSONLINKID, ppl.PROJECTID, ppl.PERSONID, ppl.ROLE, p.PROJECTNAME, p.PROJECTID, p.STARTDATE, p.ENDDATE  from PROJECTPERSONLINK ppl left outer join project p on p.projectID = ppl.projectID where ppl.PERSONID = '"+personDetail.getPersonID()+"' and ppl.RecordStatus='Active'";

			PreparedStatement preparedStatement = connection
					.prepareStatement(ProjectPersonLinkSQLStr);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				projectPersonLinkDetail = new ProjectPersonLinkDetail();
				projectDetail = new ProjectDetail();

				projectPersonLinkDetail.setPersonID(resultSet
						.getLong("personID"));
				projectPersonLinkDetail.setProjectID(resultSet
						.getLong("projectID"));
				projectPersonLinkDetail.setProjectPersonLinkID(resultSet
						.getLong("projectPersonLinkID"));
				projectPersonLinkDetail.setRole(resultSet
						.getString("role"));
				
				projectDetail.setProjectID(resultSet.getLong("projectID"));
				projectDetail.setProjectName(resultSet.getString("projectName"));
				projectDetail.setStartDate(resultSet.getDate("startDate"));
				projectDetail.setEndDate(resultSet.getDate("endDate"));

				projectPersonLinkDetail.setProjectDetail(projectDetail);

				projectPersonLinkDetailList.add(projectPersonLinkDetail);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return projectPersonLinkDetailList;
	}

}

// select * from PROJECTPERSONLINK ppl left outer join project p on p.projectID
// = ppl.projectID where ppl.PERSONID = 701;
