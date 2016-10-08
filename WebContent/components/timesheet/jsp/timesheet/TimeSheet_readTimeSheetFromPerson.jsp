<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>
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

                    <jsp:include page="/components/profile/jsp/person/Person_navPerson.jsp"></jsp:include>

                    <table style="width: 100%;" class="table table-striped">

                        <col width="20%" />
                        <col width="30%" />
                        <col width="20%" />
                        <col width="30%" />

                        <tr>
                            <th style="text-align: right">Project Name</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.projectName" />
                            </td>

                            <th style="text-align: right">Time Sheet Status</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.timeSheetStatus" />
                            </td>

                        </tr>

                        <tr>

                            <th style="text-align: right">Start Date</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.startDate" />
                            </td>

                            <th style="text-align: right">End Date</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.endDate" />
                            </td>

                        </tr>
                        <tr>

                            <th style="text-align: right">TotalRegularHours</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.totalRegularHours" />
                            </td>

                            <th style="text-align: right">TotalNoOfHoursWorked</th>
                            <td align="left">
                                &nbsp; &nbsp; &nbsp;
                                <s:property value="timeSheetDetail.totalNoOfHoursWorked" />
                            </td>

                        </tr>

                    </table>

                    <s:form action="TimeSheetLineItemReadFromPerson" namespace="/TimeSheet" method="post">
                        <br>
                        <br>
                        <table class="table table-striped" border="1">
                            <thead>

                                <tr class="success">
                                    <th style="text-align: center">Action</th>
                                    <th style="text-align: center">AttendenceDay</th>
                                    <th style="text-align: center">AttendenceDate</th>
                                    <th style="text-align: center">Category</th>
                                    <th style="text-align: center">NoOfHoursWorked</th>
                                    <th style="text-align: center">Comments</th>
                                </tr>
                            </thead>
                            <s:iterator value="timeSheetDetail.timeSheetLineItemDetailList" status="stat">
                                <tr>

                                    <td align="center">

                                        <s:url var="updateprojectTimeSheetProcessURL" action="TimeSheetLineItemRead" namespace="" escapeAmp="false">
                                            <s:param name="projectDetail.projectID" value="%{projectID}" />
                                            <s:param name="act" value="%{updateAction}" />
                                        </s:url>

                                        <s:a href="%{updateprojectTimeSheetProcessURL}">
                                            <span class="glyphicon glyphicon-pencil"></span>
                                            <!-- Update -->
                                        </s:a>
                                        &nbsp;&nbsp;

                                    </td>

                                    <td align="center">
                                        <s:property value="dayOfWeek" />
                                    </td>
                                    <td align="center">
                                        <s:property value="attendenceDate" />
                                    </td>
                                    <td align="center">
                                        <s:property value="category" />
                                    </td>

                                    <td align="center">
                                        <s:property value="noOfHoursWorked" />
                                    </td>
                                    <td align="center">
                                        <s:property value="comments" />
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>

                    </s:form>
                </div>
            </div>
        </div>
    </div>


    <!-- FOOTER -->
    <div id="footer">
        <%@ include file="/components/core/jsp/footer.jsp"%>
    </div>
    <!--END FOOTER -->
</body>
</html>