<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<h> LOGIN PAGE </h>
<br>
<body>

	<s:form action="/PersonLogin" method="POST">

		<table border="1">
			<!--   <fieldset style="width: 400px;height: 400px">-->

			<tr>
				<td>USERNAME:</td>
				<td><s:textfield type="text" name="usersDetail.userName" /></td>
			</tr>
			<tr>
				<td>PASSWORD:</td>
				<td><s:textfield type="password" name="usersDetail.password" /></td>
			</tr>
			<s:submit type="submit" name="submit" value="Login" />
		</table>

		<br>
		<a href="/TimeSheet/components/profile/jsp/person/PersonRegistration.jsp">New User</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<br>
		<br>

		<br>
		<br>
	</s:form>
</body>
</html>