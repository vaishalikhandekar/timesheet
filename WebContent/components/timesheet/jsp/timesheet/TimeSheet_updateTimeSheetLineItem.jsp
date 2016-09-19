
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>

    <br />

    <table style="width: 100%; border: 1;">

        <col width="20%" />
        <col width="30%" />
        <col width="20%" />
        <col width="30%" />

        <tr>
            <th style="text-align: right">Project Name</th>
            <td align="left">
                <s:property value="timeSheetDetail.projectName" />
            </td>

            <th style="text-align: center">Time Sheet Status</th>
            <td align="center">
                <s:property value="timeSheetDetail.timeSheetStatus" />
            </td>

        </tr>

        <tr>

            <th style="text-align: center">Start Date</th>
            <td align="center">
                <s:property value="timeSheetDetail.startDate" />
            </td>

            <th style="text-align: center">End Date</th>
            <td align="center">
                <s:property value="timeSheetDetail.endDate" />
            </td>

        </tr>

    </table>

    <br />

    <s:form action="/UpdateTimeSheetLineItemSubmit" method="POST">


        <table style="width: 100%; border: 1;">

            <col width="20%" />
            <col width="20%" />
            <col width="20%" />
            <col width="30%" />

            <thead>

                <tr class="success">

                    <th align="center">Category</th>
                    <th align="center">Attendance Date</th>
                    <th align="center">No Of Hours Worked</th>
                    <th align="center">Comments</th>

                </tr>

            </thead>


            <tbody>

                <s:iterator value="timeSheetDetail.timeSheetLineItemDetailList" status="stat">
                
                    <tr>
                        <td align="center">
                            <s:textfield name="category" />
                        </td>

                        <td align="center">
                            <s:textfield name="attendenceDate" />
                        </td>

                        <td align="center">
                            <s:textfield name="noOfHoursWorked" />
                        </td>

                        <td align="center">
                            <s:textfield name="comments" />
                        </td>

                    </tr>

                </s:iterator>
                
                <tr>

                    <td>
                        <s:submit type="submit" value="Save" />
                    </td>

                    <s:hidden name="timeSheetLineItemID"></s:hidden>
                    <s:hidden name="versionNo"></s:hidden>

                </tr>

            </tbody>


        </table>


    </s:form>


</body>
</html>