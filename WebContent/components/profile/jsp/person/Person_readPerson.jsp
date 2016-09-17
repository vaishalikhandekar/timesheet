
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

                <tr>
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Title</th>
                    <th style="text-align: center">First Name</th>
                    <th style="text-align: center">Middle Name</th>
                    <th style="text-align: center">Last Name</th>
                    <th style="text-align: center">Gender</th>
                    <th style="text-align: center">Date Of Birth</th>
                    <th style="text-align: center">Registration Date</th>
                </tr>
            </thead>

            <tr>


                <td align="center">
                
                    <s:url var="updatePersonURL" action="ReadPerson" escapeAmp="false">
                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                        <s:param name="act" value="%{personDetail.updateAction}" />
                    </s:url>
                    <s:a href="%{updatePersonURL}">
                        <span class="glyphicon glyphicon-pencil"></span>
                        <!-- Update -->
                    </s:a>
                    &nbsp;&nbsp;

                    <a href="#DeletePerson" data-toggle="modal">
                        <span class="glyphicon glyphicon-trash"></span>
                        <!-- Delete -->
                    </a>
                    
                </td>
                <td align="center">
                    <s:property value="personDetail.title" />
                </td>
                <td align="center">
                    <s:property value="personDetail.firstName" />
                </td>
                <td align="center">
                    <s:property value="personDetail.middleName" />
                </td>
                <td align="center">
                    <s:property value="personDetail.lastName" />
                </td>
                <td align="center">
                    <s:property value="personDetail.gender" />
                </td>
                <td align="center">
                    <s:property value="personDetail.dateOfBirth" />
                </td>
                <td align="center">
                    <s:property value="personDetail.registrationDate" />
                </td>


                <s:hidden name="personDetail.personID"></s:hidden>
            </tr>
        </table>

    </s:form>

</body>
</html>