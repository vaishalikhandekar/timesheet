<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>
</head>
<body>
    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>

    <!-- *******************************Modal to Add New Process ******************************* -->

    <%--  <div class="pull-right" class="container">

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add New Level</button>
        <br />
        <br />


        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Add New Process</h3>
                    </div>

                    <div class="modal-body">
                    
                        <s:form namespace="/" action="CreateNewProcessSubmit" method="POST" class="form-inline" theme="bootstrap">

                               <br>
                               <br>
                            <div class="form-group">
                                <label>Frequency:</label> <s:textfield type="text" class="form-control" name="projectTimeSheetProcessDetail.frequency" />
                            </div>
                            <br/>
                            <br/>
                            
                            <div class="form-group">
                                <label>StartDay:</label> <s:textfield type="text" class="form-control" name="projectTimeSheetProcessDetail.startDay" />
                            </div>
                            <br/>
                            <br/>

                            <div class="form-group">
                                <label>Minimum Approval Level Type:</label> <s:textfield type="text" class="form-control" name="projectTimeSheetProcessDetail.minimumApprovalLevelType" />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>Regular Daily Hours:</label> <input type="text" class="form-control"   name="projectTimeSheetProcessDetail.regularDailyHours"
                                     />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>StartDate:</label> <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectTimeSheetProcessDetail.startDate"
                                    placeholder="mm/dd/yy"  />
                            </div>
                            <br>
                            <br>
                            
                            <div class="form-group">
                                <label>End Date:</label> <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectTimeSheetProcessDetail.endDate"
                                    placeholder="mm/dd/yy" />
                            </div>
                            <br>
                            <br>
                            
                            <div class="form-group">
                                <label>Comments:</label> <input type="text" class="form-control"  name="projectTimeSheetProcessDetail.comments"
                                     />
                            </div>
                            <br>
                            <br>

                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                            <s:hidden name="projectTimeSheetProcessDetail.projectID" value="%{projectDetail.projectID}"></s:hidden>


                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
 --%>
    <%-- <s:form action="/ViewTimeSheetApprovalLevelList" method="post"> --%>

    <br>
    <br>
    <table class="table table-striped">
        <thead>

            <tr class="success">
                <th style="text-align: center">Action</th>
                <th style="text-align: center">ApprovalLevelType</th>
                <th style="text-align: center">ApprovalCriteria</th>
                <th style="text-align: center">startDate</th>
                <th style="text-align: center">end Date</th>
                <th style="text-align: center">Status</th>
            </tr>
        </thead>

        <s:iterator value="timeSheetAprovalLevelDetailList" status="stat">

            <tbody>
                <tr>

                    <td align="center">
                        <s:url id="ViewprojectTimeSheetProcessURL" action="ViewTimeSheetApprovalLevelList" namespace="/TimeSheet" escapeAmp="false">
                            <s:param name="projectTimeSheetProcessDetail.projectTimeSheetProcessID" value="%{projectTimeSheetProcessID}" />
                        </s:url>
                        <s:a href="%{ViewprojectTimeSheetProcessURL}">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            <!-- View -->
                        </s:a>
                        &nbsp;&nbsp;

                        <s:url var="updateprojectTimeSheetProcessURL" action="" namespace="/TimeSheet" escapeAmp="false">
                            <s:param name="projectDetail.projectID" value="%{projectID}" />
                            <s:param name="act" value="%{updateAction}" />
                        </s:url>

                        <s:a href="%{updateprojectTimeSheetProcessURL}">
                            <span class="glyphicon glyphicon-pencil"></span>
                            <!-- Update -->
                        </s:a>
                        &nbsp;&nbsp;

                        <s:url var="deleteprojectTimeSheetProcessURL" action="" namespace="/TimeSheet" escapeAmp="false">
                            <s:param name="projectDetail.projectID" value="%{projectID}" />
                        </s:url>

                        <s:a href="%{deleteprojectTimeSheetProcessURL}">
                            <span class="glyphicon glyphicon-trash"></span>
                            <!-- Update -->
                        </s:a>
                    </td>

                    <td align="center">
                        <s:property value="approvalLevelType" />
                    </td>
                    <td align="center">
                        <s:property value="approvalCriteria" />
                    </td>

                    <td align="center">
                        <s:property value="startDate" />
                    </td>
                    <td align="center">
                        <s:property value="endDate" />
                    </td>
                    <td align="center">
                        <s:property value="recordStatus" />
                    </td>

                </tr>
            </tbody>

        </s:iterator>

    </table>

    <%--   </s:form> --%>
</body>
</html>