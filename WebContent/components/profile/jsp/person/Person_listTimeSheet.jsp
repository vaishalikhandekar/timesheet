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
    <h2>ToDo _ Page UnderConstruction</h2>

    <s:form action="/TimeSheetList" method="post">

        <a href="CreateTimeSheet">New TimeSheet</a>
        <br>
        <br>
        <table class="table table-striped">
            <thead>

                <tr>
                    <th align="left">Month</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Maximum Total Hours</th>
                    <th>Actual Total Hours</th>
                    <th>Submitted Date</th>
                    <th>Status</th>
                </tr>
            </thead>

            <s:iterator value="timeSheetDetailList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="month" /></td>
                        <td><s:property value="startDate" /></td>
                        <td><s:property value="endDate" /></td>
                        <td><s:property value="maximumTotalHours" /></td>
                        <td><s:property value="actualTotalHours" /></td>
                        <td><s:property value="submittedDate" /></td>
                        <td><s:property value="timeSheetStatus" /></td>

                    </tr>
                </tbody>

            </s:iterator>

        </table>

    </s:form>
</body>
</html>