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
		action="/UpdateProjectEmployeeLinkSubmit"
		method="POST">

		
		<table>
			<tr>
				<td>Role </td>
				<td><s:textfield name="projectPersonLinkDetail.role"
					/></td>
			</tr>

			<tr>
				<td>Comments</td>
				<td><s:textfield name="projectPersonLinkDetail.comments"
					/></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><s:textfield name="projectPersonLinkDetail.startDate"
					/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><s:textfield name="projectPersonLinkDetail.endDate"
					/></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="submit"/>
                <s:hidden name="projectPersonLinkDetail.projectPersonLinkID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.versionNo"></s:hidden>

			</tr>


		</table>

	</s:form>

		

</body>
</html>