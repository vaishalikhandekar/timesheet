/**
 * 
 */
package com.company.timesheet.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.company.timesheet.core.audittrail.dao.CreateAuditTrailDAO;
import com.company.timesheet.core.audittrail.pojo.AuditTrailDetails;
import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.core.util.JavaUtildates;
import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.core.util.type.UniqueID;
import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.project.pojo.ProjectSearchCriteria;
import com.company.timesheet.project.pojo.ProjectSearchDetails;

/**
 * @author vaish
 *
 */
public class ProjectCreateDAO {

    /**
     * 
     * @param projectDetail
     * @return
     */
    public String createProject(ProjectDetail projectDetail) {

        String returnMassegeStr = "";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        boolean projectExistInd = projectExist(projectDetail);

        if (!projectExistInd) {

            try {
                connection = DBConnection.getDBConnection();

                String projectSQLStr = "INSERT INTO PROJECT(projectID, projectName, acronym, description, comments, startDate, endDate, recordStatus, versionNo) "
                        + "VALUES (?, '"
                        + projectDetail.getProjectName()
                        + "','"
                        + projectDetail.getAcronym()
                        + "', '"
                        + projectDetail.getDescription()
                        + "','" + projectDetail.getComments() + "',?,?, 'Active'," + " 1 )";

                preparedStatement = connection.prepareStatement(projectSQLStr);

                long projectID = UniqueID.nextUniqueID();
                preparedStatement.setLong(1, projectID);

                preparedStatement.setDate(2, JavaUtildates.convertUtilToSql(projectDetail.getStartDate()));
                preparedStatement.setDate(3, JavaUtildates.convertUtilToSql(projectDetail.getEndDate()));

                preparedStatement.execute();

                // Set newly created projectID
                projectDetail.setProjectID(projectID);

                // inserting data into AuditTrail Table for Project Table
                AuditTrailDetails auditTrailDetails = new AuditTrailDetails();

                auditTrailDetails.setTableName("Project");
                auditTrailDetails.setOperationType("Create");
                auditTrailDetails.setRelatedID(projectDetail.getProjectID());
                auditTrailDetails.setTransactionType("Online");

                CreateAuditTrailDAO createAuditTrailDAO = new CreateAuditTrailDAO();
                createAuditTrailDAO.createAuditTrail(auditTrailDetails);

                returnMassegeStr = CRUDConstants.RETURN_MESSAGE_SUCCESS;

            } catch (SQLException e) {

                e.printStackTrace();
                returnMassegeStr = CRUDConstants.RETURN_MESSAGE_FAILURE;
            }
        }

        return returnMassegeStr;
    }

    /**
     * 
     * @param projectDetail
     */
    public boolean projectExist(ProjectDetail projectDetail) {

        boolean projectExistInd = false;

        try {

            ProjectSearchCriteria projectSearchCriteria = new ProjectSearchCriteria();

            projectSearchCriteria.setProjectName(projectDetail.getProjectName() == null ? "" : projectDetail.getProjectName());

            /*
             projectSearchCriteria.setStartDate(projectDetail.getStartDate() == null ? "" : projectDetail.getStartDate());
             projectSearchCriteria.setEndDate(projectDetail.getEndDate() == null ? "" : projectDetail.getEndDate());
             */
            ProjectSearchDetails projectSearchDetails = new ProjectSearchDetails();
            projectSearchDetails.setProjectSearchCriteria(projectSearchCriteria);

            //
            ProjectSearchDAO searchProjectDAO = new ProjectSearchDAO();

            //
            List<ProjectDetail> projectDetailList = searchProjectDAO.searchProjectInfo(projectSearchDetails);

            if (projectDetailList.size() > 0) {

                projectDetail.getErrorMessageList().add("Project already exist");

                projectExistInd = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return projectExistInd;

    }

}
