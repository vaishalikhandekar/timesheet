
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Sheet List</title>

<script>
	$(function() {
		$('.datepick').each(function() {
			$(this).datepicker({

				changeMonth : true,
				changeYear : true,

			}

			);
		});
	});
</script>


</head>

<body>

    <!-- ***************************************Code for delete modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="DeletePerson" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">

                        <s:form class="form-inline" name="DeletePerson" namespace="/" action="DeletePerson" method="POST" role="form" theme="bootstrap">

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

    <!-- ***************************************Code for update modal***************************** -->

    <div class="pull-right" class="container">

        <div class="modal fade" id="updatePersonModal" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">
                        <s:form class="form-inline" name="UpdatePerson" action="UpdatePersonSubmit" method="POST" namespace="/" role="form" theme="bootstrap">

                            <table>
                                <tr>
                                    <td>Title</td>
                                    <td><s:textfield name="personDetail.title" /></td>
                                </tr>

                                <tr>
                                    <td>First Name</td>
                                    <td><s:textfield name="personDetail.firstName" /></td>
                                </tr>
                                <tr>
                                    <td>Middle Name</td>
                                    <td><s:textfield name="personDetail.middleName" /></td>
                                </tr>
                                <tr>
                                    <td>Last Name</td>
                                    <td><s:textfield name="personDetail.lastName" /></td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td><s:textfield name="personDetail.gender" /></td>
                                </tr>
                                <tr>
                                    <td>Date Of Birth</td>
                                    <td><s:textfield name="personDetail.dateOfBirth" /></td>
                                </tr>
                                <tr>
                                    <td>Registration Date</td>
                                    <td><s:textfield name="personDetail.registrationDate" /></td>
                                </tr>
                            </table>


                            <div class="modal-footer">
                                <s:submit type="submit" value="submit" class="btn btn-primary" />
                                <s:hidden name="personDetail.personID"></s:hidden>
                                <s:hidden name="personDetail.versionNo"></s:hidden>

                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>


    <!-- *************************Code for Tabs************************************ -->

    <div class="tabbable full-width-tabs">
        <ul class="nav nav-tabs">

            <li class="active"><a data-toggle="tab" href="#PersonList">Person List</a></li>
        </ul>

        <div class="tab-content">
            <div id="PersonList" class="tab-pane fade in active">


                <!-- ************************Create New Person************************ -->

                <br />
                <div class="pull-right" class="container">

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New Person</button>

                    <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

                        <div class="modal-dialog modal-lg">

                            <div class="modal-content">

                                <div class="modal-header">

                                    <button class="close" type="button" data-dismiss="modal">&times;</button>
                                    <h3 class="modal-title">Create New Project</h3>
                                </div>

                                <div class="modal-body">

                                    <s:form class="form-inline" name="CreatePerson" namespace="/" action="CreatePersonSubmit" method="POST" role="form"
                                        theme="bootstrap">


                                        <div class="form-group">
                                            <table>

                                                <label>Name</label>
                                                <s:select list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}" name="personDetail.title"
                                                    placeholder="Title" class="form-control">

                                                </s:select>
                                                <!-- <input type="email" class="form-control" id="email" placeholder="Enter email">-->
                                                </div>

                                                <div class="form-group">
                                                    <s:textfield type="text" name="personDetail.firstName" placeholder="FirstName" class="form-control" />
                                                </div>


                                                <div class="form-group">
                                                    <s:textfield type="text" name="personDetail.middleName" placeholder="MiddleName" class="form-control" />
                                                </div>

                                                <div class="form-group">
                                                    <s:textfield type="text" name="personDetail.lastName" placeholder="LastName" class="form-control" />
                                                </div>
                                                <br>
                                                <br>

                                                <div class="form-group">
                                                    <label>DateOfBirth:</label> <input type="text" class="datepick" id="date_1" name="personDetail.dateOfBirth"
                                                        class="form-control" />

                                                </div>

                                                <%--  <s:select label="Gender" list="genderMap" name="personDetail.gender" class="form-control" /> --%>
                                                <s:radio list="{'Male','Female'}" name="personDetail.gender"></s:radio>


                                                <br>
                                                <br>

                                                <div class="form-group">
                                                    <label>UserName:</label>
                                                    <s:textfield type="text" name="personDetail.usersDetail.userName" class="form-control" />


                                                </div>

                                                <div class="form-group">
                                                    <label>Password:</label>
                                                    <s:textfield type="password" name="personDetail.usersDetail.password" class="form-control" />
                                                </div>


                                                <div class="form-group">
                                                    <label>Start Date:</label> <input type="text" class="datepick" id="date_2" name="personDetail.startDate"
                                                        class="form-control" />
                                                </div>
                                                <br />
                                                <br />

                                                <div class="form-group">
                                                    <label>End Date:</label> <input type="text" class="datepick" id="date_3" name="personDetail.endDate"
                                                        class="form-control" />
                                                </div>
                                            </table>
                                            <br />
                                            <br />


                                            <div class="modal-footer">
                                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <div class="checkbox">
                                                    <label><input type="checkbox"> Remember me</label>
                                                </div>
                                            </div>
                                    </s:form>

                                </div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>
            <br />
            <br />


            <s:form action="/ListPerson" method="post">

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
                            <th colspan=3>Action</th>
                        </tr>
                    </thead>

                    <s:iterator value="personDetailList" status="stat">

                        <tr>
                            <td><s:property value="title" /></td>
                            <td><s:property value="firstName" /></td>
                            <td><s:property value="middleName" /></td>
                            <td><s:property value="lastName" /></td>
                            <td><s:property value="gender" /></td>
                            <td><s:property value="dateOfBirth" /></td>
                            <td><s:property value="registrationDate" /></td>

                            <td><s:url var="readPersonURL" action="ReadPerson" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personID}" />
                                </s:url> <s:a href="%{readPersonURL}">View</s:a>
                                
                                 <s:url var="updatePersonURL" action="ReadPerson" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personID}" />
                                    <s:param name="act" value="%{updateAction}" />
                                </s:url> 
                                
                                <s:a href="%{updatePersonURL}">Update</s:a> <a href="#DeletePerson" data-toggle="modal">Delete</a></td>
                        </tr>
                    </s:iterator>


                </table>

            </s:form>
        </div>
    </div>

</body>
</html>