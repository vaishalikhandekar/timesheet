<%@	page import="java.util.List"%>
<%@	page import="com.company.timesheet.profile.person.pojo.UsersDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<h1> Login Page </h1>
<br>
<body>

	<form action="/ITOS/PersonLogin" method="POST">


		<fieldset style="width: 400px">
			<table>
				<%
					UsersDetail usersDetail = (UsersDetail) request
							.getAttribute("usersDetail");

					if (null != usersDetail) {
						List<String>errorMessageList=usersDetail.getErrorMessageList();
						for(int	i=0;i<errorMessageList.size();i++)
						{%>
				<br>
				<font size="3" color="red"> <% out.println(errorMessageList.get(i));%>
				</font>

				<% }
				%>
				<br>
				<br>USERNAME:
				<input type="text" name="userName"></input>
				<br>
				<br> PASSWORD:
				<input type="password" name="password"></input>
				<br>

				<%
					} else {
				%>
				<br>
				<br>USERNAME:
				<input type="text" name="userName"></input>
				<br>
				<br> PASSWORD:
				<input type="password" name="password"></input>


				<%
					}
				%>
				<br>
				<br>
				<input type="submit" name="submit" value="Login"></input> &nbsp&nbsp
				<a href="RegistrationForm.jsp">New User</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<a href="/ITOS/SearchPerson">Search</a>
				<br><br><a href="/ITOS/ListCodeTableHeader">List Code Table </a>
				
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListProperties"> Properties List</a>
			
				<br><br><a href="/ITOS/ListKeyServer"> List KeyServer</a>
				&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href="/ITOS/ListRole"> List Role</a><br><br>
				<a href="/ITOS/ListUserRoleLink"> List UserRoleLink</a>
				

			</table>
	</form>
</body>
</html>