<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div class="container" style="border: thin solid black"> 
        <br>

<s:form action="/SearchProjectSubmit" method="POST">
        <table >
<h4 class="well">Person Search</h4>
            <tr>
                <td>Project Name</td>
                <td><s:textfield type="text" name="projectSearchDetails.projectSearchCriteria.projectName" /></td>
            </tr>
               
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
        <br/>
            <br/>
         </div>
        <br>
        
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