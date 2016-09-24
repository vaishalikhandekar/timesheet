/**
 * 
 */
package com.company.timesheet.timesheetapproval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.core.util.dataaccess.DBConnection;
import com.company.timesheet.timesheetapproval.pojo.TimeSheetAprovalLevelDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessKey;

/**
 * @author vaish
 *
 */
public class TimeSheetAprovalLevelListDAO {

    /**
     * 
     * @param projectTimeSheetProcessDetail
     * @return
     */
    public List<TimeSheetAprovalLevelDetail> getTimeSheetAprovalLevelDetailList(ProjectTimeSheetProcessKey projectTimeSheetProcessKey) {

        List<TimeSheetAprovalLevelDetail> timeSheetAprovalLevelDetailList = new ArrayList<TimeSheetAprovalLevelDetail>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        TimeSheetAprovalLevelDetail timeSheetAprovalLevelDetail = null;

        try {
            connection = DBConnection.getDBConnection();

            StringBuffer timeSheetAprovalLevelDetailSQLStrBuf = new StringBuffer();

            timeSheetAprovalLevelDetailSQLStrBuf.append(" SELECT ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" timeSheetApprovalLevel.*, ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" person.firstName, ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" person.lastName ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" FROM ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" TimeSheetApprovalLevel timeSheetApprovalLevel ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" LEFT OUTER JOIN ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" ProjectPersonLink projectPersonLink ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" ON projectPersonLink.projectPersonLinkID = timeSheetApprovalLevel.projectPersonLinkID ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" LEFT OUTER JOIN ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" Person person ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" ON person.personID = projectPersonLink.personID ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" WHERE ");
            timeSheetAprovalLevelDetailSQLStrBuf.append(" projectTimeSheetProcessID = ? ");
            //timeSheetAprovalLevelDetailSQLStrBuf.append(" AND recordStatus = ? ");

            preparedStatement = connection.prepareStatement(timeSheetAprovalLevelDetailSQLStrBuf.toString());

            preparedStatement.setLong(1, projectTimeSheetProcessKey.getProjectTimeSheetProcessID());
            //preparedStatement.setString(2, "Active");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                timeSheetAprovalLevelDetail = new TimeSheetAprovalLevelDetail();

                timeSheetAprovalLevelDetail.setProjectTimeSheetProcessID(resultSet.getLong("projectTimeSheetProcessID"));
                timeSheetAprovalLevelDetail.setTimeSheetApprovalLevelID(resultSet.getLong("timeSheetApprovalLevelID"));
                timeSheetAprovalLevelDetail.setProjectPersonLinkID(resultSet.getLong("projectPersonLinkID"));
                timeSheetAprovalLevelDetail.setApprovalLevelType(resultSet.getString("approvalLevelType"));
                timeSheetAprovalLevelDetail.setApprovalCriteria(resultSet.getString("approvalCriteria"));
                timeSheetAprovalLevelDetail.setStartDate(resultSet.getDate("startDate"));
                timeSheetAprovalLevelDetail.setEndDate(resultSet.getDate("endDate"));
                timeSheetAprovalLevelDetail.setComments(resultSet.getString("comments"));
                timeSheetAprovalLevelDetail.setRecordStatus(resultSet.getString("recordStatus"));
                timeSheetAprovalLevelDetail.setVersionNo(resultSet.getInt("versionNo"));

                
                timeSheetAprovalLevelDetail.setFirstName(resultSet.getString("firstName"));
                timeSheetAprovalLevelDetail.setLastName(resultSet.getString("lastName"));

                /*String projectPersonLinkDetailSQLStr = "SELECT projectID FROM ProjectPersonLink WHERE projectPersonLinkID = '"
                        + timeSheetAprovalLevelDetail.getProjectPersonLinkID() + "' and   RECORDSTATUS='Active'";

                preparedStatement1 = connection.prepareStatement(projectPersonLinkDetailSQLStr);

                resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    ProjectPersonLinkDetail projectPersonLinkDetail = new ProjectPersonLinkDetail();
                    projectPersonLinkDetail.setProjectID(resultSet1.getLong("projectID"));

                    timeSheetAprovalLevelDetail.setProjectPersonLinkDetail(projectPersonLinkDetail);
                }*/

                timeSheetAprovalLevelDetailList.add(timeSheetAprovalLevelDetail);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return timeSheetAprovalLevelDetailList;

    }
}
