
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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
                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

                    </head>
                    <body>

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

                                                                <!-- <s:a href="%{ProjectDeleteURL}" onclick="return confirm('Are u sure?');">Delete</s:a> -->


                                                                <!-- Code to create new project -->

                                                                <!-- <div class="pull-right" class="container"> -->

                                                                <form action="/DeleteProject" method="post">

                                                                    <button type="submit" class="btn btn-primary" data-toggle="modal"
                                                                        data-target="#modal-2" value="delete" name="delete_project">Delete</button>

                                                                </form>

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

                                                                            </div>

                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-primary" id="delete">Delete
                                                                                </button>
                                                                                <button type="button" class="btn btn-default" data-dismiss="modal">
                                                                                    Close
                                                                                </button>
                                                                            </div>


                                                                        </div>

                                                                    </div>

                                                                </div>

                                                                <!-- </div> -->

                                                                <script >
                                                                

                                                                    $('button[name="delete_project"]').on('click', function(e){
                                                                    var $form=$(this).closest('form');
                                                                    e.preventDefault();
                                                                    $('#modal-2').modal({ backdrop: 'static', keyboard: false })
                                                                    .one('click', '#delete', function() {
                                                                    $form.trigger('submit'); // submit the form
                                                                    });
                                                                    // .one() is NOT a typo of .on()
                                                                    });


                        </script>


























                                                                    <!-- <div class="container">

                                                                        <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                        data-target="#modal-2">Delete</button>

                                                                        <div class="modal fade" id="modal-2" data-keyboard="false" data-backdrop="static">

                                                                        <s:form class="form-inline" name="DeleteProject" namespace="/" action="DeleteProject"
                                                                        method="post" role="form" theme="bootstrap">

                                                                        <div class="modal-dialog modal-lg">

                                                                        <div class="modal-content">

                                                                        <div class="modal-header">

                                                                        <button class="close" type="button" data-dismiss="modal">&times;
                                                                        </button>
                                                                        <h3 class="modal-title">Delete Project</h3>

                                                                        </div>

                                                                        <div class="modal-body">

                                                                        <p>Are u sure?</p>

                                                                        </div>

                                                                        <div class="modal-footer">

                                                                        <s:submit type="submit" id="submit" value="Submit"
                                                                        class="btn btn-primary" action="DeleteProject" />

                                                                        <button type="button" class="btn btn-default"
                                                                        data-dismiss="modal">Cancel</button>

                                                                        </div>

                                                                        </div>

                                                                        </div>

                                                                        </s:form>

                                                                        </div>

                                                                        </div>
                                                                    -->
                                                            </td>

                                                        </tr>

                                                    </tbody>

                                                </s:iterator>

                                            </table>
                                        </div>

                            </s:form>


                    </body>
                </html>