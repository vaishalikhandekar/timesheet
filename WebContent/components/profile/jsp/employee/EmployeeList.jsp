
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


                <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
                    <link rel="stylesheet" href="/resources/demos/style.css">
                        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                        <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                        <html>
                            <head>
                                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                                    <title>Time Sheet List</title>


                                    <script>
                                        $.fx.speeds._default = 1000;
                                        $(function() {

                                        $("#personDeleteID").click(function() {
                                        $("#personDeleteID-model").dialog("open");
                                        return false;
                                        });


                                        $("#personDeleteID-model").dialog({
                                        resizable :
                                        false,
                                        height : 240,
                                        modal : true,
                                        autoOpen : false,
                                        buttons : {
                                        "Delete Project" : function() {
                                        $(this).dialog("submit");
                                        submit =
                                        true;

                                        $('#deleteProject').submit(
                                        
                                       <!--  $.ajax({
                                        
                                        type : 'POST',
                                        url : ' <s:submit action="DeleteEmployee" method="find" /> '
                                        
                                        }) -->
                                        
                                        );
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

                                <div id="personDeleteID-model" title="Basic dialog">
                                    <s:form namespace="/" action="DeleteEmployee" method="post" id="deleteProject">
                                       <!--  <p>
                                            <span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>
                                            These items will be permanently deleted and cannot be recovered. Are you sure?
                                        </p> -->
                                        <s:hidden name="employeeDetail.employeeID" value="%{employeeID}" />
                                    </s:form>

                                </div>


                                <!-- *************************Code for Tabs************************************8 -->

                                <div class="tabbable full-width-tabs">
                                    <ul class="nav nav-tabs">

                                        <li class="active">
                                            <a data-toggle="tab" href="#EmployeeList">Person List</a>
                                        </li>
                                    </ul>

                                    <div class="tab-content">
                                        <div id="EmployeeList" class="tab-pane fade in active">


                                            <!-- Create New Employee -->

                                            <br />
                                            <div class="pull-right" class="container">

                                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New
                                                    Employee
                                                </button>
                                            </div>


                                            <s:form action="/ListEmployee" method="post">

                                                <table class="table table-striped">
                                                    <thead>

                                                        <tr>
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

                                                    <s:iterator value="employeeDetailList" status="stat">

                                                        <tbody>
                                                            <tr>
                                                                <td>
                                                                    <s:property value="title" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="firstName" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="middleName" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="lastName" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="gender" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="dateOfBirth" />
                                                                </td>
                                                                <td>
                                                                    <s:property value="registrationDate" />
                                                                </td>

                                                                <td>
                                                                    <s:url var="updateEmployeeURL" action="ReadEmployee" escapeAmp="false">
                                                                        <s:param name="employeeDetail.employeeID" value="%{employeeID}" />
                                                                        <s:param name="act" value="%{updateAction}" />
                                                                    </s:url>
                                                                    <s:a href="%{updateEmployeeURL}">Update</s:a>

                                                                    <!-- <s:url id="EmployeeDeleteURL" action="DeleteEmployee" escapeAmp="false">
                                                                        <s:param name="employeeDetail.employeeID" value="%{employeeID}" />
                                                                        </s:url> -->



                                                                    <s:a href="%{EmployeeDeleteURL}" id="personDeleteID">Delete</s:a>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </s:iterator>


                                                </table>

                                            </s:form>
                                        </div>
                                    </div>
                                </div>

                            </body>
                        </html>