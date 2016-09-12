<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<s:form action="/ReadProjectEmployeeLink" method="post">
				
<table class="table table-striped">
			<thead>

				<tr>
					<th style="text-align: center">Role</th>
					<th style="text-align: center">Start Date</th>
					<th style="text-align: center">End Date</th>
				</tr>
			</thead>

	
	
	<tbody>
				<tr>
					<td align="center"><s:property value="projectPersonLinkDetail.role"/></td>
					<td align="center"><s:property value="projectPersonLinkDetail.startDate" /></td>
					<td align="center"><s:property value="projectPersonLinkDetail.endDate" /></td>
				
				</tr>
	</tbody>
	

</table><br>


</s:form>
	

</body>
</html>