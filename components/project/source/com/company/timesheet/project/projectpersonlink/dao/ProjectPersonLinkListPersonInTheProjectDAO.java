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
import com.company.timesheet.project.projectpersonlink.pojo.ProjectPersonLinkDetail;

/**
 * @author vaish
 *
 */
public class ProjectPersonLinkListPersonInTheProjectDAO {
	
	public List<ProjectPersonLinkDetail> listOfPersonInTheProject(){
		
		List<ProjectPersonLinkDetail> projectPersonLinkDetailList = new ArrayList<ProjectPersonLinkDetail>();
		
		Connection connection = null;
		ResultSet resultSet;
		try {
			ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
			
			connection = DBConnection.getDBConnection();

			String projectSQLStr = "SELECT * FROM ProjectPersonLink WHERE	RECORDSTATUS='Active' and projectID = '"+projectPersonLinkDetail.getProjectID()+"'";

			// statement = connection.createStatement();

			PreparedStatement preparedStatement = connection.prepareStatement(projectSQLStr);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				
				
				projectPersonLinkDetail.setProjectID(resultSet.getLong("projectID"));
				//projectPersonLinkDetail.setProjectPersonLinkID(resultSet.getLong("projectEmployeeLinkID"));
				//projectPersonLinkDetail.setEmployeeID(resultSet.getLong("employeeID"));
				projectPersonLinkDetail.setRole(resultSet.getString("role"));
				projectPersonLinkDetail.setComments(resultSet.getString("comments"));
				projectPersonLinkDetail.setStartDate(resultSet.getDate("startDate"));
				projectPersonLinkDetail.setEndDate(resultSet.getDate("endDate"));
				
				projectPersonLinkDetailList.add(projectPersonLinkDetail);
			}
		
		}catch (SQLException e) {

			e.printStackTrace();
		}
	

		
		return projectPersonLinkDetailList;
	}

	}


