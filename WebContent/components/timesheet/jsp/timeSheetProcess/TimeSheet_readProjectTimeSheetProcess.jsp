<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
tr.break td {
	height: 10px;
}
</style>
</head>
<body>

    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>

    <!-- *******************************Modal to Add New Process ******************************* -->

    <div class="pull-right" class="container">

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add New Process</button>
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

                        <s:form namespace="/TimeSheet" action="ProjectTimeSheetProcessCreateSubmit" method="POST" class="form-inline" theme="bootstrap">

                            <table style="width: 100%;">
                                <col width="20%" />
                                <col width="30%" />
                                <col width="20%" />
                                <col width="30%" />

                                <tr>

                                    <th>Frequency:</th>
                                    <td>
                                        <input type="text" name="projectTimeSheetProcessDetail.frequency" />
                                    </td>

                                    <th>StartDay:</th>
                                    <td>
                                        <input type="text" name="projectTimeSheetProcessDetail.startDay" />
                                    </td>
                                </tr>
                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>
                                <tr>

                                    <th>Minimum Approval Level Type:</th>
                                    <td>
                                        <input type="text" name="projectTimeSheetProcessDetail.minimumApprovalLevelType" />
                                    </td>

                                    <th>Regular Daily Hours:</th>
                                    <td>
                                        <input type="text" name="projectTimeSheetProcessDetail.regularDailyHours" />
                                    </td>
                                </tr>
                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>
                                <tr>
                                    <th>StartDate:</th>
                                    <td>
                                        <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectTimeSheetProcessDetail.startDate"
                                            placeholder="mm/dd/yy" />
                                    </td>

                                    <th>End Date:</th>
                                    <td>
                                        <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectTimeSheetProcessDetail.endDate"
                                            placeholder="mm/dd/yy" />
                                    </td>
                                </tr>
                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>
                                <tr>
                                    <th>Comments:</th>
                                    <td>
                                        <input type="text" name="projectTimeSheetProcessDetail.comments" />
                                    </td>
                                </tr>
                            </table>
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


    <s:form action="TimeSheetProcessRead" namespace="/TimeSheet" method="post">

        <br>
        <br>
        <table class="table table-striped">
            <thead>

                <tr class="success">
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Frequency</th>
                    <th style="text-align: center">StartDay</th>
                    <th style="text-align: center">Minimum Approval Level Type</th>
                    <th style="text-align: center">Regular Daily Hours</th>
                    <th style="text-align: center">startDate</th>
                    <th style="text-align: center">end Date</th>
                    <th style="text-align: center">Status</th>
                </tr>
            </thead>

            <tbody>
            
                <tr>
                    <td align="center">
                        <s:url id="ViewprojectTimeSheetProcessURL" action="TimeSheetApprovalLevelRead" namespace="/TimeSheet" escapeAmp="false">
                            <s:param name="projectTimeSheetProcessDetail.projectTimeSheetProcessID" value="%{projectTimeSheetProcessDetail.projectTimeSheetProcessID}" />
                        </s:url>
                        <s:a href="%{ViewprojectTimeSheetProcessURL}">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            <!-- View -->
                        </s:a>
                        &nbsp;&nbsp;

                        <s:url var="updateprojectTimeSheetProcessURL" action="TimeSheetApprovalLevelRead" namespace="/TimeSheet" escapeAmp="false">
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
                        <s:property value="projectTimeSheetProcessDetail.frequency" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.startDay" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.minimumApprovalLevelType" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.regularDailyHours" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.startDate" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.endDate" />
                    </td>
                    <td align="center">
                        <s:property value="projectTimeSheetProcessDetail.recordStatus" />
                    </td>

                </tr>
            </tbody>

        </table>

    <br />
    <br />
    <table class="table table-striped">
    
        <thead>

            <tr class="success">
                <th style="text-align: center">Action</th>
                <th style="text-align: center">Approver Name</th>
                <th style="text-align: center">ApprovalLevelType</th>
                <th style="text-align: center">ApprovalCriteria</th>
                <th style="text-align: center">Start Date</th>
                <th style="text-align: center">End Date</th>
                <th style="text-align: center">Status</th>
            </tr>
            
        </thead>

        <s:iterator value="projectTimeSheetProcessDetail.timeSheetAprovalLevelDetailList" status="stat">

            <tbody>
                <tr>

                    <td align="center">
                    
                        <s:url id="ViewprojectTimeSheetProcessURL" action="TimeSheetApprovalLevelRead" namespace="/TimeSheet" escapeAmp="false">
                            <s:param name="projectTimeSheetProcessDetail.projectTimeSheetProcessID" value="%{projectTimeSheetProcessID}" />
                        </s:url>
                        <s:a href="%{ViewprojectTimeSheetProcessURL}">
                            <span class="glyphicon glyphicon-eye-open"></span>
                            <!-- View -->
                        </s:a>
                        &nbsp;&nbsp;

                        <s:url var="updateprojectTimeSheetProcessURL" action="TimeSheetApprovalLevelRead" namespace="/TimeSheet" escapeAmp="false">
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
                        <s:property value="firstName" /> &nbsp;
                        <s:property value="lastName" /> 
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

    </s:form>
    
</body>
</html>