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

    <s:form action="/PersonTimeSheetList" method="post">

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
                        <h3 class="modal-title">Add New TimeSheet</h3>
                    </div>

                    <div class="modal-body">
                    
                         <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2">Search Person</button>
                        
                        <s:form namespace="/" action="CreateTimeSheetSubmit" method="POST" class="form-inline" theme="bootstrap">

                               <br>
                               <br>
                            <div class="form-group">
                                <label>Role:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.role" />
                            </div>
                            <br/>
                            <br/>
                            
                            <div class="form-group">
                                <label>PersonID:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.personID" />
                            </div>
                            <br/>
                            <br/>

                            <div class="form-group">
                                <label>Comments:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.comments" />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>Start Date:</label> <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectPersonLinkDetail.startDate"
                                    placeholder="mm/dd/yy"  />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>End Date:</label> <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectPersonLinkDetail.endDate"
                                    placeholder="mm/dd/yy" />
                            </div>
                            <br>
                            <br>

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

        
        
        <br>
        <br>
        <table class="table table-striped">
            <thead>

                <tr>
                    <th>Project Name</th>
                    <th>Total Regular Hours</th>
                    <th>Total No Of Hours Worked</th>
                    <th>createdDateTime</th>
                    <th>Submitted DateTime</th>
                    <th>Time Sheet Status</th>
                    <th>Approval Level Type</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>

            <s:iterator value="timeSheetDetailList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="projectName" /></td>
                        <td><s:property value="totalRegularHours" /></td>
                        <td><s:property value="totalNoOfHoursWorked" /></td>
                        <td><s:property value="createdDateTime" /></td>
                        <td><s:property value="submittedDateTime" /></td>
                        <td><s:property value="timeSheetStatus" /></td>
                        <td><s:property value="approvalLevelType" /></td>
                        <td><s:property value="startDate" /></td>
                        <td><s:property value="endDate" /></td>

                    </tr>
                </tbody>

            </s:iterator>

        </table>

    </s:form>
</body>
</html>