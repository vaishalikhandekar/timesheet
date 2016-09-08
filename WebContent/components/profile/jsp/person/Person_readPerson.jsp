
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>

</head>

<body>

 <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeletePerson" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Person</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="DeletePerson" namespace="/" action="DeletePerson" method="POST" role="form" theme="bootstrap">

                            <p>Are You Sure ?</p>


                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Delete" class="btn btn-primary" />
                                <s:hidden name="personDetail.personID"></s:hidden>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>

 
    <jsp:include page="Person_navPerson.jsp"></jsp:include>
    
    <s:form action="/ReadPerson" method="post">

        <table class="table table-striped">
            <thead>

                <tr class="success">
                    <th align="left">Title</th>
                    <th>First Name</th>
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

                <td>
                 <s:url var="updatePersonURL" action="ReadPerson" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personID}" />
                                    <s:param name="act" value="%{updateAction}" />
                                </s:url> 
                                <s:a href="%{updatePersonURL}"><span class="glyphicon glyphicon-pencil"></span> <!-- Update --></s:a>
                    
                    <a href="#DeletePerson" data-toggle="modal"><span class="glyphicon glyphicon-trash"></span> <!-- Delete --></a></td>
            </tr>
                    <s:hidden name="personDetail.personID"></s:hidden>

        </table>

    </s:form>

</body>
</html>