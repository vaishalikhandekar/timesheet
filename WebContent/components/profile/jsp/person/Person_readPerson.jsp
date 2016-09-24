
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

                        <s:form class="form-inline" name="DeletePerson" namespace="/Profile" action="PersonDelete" method="POST" role="form" theme="bootstrap">

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


    <jsp:include page="Person_navPerson.jsp" />


    <table class="table table-striped" style="width: 100%;">

        <col width="20%" />
        <col width="30%" />
        <col width="20%" />
        <col width="30%" />


        <tr>
            <th style="text-align: right">Action:</th>
            <td align="left">


                &nbsp; &nbsp; &nbsp;
                <s:url var="updatePersonURL" action="PersonRead" escapeAmp="false">
                    <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                    <s:param name="act" value="%{personDetail.updateAction}" />
                </s:url>
                <s:a href="%{updatePersonURL}">
                    <span class="glyphicon glyphicon-pencil"></span>
                    <!-- Update -->
                </s:a>
                <%--  &nbsp;&nbsp;

                    <a href="#DeletePerson" data-toggle="modal">
                        <span class="glyphicon glyphicon-trash"></span>
                        <!-- Delete -->
                    </a> --%>

            </td>
            <th style="text-align: right">Title:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.title" />
            </td>
        </tr>
        <tr>
            <th style="text-align: right">First Name:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.firstName" />
            </td>
            <th style="text-align: right">Middle Name:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.middleName" />
            </td>
        </tr>
        <tr>

            <th style="text-align: right">Last Name:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.lastName" />
            </td>
            <th style="text-align: right">Gender:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.gender" />
            </td>
        </tr>
        <tr>
            <th style="text-align: right">Date Of Birth:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.dateOfBirth" />
            </td>
            <th style="text-align: right">Registration Date:</th>
            <td align="left">
                &nbsp; &nbsp; &nbsp;
                <s:property value="personDetail.registrationDate" />
            </td>
        </tr>

        <s:hidden name="personDetail.personID"></s:hidden>
        
    </table>


</body>
</html>