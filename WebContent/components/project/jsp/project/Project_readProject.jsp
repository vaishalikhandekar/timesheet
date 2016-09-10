
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

    <!-- ***************************************Code for adding Person to Project***************************** -->

        <s:form action="/ReadProject" method="post">
            <br>
            <br>


            <table class="table table-striped">
                <thead>

                    <tr>
                        <th>Project Name</th>
                        <th>Description</th>
                        <th>Record Status</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th colspan=2>Action</th>
                    </tr>
                </thead>

                <tr>
                    <td><s:property value="projectDetail.projectName" /></td>
                    <td><s:property value="projectDetail.description" /></td>
                    <td><s:property value="projectDetail.recordStatus" /></td>
                    <td><s:property value="projectDetail.startDate" /></td>
                    <td><s:property value="projectDetail.endDate" /></td>

                    <td><a href="#DeleteProject" data-toggle="modal">Delete</a> 
                    
                        <s:url id="AddPersonToProjectURL" action="AddPersonToProject" escapeAmp="false">
                            <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                        </s:url> <s:a href="%{AddPersonToProjectURL}">Add Person</s:a></td>

                </tr>
                <s:hidden name="projectDetail.projectID"></s:hidden>


            </table>
            <br>


        </s:form>

    </div>
</body>
</html>