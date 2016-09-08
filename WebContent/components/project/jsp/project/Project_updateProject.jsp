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

<div class="container" style="border: thin solid black">
<s:form
		action="/UpdateProjectSubmit"
		method="POST">
 <h3 class="well">Update Project</h3>
		
		<table>
			<tr>
				<td>Project Name </td>
				<td><s:textfield name="projectDetail.projectName"
					/></td>
			</tr>

			<tr>
				<td>Description </td>
				<td><s:textfield name="projectDetail.description"
					/></td>
			</tr>
			<tr>
				<td>Comments</td>
				<td><s:textfield name="projectDetail.comments"
					/></td>
			</tr>
			<tr>
				<td>Start Date</td>
				<td><s:textfield name="projectDetail.startDate"
					/></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><s:textfield name="projectDetail.endDate"
					/></td>
			</tr>

			<tr>

				<td><s:submit type="submit" value="submit" class="btn btn-primary"/>
                <s:hidden name="projectDetail.projectID"></s:hidden>
                <s:hidden name="projectDetail.versionNo"></s:hidden>

			</tr>


		</table>
         <br/>

	</s:form>
 <br/>

</body>
</html>