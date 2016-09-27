
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<title></title>
<style type="text/css">
tr.break td {
	height: 25px;
}
</style>


<script type="text/javascript">
	$.fx.speeds._default = 1000;
	$(function() {

		$("#deleteProjectID").click(function() {
			$("#deleteProjectID-model").dialog("open");
			return false;
		});

		$("#deleteProjectID-model").dialog({
			resizable : false,
			height : 180,
			modal : true,
			autoOpen : false,
			buttons : {
				"Delete Project" : function() {
					$.ajax({
						type : 'POST',
						url : "/TimeSheet/Project/DeleteProject",
						// data: {projectDetail.projectID = projectID},
						cache : false
					}).done(function(submit) {
						// handle your data
						// example: data.actionAttribute
					});
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

    <!-- *************************Code for Tabs************************************8 -->

    <div class="tabbable full-width-tabs">
        <ul class="nav nav-tabs">

            <li class="active">
                <a data-toggle="tab" href="#ListProject">Project List</a>
            </li>
        </ul>

        <div class="tab-content">
            <div id="ListProject" class="tab-pane fade in active">


                <!-- ***************************************Code for delete modal***************************** -->

                <div class="body">

                    <div id="deleteProjectID-model" title="Delete Project">


                        <s:form namespace="/Project" action="ProjectDelete" method="post" id="deleteProject">

                            <p>Are You sure?</p>

                            <s:hidden name="projectDetail.projectID" value="%{projectID}" />
                        </s:form>
                    </div>

                    <br>

                    <!-- ***************************************Code for update***************************** -->



                    <!-- <div id="updateProjectID-model" title="Update Project">


                                <s:form namespace="/" action="UpdateProjectSubmit" method="post" id="updateProjectID">
                                <table>
                                <tr>
                                <td>Project Name </td>
                                <td>
                                <s:textfield name="projectDetail.projectName" />
                                </td>
                                </tr>

                                <tr>
                                <td>Description </td>
                                <td>
                                <s:textfield name="projectDetail.description" />
                                </td>
                                </tr>
                                <tr>
                                <td>Comments</td>
                                <td>
                                <s:textfield name="projectDetail.comments" />
                                </td>
                                </tr>
                                <tr>
                                <td>Start Date</td>
                                <td>
                                <s:textfield name="projectDetail.startDate" />
                                </td>
                                </tr>
                                <tr>
                                <td>End Date</td>
                                <td>
                                <s:textfield name="projectDetail.endDate" />
                                </td>
                                </tr>

                                <tr>

                                <td>
                                <s:submit type="submit" value="submit" />
                                <s:hidden name="projectDetail.projectID"></s:hidden>
                                <s:hidden name="projectDetail.versionNo"></s:hidden>

                                </tr>


                                </table>

                                <s:hidden name="projectDetail.projectID" value="%{projectID}" />
                                </s:form>
                                </div>

                                <br>
                            -->
                    <!-- ***************************************Code to create new project***************************** -->

                    <div class="pull-right" class="container">

                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New Project</button>
                        <br />
                        <br />


                        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

                            <div class="modal-dialog modal-lg">

                                <div class="modal-content">

                                    <div class="modal-header">

                                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                                        <h3 class="modal-title">Create New Project</h3>
                                    </div>

                                    <div class="modal-body">

                                        <s:form name="CreateProject" namespace="/Project" action="ProjectCreateSubmit" method="POST" role="form"
                                            theme="bootstrap">

                                            <table style="width: 100%;">
                                                <col width="20%" />
                                                <col width="30%" />
                                                <col width="20%" />
                                                <col width="30%" />

                                                <tr>

                                                    <th>Project Name</th>
                                                    <td>
                                                        <input type="text" name="projectDetail.projectName" />
                                                    </td>

                                                    <th>Acronym</th>
                                                    <td>
                                                        <input type="text" name="projectDetail.acronym" />
                                                    </td>
                                                </tr>


                                                <tr class="break">
                                                    <td colspan="2"></td>
                                                </tr>
                                                <tr>

                                                    <th>Start Date</th>
                                                    <td>
                                                        <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectDetail.startDate"
                                                            placeholder="mm/dd/yy" />
                                                    </td>

                                                    <th>End Date</th>
                                                    <td>
                                                        <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectDetail.endDate"
                                                            placeholder="mm/dd/yy" />
                                                    </td>

                                                </tr>

                                                <tr class="break">
                                                    <td colspan="2"></td>
                                                </tr>

                                                <tr>

                                                    <th>Description</th>
                                                    <td>
                                                        <!-- <input type="text" class="form-control" name="projectDetail.description" /> -->
                                                        <textarea name="projectDetail.description" cols="45" rows="3"></textarea>
                                                    </td>
                                                </tr>

                                            </table>
                                            <br />

                                            <div class="modal-footer">
                                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>

                                        </s:form>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                    <!-- *******************************code to update Project ******************************* -->

                    <!-- *******************************code to display Project List******************************* -->

                    <s:form name="ProjectList" id="ListForm" namespace="/Project" method="post">

                        <div class="container">
                            <table class="table table-striped" border="1">
                                <thead>

                                    <tr class="success">
                                        <th style="text-align: center">Action</th>
                                        <th style="text-align: center">Project Name</th>
                                        <th style="text-align: center">Acronym</th>
                                        <th style="text-align: center">Description</th>
                                        <th style="text-align: center">Start Date</th>
                                        <th style="text-align: center">End Date</th>
                                        <th style="text-align: center">Record Status</th>
                                    </tr>
                                </thead>

                                <s:iterator value="projectDetailList" status="stat">

                                    <tr>
                                        <td align="center">
                                            <s:url id="ViewProjectURL" action="ProjectRead" namespace="/Project" escapeAmp="false">
                                                <s:param name="projectDetail.projectID" value="%{projectID}" />
                                            </s:url>
                                            <s:a href="%{ViewProjectURL}">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                                <!-- View -->
                                            </s:a>
                                            &nbsp;&nbsp;

                                            <s:url var="updateProjectURL" action="ProjectRead" namespace="/Project" escapeAmp="false">
                                                <s:param name="projectDetail.projectID" value="%{projectID}" />
                                                <s:param name="act" value="%{updateAction}" />
                                            </s:url>

                                            <s:a href="%{updateProjectURL}">
                                                <span class="glyphicon glyphicon-pencil"></span>
                                                <!-- Update -->
                                            </s:a>
                                            &nbsp;&nbsp;

                                            <%-- <s:url id="updateProjectURL">
                                            </s:url> <s:a href="%{updateProjectURL}" id="updateProjectID">Update</s:a> --%>

                                            <s:url id="ProjectDeleteURL">
                                            </s:url>
                                            <s:a href="%{ProjectDeleteURL}" id="deleteProjectID">
                                                <span class="glyphicon glyphicon-trash"></span>
                                                <!-- Delete -->
                                            </s:a>
                                            <!-- <s:a href="%{ProjectDeleteURL}" onclick="return confirm('Are
                                                                    u sure?');">Delete</s:a> -->
                                            <!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    data-target="#modal-2"
                                                                    value="%{projectID}">Delete</button> -->
                                            <!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    onclick="check()"
                                                                    value="%{projectID}">Delete</button> -->
                                        </td>

                                        <td align="center">
                                            <s:property value="projectName" />
                                        </td>
                                        <td align="center">
                                            <s:property value="acronym" />
                                        </td>
                                        <td align="center">
                                            <s:property value="description" />
                                        </td>
                                        <td align="center">
                                            <s:property value="startDate" />
                                        </td>
                                        <td align="center">
                                            <s:property value="endDate" />
                                        </td>
                                        <td align="center">
                                            <s:property value="recordStatus" />
                                        </td>

                                        <!-- Script for delete -->

                                    </tr>
                                    
                                </s:iterator>

                            </table>
                        </div>

                    </s:form>

                </div>
            </div>
        </div>
    </div>

</body>
</html>