package com.company.timesheet.profile.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheet.pojo.TimeSheetDetail;

public class PersonProjectListDAO {
	
	public  List<ProjectDetail> listPerson(){
		
		 List<ProjectDetail> personDetailList = new ArrayList<ProjectDetail>();
		 
		 Connection connection = null;
			ResultSet resultSet;
			try {
				connection = DBConnection.getDBConnection();

				String projectSQLStr = "SELECT * FROM Project WHERE personID='personDetail.'	RECORDSTATUS='Active'";

				// statement = connection.createStatement();

				PreparedStatement preparedStatement = connection.prepareStatement(projectSQLStr);

				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					
					ProjectDetail projectDetail = new ProjectDetail();
					
					//personDetail.setTitle(resultSet.getString("title"));
					
					personDetailList.add(projectDetail);
				}
			
			}catch (SQLException e) {

				e.printStackTrace();
			}
		
		 
		 
		 return personDetailList;
	}

}
