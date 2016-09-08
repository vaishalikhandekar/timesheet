
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="com.company.timesheet.project.pojo.ProjectDetail"%>

<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="bootstrap-confirmation.js"></script>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>

<script type="text/javascript">
	$.fx.speeds._default = 1000;
	$(function() {

		$("#deleteProjectID").click(function() {
			$("#deleteProjectID-model").dialog("open");
			return false;
		});

		$("#deleteProjectID-model").dialog({
			resizable : false,
			height : 140,
			modal : true,
			autoOpen : false,
			buttons : {
				"DeleteProject" : function() {
					$(this).dialog("submit");
					submit = true;
					$('#deleteProject').submit();
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});

	});

</script>

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

                            <p>Are You Sure</p>


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




    <!-- ***************************************Code for delete modal***************************** -->

    <div class="body">

        <div id="deleteProjectID-model" title="Delete Project">


            <s:form namespace="/" action="DeleteProject" method="post" id="deleteProject">

                <!-- <p>Are U sure?</p> -->

                <s:hidden name="projectDetail.projectID" value="%{projectID}" />
            </s:form>
        </div>

        <br>

        <jsp:include page="Project_navProject.jsp"></jsp:include>

        <br />

        <%
        	ProjectDetail projectDetail = (ProjectDetail) request
        			.getAttribute("projectDetail");

        	Long projectID = (Long) request.getAttribute("projectID");
        %>

        <a href="AddPersonToProject?projectID=<%=projectID%>">Add Person To Project</a>
        <br />

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

                    <td><a href="#DeleteProject" data-toggle="modal">Delete</a> <%--      <s:param name="projectDetail.projectID" value="%{projectID}" /> --%>


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