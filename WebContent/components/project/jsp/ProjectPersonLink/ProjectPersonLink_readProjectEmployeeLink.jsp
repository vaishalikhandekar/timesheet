<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<s:form action="/ReadProjectEmployeeLink" method="post">
				
<table class="table table-striped">
			<thead>

				<tr>
					<th align="left">Role</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>

	
	
	<tbody>
				<tr>
					<td><s:property value="projectPersonLinkDetail.role"/></td>
					<td><s:property value="projectPersonLinkDetail.startDate" /></td>
					<td><s:property value="projectPersonLinkDetail.endDate" /></td>
				
				</tr>
	</tbody>
	

</table><br>


</s:form>
	

</body>
</html>