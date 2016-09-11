
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<body>
<h4> User Login </h4>
<br />
    <s:form action="/PersonLogin" method="POST">

        <table style="width: 100%; height: 100%; border: 1; cellpadding: 2; cellspacing: 2; align: top">
        
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
		<br />
        <br />
        <br />
        <br />
        
    </s:form>
    
</body>
</html>