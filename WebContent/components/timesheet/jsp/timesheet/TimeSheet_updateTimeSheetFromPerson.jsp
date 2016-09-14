<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

		<s:form
		action="/UpdateTimeSheetSubmit"
		method="POST">

		
		<table>
			<tr>
				<td>Role </td>
				<td><s:textfield name="timeSheetDetail.totalRegularHours"
					/></td>
			</tr>

			<tr>
				<td>Comments</td>
				<td><s:textfield name="timeSheetDetail.totalNoOfHoursWorked"
					/></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><s:textfield name="timeSheetDetail.startDate"
					/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><s:textfield name="timeSheetDetail.endDate"
					/></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="submit"/>
                <s:hidden name="timeSheetDetail.timeSheetID"></s:hidden>
                <s:hidden name="timeSheetDetail.versionNo"></s:hidden>

			</tr>


		</table>

	</s:form>

		

</body>
</html>