<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>
</head>
<body><br>

<!-- Create New Employee -->

<div class="pull-right" class="container">
		
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#modal-1">Create New Employee</button>
</div>


<s:form action="/ListEmployee" method="post">

<table class="table table-striped">
			<thead>

				<tr>
					<th align="left">Title</th>
					<th>First Name</th>
					<th>Middle Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Date Of Birth</th>
					<th>Registration Date</th>
					<th colspan=2>Action</th>
				</tr>
			</thead>

	<s:iterator value="employeeDetailList" status="stat">
	
	<tbody>
				<tr>
					<td><s:property value="title"/></td>
					<td><s:property value="firstName" /></td>
					<td><s:property value="middleName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="gender" /></td>
					<td><s:property value="dateOfBirth" /></td>
					<td><s:property value="registrationDate" /></td>
				
				<td>	
				 <s:url var="updateEmployeeURL" action="ReadEmployee" escapeAmp="false">
                                <s:param name="employeeDetail.employeeID" value="%{employeeID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                            </s:url>
                            <s:a href="%{updateEmployeeURL}">Update</s:a>
                            
                            <s:url id="EmployeeDeleteURL" action="DeleteEmployee" escapeAmp="false">
                                <s:param name="employeeDetail.employeeID" value="%{employeeID}"/>
                            </s:url>
                            <s:a href=  "%{EmployeeDeleteURL}">Delete</s:a>
				</td>
				</tr>
	</tbody>
	</s:iterator>
	

</table>

</s:form>
</body>
</html>