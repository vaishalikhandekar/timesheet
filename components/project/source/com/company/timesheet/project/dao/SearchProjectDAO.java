/**
 * 
 */
package com.company.timesheet.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.employee.pojo.EmployeeDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.pojo.ProjectSearchCriteria;
import com.company.timesheet.project.pojo.ProjectSearchDetails;

/**
 * @author vaish
 *
 */
public class SearchProjectDAO {
	
	Connection connection = null;

	public List<ProjectDetail> searchProjectInfo(ProjectSearchDetails projectSearchDetails) {

		List<ProjectDetail> projectDetailList = new ArrayList<ProjectDetail>();
		ProjectSearchCriteria projectSearchCriteria = projectSearchDetails.getProjectSearchCriteria();
		EmployeeDetail employeeDetail = null;

		String whereStr = "";

		String emptyStr = "";

		if (projectSearchCriteria.getProjectName() != null && !projectSearchCriteria.getProjectName().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " projectName = '" + projectSearchCriteria.getProjectName() + "'";
		}
		if (projectSearchCriteria.getStartDate() != null && !projectSearchCriteria.getStartDate().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " startDate = '" + projectSearchCriteria.getStartDate() + "'";
		}
		if (projectSearchCriteria.getEndDate() != null && !projectSearchCriteria.getEndDate().equals(emptyStr)) {
			whereStr += (whereStr == "") ? " WHERE " : " AND ";
			whereStr += " endDate = '" + projectSearchCriteria.getEndDate() + "'";
		}

		if (!whereStr.equals(emptyStr)) {

			try {
				connection = DBConnection.getDBConnection();
				String projectSQLStr = "SELECT * " + " FROM PROJECT " + whereStr;

				PreparedStatement preparedstatement = connection.prepareStatement(projectSQLStr);

				ResultSet resultSet = preparedstatement.executeQuery();

				while (resultSet.next()) {

					ProjectDetail projectDetail = new ProjectDetail();
					projectDetail.setProjectID(resultSet.getLong("projectID"));
					projectDetail.setProjectName(resultSet.getString("projectName"));
					projectDetail.setDescription(resultSet.getString("description"));
					projectDetail.setComments(resultSet.getString("comments"));
					projectDetail.setStartDate(resultSet.getDate("startDate"));
					projectDetail.setEndDate(resultSet.getDate("endDate"));
					projectDetailList.add(projectDetail);
				}

			} catch (Exception exception) {
				exception.printStackTrace();
			}

		} else {
			String errorMessage = "";

			errorMessage = "Please enter at least one attribute";
			projectSearchDetails.setErrorMessage(errorMessage);
			;

		}

		return projectDetailList;

	}


}
