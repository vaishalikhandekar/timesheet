
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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


</head>

<body>



    <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeleteEmployee" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="DeleteEmployee" namespace="/" action="DeleteEmployee" method="POST" role="form" theme="bootstrap">

                            <p>Are You Sure ?</p>

                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Delete" class="btn btn-primary" />
                                <s:hidden name="employeeDetail.employeeID"></s:hidden>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>
    
    <!-- ***************************************Code for update modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="updateEmployeeModal" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">
                        <s:form class="form-inline" name="UpdateEmployee" action="UpdateEmployeeSubmit" method="POST" namespace="/"  role="form" theme="bootstrap">

                                 <table>
                                <tr>
                                    <td>Title</td>
                                    <td><s:textfield name="employeeDetail.title" /></td>
                                </tr>

                                <tr>
                                    <td>First Name</td>
                                    <td><s:textfield name="employeeDetail.firstName" /></td>
                                </tr>
                                <tr>
                                    <td>Middle Name</td>
                                    <td><s:textfield name="employeeDetail.middleName" /></td>
                                </tr>
                                <tr>
                                    <td>Last Name</td>
                                    <td><s:textfield name="employeeDetail.lastName" /></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><s:textfield name="employeeDetail.gender" /></td>
                                </tr>
                                <tr>
                                    <td>Date Of Birth</td>
                                    <td><s:textfield name="employeeDetail.dateOfBirth" /></td>
                                </tr>
                                <tr>
                                    <td>Registration Date</td>
                                    <td><s:textfield name="employeeDetail.registrationDate" /></td>
                                </tr>
                            </table>
                                
                           
                            <div class="modal-footer">
                                <s:submit type="submit" value="submit" class="btn btn-primary" /> <s:hidden name="employeeDetail.employeeID"></s:hidden>
                                    <s:hidden name="employeeDetail.versionNo"></s:hidden>

                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>
    


    <!-- *************************Code for Tabs************************************8 -->

    <div class="tabbable full-width-tabs">
        <ul class="nav nav-tabs">

            <li class="active"><a data-toggle="tab" href="#EmployeeList">Person List</a></li>
        </ul>

        <div class="tab-content">
            <div id="EmployeeList" class="tab-pane fade in active">


                <!-- Create New Employee -->

                <br />
                <div class="pull-right" class="container">

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New Employee</button>
                </div>
                <br /> <br />


                <s:form action="/ListEmployee" method="post">

                    <table class="table table-striped">
                        <thead>

                            <tr class="success">
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

                            <tr>
                                <td><s:property value="title" /></td>
                                <td><s:property value="firstName" /></td>
                                <td><s:property value="middleName" /></td>
                                <td><s:property value="lastName" /></td>
                                <td><s:property value="gender" /></td>
                                <td><s:property value="dateOfBirth" /></td>
                                <td><s:property value="registrationDate" /></td>

                                <td><s:url var="updateEmployeeURL" action="ReadEmployee" escapeAmp="false">
                                        <s:param name="employeeDetail.employeeID" value="%{employeeID}" />
                                        <s:param name="act" value="%{updateAction}" />
                                    </s:url> <s:a href="%{updateEmployeeURL}">Update</s:a> <a href="#DeleteEmployee" data-toggle="modal">Delete</a></td>
                            </tr>
                        </s:iterator>


                    </table>

                </s:form>
            </div>
        </div>
    </div>

</body>
</html>