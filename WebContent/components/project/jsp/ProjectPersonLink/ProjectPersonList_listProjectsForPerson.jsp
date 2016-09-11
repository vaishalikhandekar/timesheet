
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>
 
    <jsp:include page="/components/profile/jsp/person/Person_navPerson.jsp"></jsp:include>
    
    <s:form action="/PersonProjectList" method="post">

        <table class="table table-striped">
        
            <thead>

                <tr class="success">
                    <th style="text-align: center">Project Name</th>
                    <th style="text-align: center">Role</th>
                    <th style="text-align: center">Start Date</th>
                    <th style="text-align: center">End Date</th>
                </tr>
            </thead>
            
            <s:iterator value="projectPersonLinkDetailList" status="stat">
            
            <tr>
                <td align="center"><s:property value="projectDetail.projectName" /></td>
                <td align="center"><s:property value="role" /></td>
                <td align="center"><s:property value="projectDetail.startDate" /></td>
                <td align="center"><s:property value="projectDetail.endDate" /></td>

                 </tr>

</s:iterator>
        </table>

    </s:form>

</body>
</html>