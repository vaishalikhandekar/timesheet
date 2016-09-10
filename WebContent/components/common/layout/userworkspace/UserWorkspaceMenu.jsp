
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	$(function() {
		$("#accordion").accordion({
			collapsible : true
		});
	});
</script>

</head>

<body>

    <div id="accordion">
        <h1>Person</h1>
        <div>
            <a href="SearchPerson">Person Search</a>
            <br />
            <br />
            <a href="ListPerson">Person List</a>
        </div>

        <h1>Project</h1>
        <div>
            <a href="ListProject">Project List</a>
            <br />
            <br />
            <a href="ProjectSearch">Project Search</a>
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