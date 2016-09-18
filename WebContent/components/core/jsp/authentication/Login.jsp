
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>
    <h2>User Login</h2>
    
    <br />
    
    <s:form action="/PersonLogin" method="POST">

        <table style="width: 100%; height: 100%; border: 1; cellpadding: 2; cellspacing: 2; align: top">

            <col width="40%" />
            <col width="60%" />
            
            <tbody>
            
                <tr style="height:30px;">
                    <th class="label">
                        <span class="label" title="User Name:">User Name:</span>
                    </th>
                    <td class="field">
                        <input type="text" name="usersDetail.userName" />
                    </td>
                </tr>
                
                <tr style="height:30px;">
                    <th class="label">Password:</th>
                    <td class="field">
                        <input type="password" name="usersDetail.password" />
                    </td>
                </tr>
                
            </tbody>

            <s:submit type="submit" name="submit" value="Login" align="center" style="height:30px;"/>
            
        </table>

        <br />
        
        If you are experiencing problem with this login, please contact the Customer Support Center by emailing ITHELP@abc.com or calling (123) 123-1234 for assistance.
        
        <br />
        <a href="/PersonResetPassword">Reset Your Password</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br />

    </s:form>

</body>
</html>