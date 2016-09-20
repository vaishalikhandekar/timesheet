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
    
     <br />

    <table style="width: 100%;">

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

    
    
     <s:form action="/TimeSheetLineItemReadFromPerson" method="post">
        <br>
        <br>
        <table class="table table-striped">
            <thead>

                <tr class="success">
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Category</th>
                    <th style="text-align: center">AttendenceDate</th>
                    <th style="text-align: center">NoOfHoursWorked</th>
                    <th style="text-align: center">Comments</th>
                </tr>
            </thead>
         <s:iterator value="timeSheetDetail.timeSheetLineItemDetailList" status="stat">
                    <tr>

                        <td align="center">

                            <s:url var="updateprojectTimeSheetProcessURL" action="" escapeAmp="false">
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
                            <s:property value="category" />
                        </td>
                        <td align="center">
                            <s:property value="attendenceDate" />
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
</body>
</html>