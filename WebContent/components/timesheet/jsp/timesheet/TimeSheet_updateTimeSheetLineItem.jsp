
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

    </table>

    <br />

    <s:form action="/TimeSheetUpdate" method="POST">


        <table class="table table-striped" border="1">

            <thead>

                <tr class="success">

                    <th style="text-align: center">Attendance Day</th>
                    <th style="text-align: center">Attendance Date</th>
                    <th style="text-align: center">Category</th>
                    <th style="text-align: center">No Of Hours Worked</th>
                    <th style="text-align: center">Comments</th>

                </tr>

            </thead>


            <s:iterator value="timeSheetDetail.timeSheetLineItemDetailList" status="stat">

                <tr>

                    <td align="center">
                        <s:property value="attendenceDate" />
                    </td>

                    <td align="center">
                        <s:property value="attendenceDate" />
                    </td>

                    <td align="center">
                        <s:textfield theme="simple" name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].category" value="%{category}" />
                    </td>

                    <td align="center">
                        <s:textfield theme="simple" name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].noOfHoursWorked"
                            value="%{noOfHoursWorked}" />
                    </td>

                    <td align="center">
                        <s:textfield theme="simple" name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].comments" value="%{comments}" />
                    </td>

                </tr>

                <s:hidden name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].timeSheetLineItemID" value="%{timeSheetLineItemID}" />
                <s:hidden name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].timeSheetID" value="%{timeSheetID}" />
                <s:hidden name="timeSheetDetail.timeSheetLineItemDetailList[%{#stat.index}].versionNo" value="%{versionNo}" />

            </s:iterator>

            <s:hidden name="timeSheetDetail.timeSheetID"></s:hidden>
            <s:hidden name="timeSheetDetail.versionNo"></s:hidden>

            <s:submit type="submit" value="Save" class="btn btn-primary" />

        </table>
        
    </s:form>


</body>
</html>