
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<script>
	$(function() {
		$("#accordion").accordion({
			collapsible : true
		});
			// $(this).addClass('accordion-group panel panel-default');
	});
</script>

</head>

<body>

    <div id="accordion">
        <h1>Person</h1>
        <div>
            <a href="/TimeSheet/Profile/SearchPerson">Person Search</a>
            <br />
            <br />
            <a href="/TimeSheet/Profile/ListPerson">Persons</a>
        </div>

        <h1>Project</h1>
        <div>
            <a href="/TimeSheet/Project/ListProject">Projects</a>
            <br />
            <br />
            <a href="/TimeSheet/Project/ProjectSearch" > Project Search</a>
            <br />
        </div>

        <h1>Time Sheet</h1>
        <div>
            <a href="TimeSheetList">Time Sheets</a>
            <br />
            <br />
            <a href="CreateTimeSheetLineItem">Create TimeSheetLineItem</a>
        </div>

    </div>

</body>

</html>