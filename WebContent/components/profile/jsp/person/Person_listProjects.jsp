
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>
 
    <jsp:include page="Person_navPerson.jsp"></jsp:include>
    
    <s:form action="/PersonProjectList" method="post">

        <table class="table table-striped">
        
            <thead>

                <tr class="success">
                    <th align="left">Project Name</th>
                    <th>Role</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            
            <s:iterator value="projectPersonLinkDetailList" status="stat">
            
            <tr>
                <td><s:property value="projectDetail.projectName" /></td>
                <td><s:property value="role" /></td>
                <td><s:property value="projectDetail.startDate" /></td>
                <td><s:property value="projectDetail.endDate" /></td>

                 </tr>

</s:iterator>
        </table>

    </s:form>

</body>
</html>