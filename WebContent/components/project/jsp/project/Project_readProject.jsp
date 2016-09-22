
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.company.timesheet.project.pojo.ProjectDetail"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>

</head>
<body>

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

                        <s:form class="form-inline" name="DeleteProject" namespace="/" action="DeleteProject" method="POST" role="form" theme="bootstrap">

                            <p>Are You Sure ?</p>


                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Delete" class="btn btn-primary" />
                                <s:hidden name="projectDetail.projectID"></s:hidden>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <jsp:include page="Project_navProject.jsp"></jsp:include>

    <!-- ***************************************Code for Persons to Project***************************** -->

    <s:form action="/ReadProject" method="post">
        <br>
        <br>


        <table class="table table-striped">
            <thead>

                <tr>
                    <th style="text-align: center">Action</th>
                    <th style="text-align: center">Project Name</th>
                    <th style="text-align: center">Description</th>
                    <th style="text-align: center">Record Status</th>
                    <th style="text-align: center">Start Date</th>
                    <th style="text-align: center">End Date</th>
                </tr>
            </thead>

            <tr>

                <td align="center">

                    <s:url var="updateProjectURL" action="ReadProject" escapeAmp="false">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                        <s:param name="act" value="%{projectDetail.updateAction}" />
                    </s:url>

                    <s:a href="%{updateProjectURL}">
                        <span class="glyphicon glyphicon-pencil"></span>
                        <!-- Update -->
                    </s:a>
                    &nbsp;&nbsp;

                    <a href="#DeleteProject" data-toggle="modal">
                        <span class="glyphicon glyphicon-trash"></span>
                        <!-- Delete -->
                    </a>
                </td>

                <td align="center">
                    <s:property value="projectDetail.projectName" />
                </td>
                <td align="center">
                    <s:property value="projectDetail.description" />
                </td>
                <td align="center">
                    <s:property value="projectDetail.recordStatus" />
                </td>
                <td align="center">
                    <s:property value="projectDetail.startDate" />
                </td>
                <td align="center">
                    <s:property value="projectDetail.endDate" />
                </td>


            </tr>
            <s:hidden name="projectDetail.projectID"></s:hidden>


        </table>
        <br>


    </s:form>

    </div>
</body>
</html>