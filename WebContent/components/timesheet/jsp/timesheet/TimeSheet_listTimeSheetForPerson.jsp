<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>
</head>
<body>
    <jsp:include page="/components/profile/jsp/person/Person_navPerson.jsp"></jsp:include>


    <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeleteTimeSheet" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete TimeSheet</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="DeleteTimeSheetFromPerson" namespace="/" action="DeleteTimeSheetFromPerson" method="POST" role="form"
                            theme="bootstrap">

                            <p>Are You Sure ?</p>


                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Delete" class="btn btn-primary" />
                                <s:hidden name="personDetail.personID" value="%{personDetail.personID}"></s:hidden>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>


    <!-- *******************************Modal to New TimeSheet in the Project ******************************* -->

    <div class="pull-right" class="container">

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add New TimeSheet</button>
        <br />
        <br />


        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">New TimeSheet</h3>
                    </div>

                    <div class="modal-body">

                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Search</button>

                        <s:form namespace="/" action="TimeSheetCreate" method="POST" class="form-inline" theme="bootstrap">

                            <br />
                            <div class="form-group">
                                <label>Project:</label>
                                <input type="text" name="timeSheetCreateDetails.projectID" class="form-control" />
                            </div>
                            <br />
                            <br />

                            <div class="form-group">
                                <label>Start Date:</label>
                                <input type="text" class="datepick" id="date_1" class="dateTxt" name="timeSheetCreateDetails.startDate" placeholder="mm/dd/yy" />
                            </div>
                            <br />
                            <br />

                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Next" class="btn btn-primary" />
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                            <s:hidden name="timeSheetCreateDetails.personID" value="%{personDetail.personID}"></s:hidden>


                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <s:form action="/PersonTimeSheetList" method="post">

        <br>
        <br>
        <table class="table table-striped">
            <thead>

                <tr class="success">
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Project Name</th>
                    <th style="text-align: center">Start Date</th>
                    <th style="text-align: center">End Date</th>
                    <th style="text-align: center">Time Sheet Status</th>
                    <th style="text-align: center">Total Regular Hours</th>
                    <th style="text-align: center">Total No Of Hours Worked</th>
                    <th style="text-align: center">Created Date Time</th>
                    <th style="text-align: center">Submitted Date Time</th>
                    <th style="text-align: center">Approval Level</th>
                </tr>
            </thead>

            <s:iterator value="timeSheetDetailList" status="stat">

                <tbody>

                    <tr>
                        <td align="center">

                            <s:url id="ViewTimeSheetLineItemFromPersonURL" action="ViewTimeSheetLineItemFromPerson" escapeAmp="false">
                                <s:param name="timeSheetDetail.timeSheetID" value="%{timeSheetID}" />
                            </s:url>
                            <s:a href="%{ViewTimeSheetLineItemFromPersonURL}">
                                <span class="glyphicon glyphicon-eye-open"></span>
                                <!-- View -->
                            </s:a>

                            &nbsp;&nbsp;&nbsp;

                            <s:url var="updateTimeSheetURL" action="TimeSheetRead" escapeAmp="false">
                                <s:param name="timeSheetKey.timeSheetID" value="%{timeSheetID}" />
                                <s:param name="act" value="%{updateAction}" />
                            </s:url>
                            <s:a href="%{updateTimeSheetURL}">
                                <span class="glyphicon glyphicon-pencil"></span>
                                <!-- Update -->
                            </s:a>

                            &nbsp;&nbsp;&nbsp;

                            <a href="#DeleteTimeSheet" data-toggle="modal">
                                <span class="glyphicon glyphicon-trash"></span>
                                <!-- Delete -->
                            </a>

                        </td>

                        <td align="center">
                            <s:property value="projectName" />
                        </td>

                        <td align="center">
                            <s:property value="startDate" />
                        </td>

                        <td align="center">
                            <s:property value="endDate" />
                        </td>

                        <td align="center">
                            <s:property value="timeSheetStatus" />
                        </td>

                        <td align="center">
                            <s:property value="totalRegularHours" />
                        </td>

                        <td align="center">
                            <s:property value="totalNoOfHoursWorked" />
                        </td>

                        <td align="center">
                            <s:property value="createdDateTime" />
                        </td>

                        <td align="center">
                            <s:property value="submittedDateTime" />
                        </td>

                        <td align="center">
                            <s:property value="approvalLevelType" />
                        </td>

                    </tr>

                </tbody>

            </s:iterator>

        </table>

    </s:form>

</body>
</html>