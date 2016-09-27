/**
 * 
 */
package com.company.timesheet.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.project.pojo.ProjectDetail;

/**
 * @author vaish
 *
 */
public class ProjectListDAO {

    /**
     * 
     * @return
     */
    public List<ProjectDetail> listProject() {

        List<ProjectDetail> projectDetailList = new ArrayList<ProjectDetail>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        ProjectDetail projectDetail = null;

        try {
            connection = DBConnection.getDBConnection();

            String projectSQLStr = "SELECT * FROM Project"; // WHERE
                                                            // RECORDSTATUS='Active'";

            // statement = connection.createStatement();

            preparedStatement = connection.prepareStatement(projectSQLStr);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                projectDetail = new ProjectDetail();

                projectDetail.setProjectID(resultSet.getLong("projectID"));
                projectDetail.setProjectName(resultSet.getString("projectName"));
                projectDetail.setAcronym(resultSet.getString("acronym"));
                projectDetail.setDescription(resultSet.getString("description"));
                projectDetail.setRecordStatus(resultSet.getString("recordStatus"));
                projectDetail.setStartDate(resultSet.getDate("startDate"));
                projectDetail.setEndDate(resultSet.getDate("endDate"));

                projectDetailList.add(projectDetail);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return projectDetailList;
    }

}
