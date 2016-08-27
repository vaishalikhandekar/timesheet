<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function () {
    $('#datetimepicker1').datetimepicker();
});
</script>

</head>
<body>
	<!-- <h1 class="well">Registration Form</h1>
	<div class="container" style="border: thin solid black"> -->
		<br>

		<div class="modal fade" id="modal-1" data-keyboard="false"
				data-backdrop="static">
				
					<div class="modal-dialog modal-lg">
				
						<div class="modal-content">
					
							<div class="modal-header">
							
								<button class="close" type="button" data-dismiss="modal">&times;</button>
										<h3 class="modal-title">Create New Project</h3>
						</div>

						<div class="modal-body">

		<s:form class="form-inline" name="Registration"
			action="/CreateEmployeeSubmit" method="POST" role="form"
			theme="bootstrap">

			<div class="form-group">

				<label>Name:</label>
				<s:select
					list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}"
					name="employeeDetail.title" placeholder="Title"
					class="form-control">
				</s:select>
				<!-- <input type="email" class="form-control" id="email" placeholder="Enter email">-->
			</div>

			<div class="form-group">
				<s:textfield type="text" name="employeeDetail.firstName"
					placeholder="FirstName" class="form-control" />
			</div>


			<div class="form-group">
				<s:textfield type="text" name="employeeDetail.middleName"
					placeholder="MiddleName" class="form-control" />
			</div>

			<div class="form-group">
				<s:textfield type="text" name="employeeDetail.lastName"
					placeholder="LastName" class="form-control" />
			</div>
			<br>
			<br>

			<%--  <s:select label="Gender" list="genderMap" name="employeeDetail.gender" class="form-control" /> --%>
			<s:radio list="{'Male','Female'}" name="employeeDetail.gender"></s:radio>



			<div class="form-group">
				<label>DateOfBirth:</label> <input type="text" id="datepicker"
					class="datetimepicker1"  placeholder="mm/dd/yy" name="employeeDetail.dateOfBirth" />
			</div>
			<br>
			<br>

			<div class="form-group">
				<label>UserName:</label>
				<s:textfield type="text" name="employeeDetail.usersDetail.userName"
					class="form-control" />
			</div>

			<div class="form-group">
				<label>Password:</label>
				<s:textfield type="password" name="employeeDetail.usersDetail.password"
					class="form-control" />
			</div>
			
			
			<div class="form-group">
				<label>Start Date:</label>
				<s:textfield type="text" name="employeeDetail.startDate"
					class="form-control" />
			</div>

			<div class="form-group">
				<label>End Date:</label> <input type="text" id="datepicker"
					class="dateTxt" name="employeeDetail.endDate" />
			</div>
			

			<br>
			<br>
			<br>
			<br>
						<div class="modal-footer">
							<s:submit type="submit" id="submit" value="Submit"
								class="btn btn-primary" />
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
	</s:form>

	</div>

	</div>

	</div>
	</div>
	
			
			
			
			<%-- <s:submit type="submit" id="submit" value="Submit"
				class="btn btn-primary" />
			<div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			</div>
		</s:form> --%>

		<s:form action="/TimeSheet/EmployeeLogOut" method="POST">
			<br>
			<%-- <s:submit type="submit" value="Cancel" class="btn btn-primary" /> --%>
		</s:form>
</body>
</html>