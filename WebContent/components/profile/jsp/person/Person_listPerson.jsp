
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
tr.break td {
	height: 10px;
}
</style>

<script type="text/javascript">
	$('#DeletePerson').on('show.bs.modal', function(e) {

		//get data-id attribute of the clicked element
		var personID = $(this).data('personID');
		$(".modal-body #personID").val(personID);

	});
</script>

<script>
	$(document).ready(function() {
		$(".deletePer").click(function() { // Click to only happen on announce links
			$("#personDetail.personID").val($(this).data('id'));
			$('#DeletePerson').modal('show');
		});
	});
</script>

<script>
	$(document).ready(function() {
		$('#DeletePerson').on('show.bs.modal', function(event) {
			$("#personDetail.personID").val($(event.relatedTarget).data('id'));
		});
	});
</script>

<script>
	$(function() {
		$('.datepick').each(function() {

			$(this).datepicker({

				changeMonth : true,
				changeYear : true,

			});
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

                        <s:form class="form-inline" name="DeletePerson" namespace="/Profile" action="PersonDelete" method="POST" role="form" theme="bootstrap">

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
                        <s:form class="form-inline" name="UpdatePerson" action="PersonUpdateSubmit" method="POST" namespace="/Profile" role="form"
                            theme="bootstrap">

                            <table>
                                <tr>
                                    <td>Title</td>
                                    <td>
                                        <s:textfield name="personDetail.title" />
                                    </td>
                                </tr>

                                <tr>
                                    <td>First Name</td>
                                    <td>
                                        <s:textfield name="personDetail.firstName" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Middle Name</td>
                                    <td>
                                        <s:textfield name="personDetail.middleName" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Last Name</td>
                                    <td>
                                        <s:textfield name="personDetail.lastName" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Gender</td>
                                    <td>
                                        <s:textfield name="personDetail.gender" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Date Of Birth</td>
                                    <td>
                                        <s:textfield name="personDetail.dateOfBirth" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>Registration Date</td>
                                    <td>
                                        <s:textfield name="personDetail.registrationDate" />
                                    </td>
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

            <li class="active">
                <a data-toggle="tab" href="#PersonList">Person List</a>
            </li>
        </ul>

        <div class="tab-content">

            <div id="PersonList" class="tab-pane fade in active">

                <!-- ************************Create New Person************************ -->

                <div class="pull-right" class="container">

                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">New Person</button>

                    <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

                        <div class="modal-dialog modal-lg">

                            <div class="modal-content">

                                <div class="modal-header">

                                    <button class="close" type="button" data-dismiss="modal">&times;</button>
                                    <h3 class="modal-title">New Person</h3>
                                </div>

                                <div class="modal-body">

                                    <s:form class="form-inline" name="PersonCreate" namespace="/Profile" action="PersonCreateSubmit" method="POST" role="form"
                                        theme="bootstrap">

                                        <table style="width: 100%;">
                                            <col width="20%" />
                                            <col width="30%" />
                                            <col width="20%" />
                                            <col width="30%" />

                                            <tr>
                                                <th>Name</th>
                                                <td>
                                                    <select name="personDetail.title">
                                                        <option value="Mr.">Mr.</option>
                                                        <option value="Mrs.">Mrs.</option>
                                                        <option value="Miss.">Miss.</option>
                                                        <option value="Kumar">Kumar</option>
                                                    </select>
                                                </td>
                                                <th>First Name</th>
                                                <td>
                                                    <input type="text" name="personDetail.firstName" />
                                                </td>
                                            </tr>
                                            <tr class="break">
                                                <td colspan="2"></td>
                                            </tr>

                                            <tr>
                                                <th>Middle Name</th>
                                                <td>
                                                    <input type="text" name="personDetail.middleName" />
                                                </td>

                                                <th>Last Name</th>
                                                <td>
                                                    <input type="text" name="personDetail.lastName" />
                                                </td>
                                            </tr>
                                            <tr class="break">
                                                <td colspan="2"></td>
                                            </tr>

                                            <tr>
                                                <th>DateOfBirth:</th>
                                                <td>
                                                    <input type="text" class="datepick" id="date_1" name="personDetail.dateOfBirth" />
                                                </td>


                                                <th>Gender</th>
                                                <td>
                                                    <input type="radio" name="personDetail.gender" value="male">Male <input type="radio"
                                                        name="personDetail.gender" value="female">Female
                                                </td>
                                            </tr>
                                            <tr class="break">
                                                <td colspan="2"></td>
                                            </tr>

                                            <tr>
                                                <th>UserName:</th>
                                                <td>
                                                    <input type="text" name="personDetail.usersDetail.userName" />
                                                </td>


                                                <th>Password:</th>
                                                <td>
                                                    <input type="password" name="personDetail.usersDetail.password" />
                                                </td>

                                            </tr>
                                            <tr class="break">
                                                <td colspan="2"></td>
                                            </tr>
                                            <tr>

                                                <th>Start Date:</th>
                                                <td>
                                                    <input type="text" class="datepick" id="date_2" name="personDetail.startDate" />
                                                </td>

                                                <th>End Date:</th>
                                                <td>
                                                    <input type="text" class="datepick" id="date_3" name="personDetail.endDate" />
                                                </td>
                                            </tr>
                                            <tr class="break">
                                                <td colspan="2"></td>
                                            </tr>

                                            <tr>
                                                <th>Email Address:</th>
                                                <td>
                                                    <input type="text" name="personDetail.emailAddress" />
                                                </td>

                                                <th>Phone Number:</th>
                                                <td>
                                                    <input type="text" name="personDetail.phoneNumber" />
                                                </td>

                                            </tr>
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

            <s:form action="/Profile/PersonList" method="post">

                <table class="table table-striped" border="1">

                    <thead>

                        <tr bgcolor="#FFA500">
                            <!-- <tr class="success"> -->
                            <th style="text-align: center">Action</th>
                            <th style="text-align: center">Title</th>
                            <th style="text-align: center">First Name</th>
                            <th style="text-align: center">Middle Name</th>
                            <th style="text-align: center">Last Name</th>
                            <th style="text-align: center">Gender</th>
                            <th style="text-align: center">Date Of Birth</th>
                            <th style="text-align: center">Registration Date</th>
                        </tr>

                    </thead>

                    <s:iterator value="personDetailList" status="stat">

                        <tr>

                            <td align="center">

                                <s:url var="readPersonURL" action="PersonRead" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personID}" />
                                </s:url>
                                <s:a href="%{readPersonURL}">
                                    <span class="glyphicon glyphicon-eye-open"></span>
                                    <!-- View -->
                                </s:a>
                                &nbsp;&nbsp;

                                <s:url var="updatePersonURL" action="PersonRead" escapeAmp="false">
                                    <s:param name="personDetail.personID" value="%{personID}" />
                                    <s:param name="act" value="%{updateAction}" />
                                    <s:param name="returnFrom" value="%{returnPage}" />
                                </s:url>
                                <s:a href="%{updatePersonURL}">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                    <!-- Update -->
                                </s:a>
                                &nbsp;&nbsp;

                                <a href="#DeletePerson" data-toggle="modal">
                                    <span class="glyphicon glyphicon-trash"></span>
                                    <!-- Delete -->
                                </a>

                                &nbsp;&nbsp;

                                <a class="btn btn-primary deletePer" data-toggle="modal" data-id="%{personID}">
                                    <span class="glyphicon glyphicon-trash"> ND</span>
                                </a>

                            </td>

                            <td align="center">
                                <s:property value="title" />
                            </td>

                            <td align="center">
                                <s:property value="firstName" />
                            </td>

                            <td align="center">
                                <s:property value="middleName" />
                            </td>

                            <td align="center">
                                <s:property value="lastName" />
                            </td>

                            <td align="center">
                                <s:property value="gender" />
                            </td>

                            <td align="center">
                                <s:property value="dateOfBirth" />
                            </td>

                            <td align="center">
                                <s:property value="registrationDate" />
                            </td>

                        </tr>

                    </s:iterator>

                </table>

            </s:form>

        </div>

    </div>

</body>
</html>