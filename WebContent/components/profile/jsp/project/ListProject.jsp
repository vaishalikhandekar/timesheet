<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@ taglib
prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>


<html lang="en">
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                <html>
                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                            <title></title>
                            <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> --> 

                            <script>

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
                                "Delete Project" : function() {
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

                                $(function() {
                                $("#accordion").accordion({
                                autoHeight : false,
                                navigation : true,
                                collapsible : true,
                                active : false
                                });
                                });


                            </script>

                    </head>
                    
                    <body>


                        <div class="body">

                            <div id="deleteProjectID-model" title="Delete Project">

                                <button></button>
                                <s:form namespace="/" action="DeleteProject" method="post" id="deleteProject">
                                    <p>
                                        <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0;"></span>
                                        These team will
                                        be permanently deleted and cannot be recovered. Are you sure?
                                    </p>
                                    <s:hidden name="projectDetail.projectID" value="%{projectID}" />
                                </s:form>
                            </div>

                            <br>

                                <!-- Code to create new project -->

                                <div class="pull-right" class="container">

                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New Project</button>

                                    <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

                                        <div class="modal-dialog modal-lg">

                                            <div class="modal-content">

                                                <div class="modal-header">

                                                    <button class="close" type="button" data-dismiss="modal">&times;
                                                    </button>
                                                    <h3 class="modal-title">Create New Project</h3>
                                                </div>

                                                <div class="modal-body">

                                                    <s:form class="form-inline" name="CreateProject" namespace="/" action="CreateProjectSubmit"
                                                        method="POST" role="form" theme="bootstrap">

                                                        <br />

                                                        <div class="form-group">
                                                            <label>Project Name:</label>
                                                            <input type="text" class="form-control" name="projectDetail.projectName" />
                                                        </div>

                                                        <br />

                                                        <div class="form-group">
                                                            <label>Description:</label>
                                                            <input type="text" class="form-control" name="projectDetail.description" />
                                                        </div>

                                                        <br />

                                                        <div class="form-group">
                                                            <label>Start Date:</label>
                                                            <input type="text" id="datepicker" class="dateTxt" name="projectDetail.startDate"
                                                                placeholder="mm/dd/yy" />
                                                        </div>

                                                        <br />

                                                        <div class="form-group">
                                                            <label>End Date:</label>
                                                            <input type="text" id="datepicker" class="dateTxt" name="projectDetail.endDate"
                                                                placeholder="mm/dd/yy" />
                                                        </div>

                                                        <br />
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



                                <!-- <div class="container">



                                    <div class="modal fade" id="modal-2" data-keyboard="false" data-backdrop="static">



                                    <div class="modal-dialog modal-lg">

                                    <div class="modal-content">


                                    <div class="modal-header">

                                    <button class="close" type="button" data-dismiss="modal">&times;
                                    </button>
                                    <h3 class="modal-title">Delete Project</h3>

                                    </div>

                                    <div class="modal-body">

                                    <p>Are u sure?</p>

                                    <s:form class="form-inline" name="DeleteProject" action="DeleteProjectNew" namespace="/"
                                    method="post" role="form" theme="bootstrap">

                                    <div class="modal-footer">



                                    <s:submit type="submit" id="deleteID" value="Submit" class="btn btn-primary" />

                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>

                                    </div>
                                    </s:form>



                                    </div>



                                    </div>

                                    </div>


                                    </div>

                                    </div>
                                -->




                                <s:form name="ListForm" id="ListForm" method="post">

                                    <!-- <a href="CreateProject">Create New Project</a> -->
                                    <br>
                                        <br>
                                            <div class="container">
                                                <table class="table table-striped">
                                                    <thead>

                                                        <tr>
                                                            <th>Project Name</th>
                                                            <th>Description</th>
                                                            <th>Record Status</th>
                                                            <th>Start Date</th>
                                                            <th>End Date</th>
                                                            <th colspan=3>Action</th>
                                                        </tr>
                                                    </thead>

                                                    <s:iterator value="projectDetailList" status="stat">

                                                        <tbody>
                                                            <tr>
                                                                <td>
                                                                    <s:property value="projectName" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="description" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="recordStatus" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="startDate" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="endDate" />

                                                                </td>

                                                                <td>
                                                                    <s:url id="ViewProjectURL" action="ReadProject" escapeAmp="false">
                                                                        <s:param name="projectDetail.projectID" value="%{projectID}" />
                                                                    </s:url>
                                                                    <s:a href="%{ViewProjectURL}">View</s:a>

                                                                    <s:url var="updateProjectURL" action="ReadProject" escapeAmp="false">
                                                                        <s:param name="projectDetail.projectID" value="%{projectID}" />
                                                                        <s:param name="act" value="%{updateAction}" />
                                                                    </s:url>

                                                                    <s:a href="%{updateProjectURL}">Update</s:a>

                                                                    <s:url id="ProjectDeleteURL" action="DeleteProject" escapeAmp="false">
                                                                        <s:param name="projectDetail.projectID" value="%{projectID}" />
                                                                    </s:url>

                                                                    <s:a href="%{ProjectDeleteURL}" id="deleteProjectID">Delete</s:a>



                                                                    <!-- <s:a href="%{ProjectDeleteURL}" onclick="return confirm('Are u sure?');">Delete</s:a> -->


                                                                    <!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-2" 
                                                                        value="%{projectID}">Delete</button> -->

                                                                    <!-- <button type="button" class="btn btn-primary" data-toggle="modal" onclick="check()" 
                                                                        value="%{projectID}">Delete</button> -->


                                                                </td>

                                                            </tr>

                                                        </tbody>

                                                    </s:iterator>

                                                </table>
                                            </div>

                                </s:form>

							</div>

                    </body>
                </html>