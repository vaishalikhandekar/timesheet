
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><tiles:insertAttribute name="title" ignore="true" /></title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>

<style>

    table, th, td {
        border: 1px solid gray;
        border-collapse: collapse;
    }
    
    html {
        height:100%;
    }
    body {
        width: 100%; height:97%;
    }
    
</style>

</head>

<body>

    <table style="width: 100%; height: 100%; border: 1; cellpadding: 2; cellspacing: 2; align: top">

        <tr>
            <td height="10%" colspan="2" ><tiles:insertAttribute name="header" /></td>
        </tr>

        <tr>
            <td width="15%" valign="top"><tiles:insertAttribute name="menu" /></td>
            <td width="85%" valign="top"><tiles:insertAttribute name="body" /></td>
        </tr>

        <tr>
            <td height="5%" colspan="2" ><tiles:insertAttribute name="footer" /></td>
        </tr>

    </table>

</body>

</html>