
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

    <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeleteProject" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="RemoveProjectFromPerson" namespace="/Project" action="RemoveProjectFromPerson" method="POST"
                            role="form" theme="bootstrap">

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


    <s:form action="/PersonProjectList" namespace="/Project" method="post">

        <table class="table table-striped">

            <thead>

                <tr class="success">
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Project Name</th>
                    <th style="text-align: center">Role</th>
                    <th style="text-align: center">Start Date</th>
                    <th style="text-align: center">End Date</th>
                </tr>
            </thead>

            <s:iterator value="projectPersonLinkDetailList" status="stat">

                <tr>

                    <td align="center">
                        <s:url var="updateProjectURL" action="ReadProjectPersonLink" namespace="/Project" escapeAmp="false">
                            <s:param name="personDetail.personID" value="%{personID}" />
                            <s:param name="act" value="%{updateAction}" />
                        </s:url>
                        <s:a href="%{updateProjectURL}">
                            <span class="glyphicon glyphicon-pencil"></span>
                            <!-- Update -->
                        </s:a>

                        <a href="#DeleteProject" data-toggle="modal">
                            <span class="glyphicon glyphicon-trash"></span>
                            <!-- Delete -->
                        </a>

                    </td>

                    <td align="center">
                        <s:property value="projectDetail.projectName" />
                    </td>
                    <td align="center">
                        <s:property value="role" />
                    </td>
                    <td align="center">
                        <s:property value="projectDetail.startDate" />
                    </td>
                    <td align="center">
                        <s:property value="projectDetail.endDate" />
                    </td>

                </tr>

            </s:iterator>
        </table>

    </s:form>

</body>
</html>