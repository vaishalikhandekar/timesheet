/**
 * 
 */
package com.company.timesheet.timesheetprocess.action;

import com.company.timesheet.project.pojo.ProjectDetail;
import com.company.timesheet.timesheetprocess.dao.ProjectTimeSheetProcessReadDAO;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessDetail;
import com.company.timesheet.timesheetprocess.pojo.ProjectTimeSheetProcessKey;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class ProjectTimeSheetProcessReadAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail = null;

    private ProjectDetail projectDetail = null;

    private ProjectTimeSheetProcessKey projectTimeSheetProcessKey = null;

    /**
     * 
     * @return
     */
    public ProjectDetail getProjectDetail() {

        return projectDetail;
    }

    /**
     * 
     * @param projectDetail
     */
    public void setProjectDetail(ProjectDetail projectDetail) {

        this.projectDetail = projectDetail;
    }

    /**
     * @return the projectTimeSheetProcessDetail
     */
    public ProjectTimeSheetProcessDetail getProjectTimeSheetProcessDetail() {

        return projectTimeSheetProcessDetail;
    }

    /**
     * @param projectTimeSheetProcessDetail
     *            the projectTimeSheetProcessDetail to set
     */
    public void setProjectTimeSheetProcessDetail(ProjectTimeSheetProcessDetail projectTimeSheetProcessDetail) {

        this.projectTimeSheetProcessDetail = projectTimeSheetProcessDetail;
    }

    /**
     * @return the projectTimeSheetProcessKey
     */
    public ProjectTimeSheetProcessKey getProjectTimeSheetProcessKey() {

        return projectTimeSheetProcessKey;
    }

    /**
     * @param projectTimeSheetProcessKey
     *            the projectTimeSheetProcessKey to set
     */
    public void setProjectTimeSheetProcessKey(ProjectTimeSheetProcessKey projectTimeSheetProcessKey) {

        this.projectTimeSheetProcessKey = projectTimeSheetProcessKey;
    }

    /**
	 * 
	 */
    @Override
    public String execute() throws Exception {

        String pageForwardStr = "";

        ProjectTimeSheetProcessReadDAO projectTimeSheetProcessReadDAO = new ProjectTimeSheetProcessReadDAO();

        ProjectTimeSheetProcessDetail projectTimeSheetProcessDetails = projectTimeSheetProcessReadDAO
                .readProjectTimeSheetProcessDetails(projectTimeSheetProcessKey);

        setProjectTimeSheetProcessDetail(projectTimeSheetProcessDetails);

        if (projectTimeSheetProcessDetails != null) {

            pageForwardStr = SUCCESS;

        } else {

            pageForwardStr = ERROR;

        }

        return pageForwardStr;
    }

}
