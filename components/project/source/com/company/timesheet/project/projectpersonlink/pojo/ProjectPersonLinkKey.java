/**
 * 
 */
package com.company.timesheet.project.projectpersonlink.pojo;


/**
 * @author vaish
 *
 */
public class ProjectPersonLinkKey {

    private Long projectPersonLinkID;

    private Long projectID;

    private Long personID;

    
    public Long getProjectPersonLinkID() {
    
        return projectPersonLinkID;
    }

    
    public void setProjectPersonLinkID(Long projectPersonLinkID) {
    
        this.projectPersonLinkID = projectPersonLinkID;
    }

    
    public Long getProjectID() {
    
        return projectID;
    }

    
    public void setProjectID(Long projectID) {
    
        this.projectID = projectID;
    }

    
    public Long getPersonID() {
    
        return personID;
    }

    
    public void setPersonID(Long personID) {
    
        this.personID = personID;
    }


}
