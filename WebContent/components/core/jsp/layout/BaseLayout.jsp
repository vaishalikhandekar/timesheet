
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>

    <table style="width: 100%; height: 100%; border: 1; cellpadding: 2; cellspacing: 2; align: top">
        <tr>
            <td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
        </tr>
        <tr>
            <td height="250"><tiles:insertAttribute name="menu" /></td>
            <td width="350"><tiles:insertAttribute name="body" /></td>
        </tr>
        <tr>
            <td height="30" colspan="2"><tiles:insertAttribute name="footer" /></td>
        </tr>
    </table>
    
</body>

</html>