
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
tr.break td {
	height: 10px;
}
</style>
<title></title>
<body>

    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>

    <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeletePersonFromProject" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="DeletePersonFromProject" namespace="/Project" action="DeletePersonFromProject" method="POST"
                            role="form" theme="bootstrap">

                            <p>Are You Sure ?</p>

                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Delete" class="btn btn-primary" />
                                <s:hidden name="projectDetail.projectID"></s:hidden>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>



    <!-- *******************************Modal to Add Person in the Project ******************************* -->

    <div class="pull-right" class="container">

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add Person</button>
        <br />
        <br />


        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Add Person to Project</h3>
                    </div>

                    <div class="modal-body">

                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Search Person</button>

                        <s:form namespace="/Project" action="CreateProjectPersonLinkSubmit" method="POST" class="form-inline" theme="bootstrap">
<br/>
                            <table style="width: 100%;">
                                <col width="20%" />
                                <col width="30%" />
                                <col width="20%" />
                                <col width="30%" />

                                <tr>
                                    <th>Role:</th>
                                    <td>
                                        <input type="text"  name="projectPersonLinkDetail.role" />
                                    </td>

                                    <th>PersonID:</th>
                                    <td>
                                        <input type="text"  name="projectPersonLinkDetail.personID" />
                                    </td>
                                <tr>
                                    <th>Comments:</th>
                                    <td>
                                        <input type="text"  name="projectPersonLinkDetail.comments" />
                                    </td>

                                    <th>Start Date:</th>
                                    <td>
                                        <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectPersonLinkDetail.startDate"
                                            placeholder="mm/dd/yy" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>End Date:</th>
                                    <td>
                                        <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectPersonLinkDetail.endDate"
                                            placeholder="mm/dd/yy" />
                                    </td>
                                </tr>
                            </table>
                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                            <s:hidden name="projectPersonLinkDetail.projectID" value="%{projectDetail.projectID}"></s:hidden>


                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- *******************************code for Person Search******************************* -->


    <div class="pull-right" class="container">

        <div class="modal fade" id="modal-2" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Person Search</h3>
                    </div>

                    <div class="modal-body">

                        <s:form action="/SearchPersonSubmit" namespace="/Project" method="POST" class="form-inline" theme="bootstrap">

                            <div class="form-group">
                                <label>First Name</label>
                                <s:textfield type="text" name="personSearchDetails.personSearchCriteria.firstName" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label>Middle Name</label>
                                <s:textfield type="text" name="personSearchDetails.personSearchCriteria.middleName" class="form-control" />
                            </div>
                            <div class="form-group">
                                <label>Last Name</label>
                                <s:textfield type="text" name="personSearchDetails.personSearchCriteria.lastName" class="form-control" />
                            </div>

                            <br />
                            <br />
                            <br>

                            <table class="table table-striped">
                                <thead>

                                    <tr class="success">
                                        <th style="text-align: center">Title</th>
                                        <th style="text-align: center">First Name</th>
                                        <th style="text-align: center">Middle Name</th>
                                        <th style="text-align: center">Last Name</th>
                                        <th style="text-align: center">Gender</th>
                                        <th style="text-align: center">Date Of Birth</th>
                                    </tr>
                                </thead>

                                <s:iterator value="personSearchResult.personDetailList" status="stat">

                                    <tr>
                                        <td align="center">
                                            <s:property value="title" />
                                        </td>
                                        <td align="center">
                                            <s:property value="firstName" />
                                        </td>
                                        <td align="center">
                                            <s:property value="middleName" />
                                        </td>
                                        <td align="center">
                                            <s:property value="lastName" />
                                        </td>
                                        <td align="center">
                                            <s:property value="gender" />
                                        </td>
                                        <td align="center">
                                            <s:property value="dateOfBirth" />
                                        </td>
                                    </tr>
                                </s:iterator>

                                <s:hidden name="personDetail.personID"></s:hidden>
                            </table>
                            <br />
                            <br />
                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Search" class="btn btn-primary" />
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>


                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <!-- *******************************code to display Person List******************************* -->

    <s:form name="ListForm" id="ListForm" method="post">

        <div class="container">

            <table class="table table-striped" style="width: 100%; height: 100%; border: 1;">
                <thead>

                    <tr class="success">
                        <th style="text-align: center">Action</th>
                        <th style="text-align: center">Role</th>
                        <th style="text-align: center">Title</th>
                        <th style="text-align: center">First Name</th>
                        <th style="text-align: center">Middle Name</th>
                        <th style="text-align: center">Last Name</th>
                        <th style="text-align: center">Gender</th>
                        <th style="text-align: center">Date Of Birth</th>
                        <th style="text-align: center">Registration Date</th>
                    </tr>

                </thead>

                <s:iterator value="projectPersonLinkDetailList" status="stat">

                    <tr>
                        <td align="center">

                            <s:url var="updatePersonURL" action="ReadPersonFromProject" escapeAmp="false">
                                <s:param name="projectPersonLinkDetail.projectPersonLinkID" value="%{projectPersonLinkID}" />
                                <s:param name="act" value="%{updateAction}" />
                            </s:url>
                            <s:a href="%{updatePersonURL}">
                                <span class="glyphicon glyphicon-pencil"></span>
                                <!-- Update -->
                            </s:a>
                            &nbsp;&nbsp;

                            <a href="#DeletePersonFromProject" data-toggle="modal">
                                <span class="glyphicon glyphicon-trash"></span>
                                <!-- Delete -->
                            </a>

                        </td>
                        <td align="center">
                            <s:property value="role" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.title" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.firstName" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.middleName" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.lastName" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.gender" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.dateOfBirth" />
                        </td>
                        <td align="center">
                            <s:property value="personDetail.registrationDate" />
                        </td>

                    </tr>
                </s:iterator>

            </table>

        </div>

    </s:form>
</body>
</html>