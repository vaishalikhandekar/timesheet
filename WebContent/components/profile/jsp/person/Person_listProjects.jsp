
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
    
    <s:form action="/ReadPerson" method="post">

        <table class="table table-striped">
            <thead>

                <tr class="success">
                    <th align="left">Title</th>
                    <th>Project Name</th>
                    <th>Middle Name</th>
                    <th>Last Name</th>
                    <th>Gender</th>
                    <th>Date Of Birth</th>
                    <th>Registration Date</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>

            <tr>
                <td><s:property value="personDetail.title" /></td>
                <td><s:property value="personDetail.firstName" /></td>
                <td><s:property value="personDetail.middleName" /></td>
                <td><s:property value="personDetail.lastName" /></td>
                <td><s:property value="personDetail.gender" /></td>
                <td><s:property value="personDetail.dateOfBirth" /></td>
                <td><s:property value="personDetail.registrationDate" /></td>

                <td><s:url var="updatePersonURL" action="ReadPerson" escapeAmp="false">
                        <s:param name="personDetail.personID" value="%{personID}" />
                        <s:param name="act" value="%{updateAction}" />
                    </s:url> <s:a href="%{updatePersonURL}">Update</s:a> <a href="#DeletePerson" data-toggle="modal">Delete</a></td>
            </tr>


        </table>

    </s:form>

</body>
</html>