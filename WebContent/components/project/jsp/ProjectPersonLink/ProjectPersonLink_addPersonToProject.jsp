<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
    <br>




    <a href="SearchPerson">Search Person</a>
    <br>
    <br>
    <br>

    <s:form action="/CreateProjectPersonLinkSubmit" namespace="/Project" method="POST">


        <br>

        <div class="form-group">
            <label>Role:</label>
            <input type="text" class="form-control" name="projectPersonLinkDetail.role" />
        </div>
        <br>

        <div class="form-group">
            <label>Comments:</label>
            <input type="text" class="form-control" name="projectPersonLinkDetail.comments" />
        </div>
        <br>

        <div class="form-group">
            <label>Start Date:</label>
            <input type="text" id="datepicker" class="dateTxt" name="projectPersonLinkDetail.startDate" placeholder="mm/dd/yy" />
        </div>
        <br>

        <div class="form-group">
            <label>End Date:</label>
            <input type="text" id="datepicker" class="dateTxt" name="projectPersonLinkDetail.endDate" placeholder="mm/dd/yy" />
        </div>

        <br>
        <br>

        <s:hidden name="projectPersonLinkDetail.projectDetail.projectID" value="%{projectDetail.projectID}"></s:hidden>
        <s:hidden name="projectDetail.projectID"></s:hidden>

        <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />


    </s:form>







</body>
</html>