<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<s:form
		action="/UpdateTimeSheetLineItemSubmit"
		method="POST">

		
		<table>
			<tr>
				<td>Category </td>
				<td><s:textfield name="timeSheetLineItemDetail.category"
					/></td>
			</tr>

			<tr>
				<td>AttendenceDate</td>
				<td><s:textfield name="timeSheetLineItemDetail.attendenceDate"
					/></td>
			</tr>
			
			<tr>
				<td>Comments</td>
				<td><s:textfield name="timeSheetLineItemDetail.comments"
					/></td>
			</tr>
			<tr>
				<td>Actual Regular Hours Worked</td>
				<td><s:textfield name="timeSheetLineItemDetail.actualRegularHoursWorked"
					/></td>
			</tr>
			<tr>
				<td>Actual Overtime Hours Worked</td>
				<td><s:textfield name="timeSheetLineItemDetail.actualOvertimeHoursWorked"
					/></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="submit"/>
                <s:hidden name="timeSheetLineItemDetail.timeSheetLineItemID"></s:hidden>
                <s:hidden name="timeSheetLineItemDetail.versionNo"></s:hidden>

			</tr>


		</table>

	</s:form>

		

</body>
</html>