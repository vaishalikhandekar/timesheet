<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>
<style type="text/css">
tr.break td {
	height: 10px;
}
</style>
</head>
<body>

    <!-- HEADER SECTION -->
    <div id="top">

        <%@ include file="/components/core/jsp/header.jsp"%>
    </div>
    <!-- END HEADER SECTION -->



    <!-- MENU SECTION -->
    <div id="left">
        <%@ include file="/components/core/jsp/menu.jsp"%>

    </div>
    <!--END MENU SECTION -->


    <!--PAGE CONTENT -->
    <div id="content">

        <div class="inner">
            <div class="row">
                <div class="col-lg-12"></div>
            </div>

            <div class="row">
                <div class="col-lg-12">

                    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>
                    <br />
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

                                        <s:form namespace="/TimeSheet" action="ProjectTimeSheetProcessCreateSubmit" method="POST" class="form-inline"
                                            theme="bootstrap">

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
                                                        <input type="text" class="datepick" id="date_1" class="dateTxt"
                                                            name="projectTimeSheetProcessDetail.startDate" placeholder="mm/dd/yy" />
                                                    </td>

                                                    <th>End Date:</th>
                                                    <td>
                                                        <input type="text" class="datepick" id="date_2" class="dateTxt"
                                                            name="projectTimeSheetProcessDetail.endDate" placeholder="mm/dd/yy" />
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


                    <s:form action="TimeSheetsProcessList" namespace="/TimeSheet" method="post">

                        <!--   <a href="CreateTimeSheet">New TimeSheet</a> -->
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

                            <s:iterator value="projectTimeSheetProcessDetailList" status="stat">

                                <tbody>
                                    <tr>

                                        <td align="center">
                                            <s:url id="ViewprojectTimeSheetProcessURL" action="ProjectTimeSheetProcessRead" namespace="/TimeSheet"
                                                escapeAmp="false">
                                                <s:param name="projectTimeSheetProcessKey.projectTimeSheetProcessID" value="%{projectTimeSheetProcessID}" />
                                            </s:url>
                                            <s:a href="%{ViewprojectTimeSheetProcessURL}">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                                <!-- View -->
                                            </s:a>

                                            &nbsp;&nbsp;

                                            <s:url var="updateprojectTimeSheetProcessURL" action="TimeSheetApprovalLevelRead" namespace="/TimeSheet"
                                                escapeAmp="false">
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
                                            <s:property value="frequency" />
                                        </td>
                                        <td align="center">
                                            <s:property value="startDay" />
                                        </td>
                                        <td align="center">
                                            <s:property value="minimumApprovalLevelType" />
                                        </td>
                                        <td align="center">
                                            <s:property value="regularDailyHours" />
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
                </div>
            </div>
        </div>
    </div>


    <!--END PAGE CONTENT -->

    <!-- FOOTER -->
    <div id="footer">
        <%@ include file="/components/core/jsp/footer.jsp"%>
    </div>
    <!--END FOOTER -->


</body>
</html>