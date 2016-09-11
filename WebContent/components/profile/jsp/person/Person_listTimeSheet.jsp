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

                <tr class="success">
                    <th style="text-align: center">Month</th>
                    <th style="text-align: center">Start Date</th>
                    <th style="text-align: center">End Date</th>
                    <th style="text-align: center">Maximum Total Hours</th>
                    <th style="text-align: center">Actual Total Hours</th>
                    <th style="text-align: center">Submitted Date</th>
                    <th style="text-align: center">Status</th>
                </tr>
            </thead>

            <s:iterator value="timeSheetDetailList" status="stat">

                <tbody>
                    <tr>
                        <td align="center"><s:property value="month" /></td>
                        <td align="center"><s:property value="startDate" /></td>
                        <td align="center"><s:property value="endDate" /></td>
                        <td align="center"><s:property value="maximumTotalHours" /></td>
                        <td align="center"><s:property value="actualTotalHours" /></td>
                        <td align="center"><s:property value="submittedDate" /></td>
                        <td align="center"><s:property value="timeSheetStatus" /></td>

                    </tr>
                </tbody>

            </s:iterator>

        </table>

    </s:form>
</body>
</html>