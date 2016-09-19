package com.company.timesheet.timesheet.pojo;


public class TimeSheetKey {

    private Long timeSheetID;

    private Long projectTimeSheetProcessID;

    private Long projectPersonLinkID;

    
    /**
     * @return the timeSheetID
     */
    public Long getTimeSheetID() {
    
        return timeSheetID;
    }

    
    /**
     * @param timeSheetID the timeSheetID to set
     */
    public void setTimeSheetID(Long timeSheetID) {
    
        this.timeSheetID = timeSheetID;
    }

    
    /**
     * @return the projectTimeSheetProcessID
     */
    public Long getProjectTimeSheetProcessID() {
    
        return projectTimeSheetProcessID;
    }

    
    /**
     * @param projectTimeSheetProcessID the projectTimeSheetProcessID to set
     */
    public void setProjectTimeSheetProcessID(Long projectTimeSheetProcessID) {
    
        this.projectTimeSheetProcessID = projectTimeSheetProcessID;
    }

    
    /**
     * @return the projectPersonLinkID
     */
    public Long getProjectPersonLinkID() {
    
        return projectPersonLinkID;
    }

    
    /**
     * @param projectPersonLinkID the projectPersonLinkID to set
     */
    public void setProjectPersonLinkID(Long projectPersonLinkID) {
    
        this.projectPersonLinkID = projectPersonLinkID;
    }

}