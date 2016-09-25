/**
 * 
 */
package com.company.timesheet.profile.person.action;

import com.company.timesheet.core.util.CRUDConstants;
import com.company.timesheet.profile.person.dao.PersonDeleteDAO;
import com.company.timesheet.profile.person.pojo.PersonDetail;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vaish
 *
 */
public class PersonDeleteAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private PersonDetail personDetail;

    /**
     * 
     * @return
     */
    public PersonDetail getPersonDetail() {

        return personDetail;
    }

    /**
     * 
     * @param personDetail
     */
    public void setPersonDetail(PersonDetail personDetail) {

        this.personDetail = personDetail;
    }

    /**
     * 
     */
    @Override
    public String execute() throws Exception {

        String pageForwardStr = "";

        PersonDeleteDAO deletePersonDAO = new PersonDeleteDAO();
        String returnMassegeStr = deletePersonDAO.deletePerson(personDetail);

        if (returnMassegeStr == CRUDConstants.RETURN_MESSAGE_SUCCESS) {

            pageForwardStr = SUCCESS;

        } else {

            pageForwardStr = ERROR;

        }

        return pageForwardStr;

    }

}
