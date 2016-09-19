<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

    <s:form action="/UpdateTimeSheetLineItemSubmit" method="POST">

        <s:iterator value="timeSheetDetail.timeSheetLineItemDetailList" status="stat">
            <table>
                <tr>
                    <td>category</td>
                    <td>
                        <s:textfield name="category" />
                    </td>
                </tr>

                <tr>
                    <td>attendenceDate</td>
                    <td>
                        <s:textfield name="attendenceDate" />
                    </td>
                </tr>
                <tr>
                    <td>noOfHoursWorked</td>
                    <td>
                        <s:textfield name="noOfHoursWorked" />
                    </td>
                </tr>
                <tr>
                    <td>comments</td>
                    <td>
                        <s:textfield name="comments" />
                    </td>
                </tr>

                <tr>

                    <td>
                        <s:submit type="submit" value="submit" />
                        <s:hidden name="timeSheetLineItemID"></s:hidden>
                        <s:hidden name="versionNo"></s:hidden>
                </tr>


            </table>
        </s:iterator>

    </s:form>



</body>
</html>