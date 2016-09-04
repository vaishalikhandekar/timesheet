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
<title>Insert title here</title>
</head>
<body>


<s:form action="/SearchProjectSubmit" method="POST">
        <table class="table table-striped">

            <tr>
                <td>Project Name</td>
                <td><s:textfield type="text" name="projectSearchDetails.projectSearchCriteria.projectName" /></td>
            </tr>
            <tr>
                <td>Start Date</td>
                <td><s:textfield type="text" name="projectSearchDetails.projectSearchCriteria.startDate" /></td>
            </tr>
            <tr>
                <td>End Date</td>
                <td><s:textfield type="text" name="projectSearchDetails.projectSearchCriteria.endDate" /></td>
            </tr>
            <!--  <tr>
				<td>Date of Birth:</td>
				<td><input type="text" name="dateOfBirth"></td>
			</tr>-->



            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
        <br>
        <!--</s:form>-->
        
        <table class="table table-striped">
            <thead>

                <tr>
                    <th>Project Name</th>
                    <th>Description</th>
                    <th>StartDate</th>
                    <th>EndDate</th>
                </tr>
            </thead>

            <s:iterator value="projectSearchResult.projectDetailList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="projectName" /></td>
                        <td><s:property value="description" /></td>
                        <td><s:property value="startDate" /></td>
                        <td><s:property value="endDate" /></td>
                    </tr>
                </tbody>
            </s:iterator>


        </table>
    </s:form>
    
    

</body>
</html>