<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
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
                    <th style="text-align: center">Project Name</th>
                    <th style="text-align: center">Description</th>
                    <th style="text-align: center">StartDate</th>
                    <th style="text-align: center">EndDate</th>
                </tr>
            </thead>

            <s:iterator value="projectSearchResult.projectDetailList" status="stat">

                <tbody>
                    <tr>
                        <td align="center"><s:property value="projectName" /></td>
                        <td align="center"><s:property value="description" /></td>
                        <td align="center"><s:property value="startDate" /></td>
                        <td align="center"><s:property value="endDate" /></td>
                    </tr>
                </tbody>
            </s:iterator>


        </table>
    </s:form>
    
    

</body>
</html>