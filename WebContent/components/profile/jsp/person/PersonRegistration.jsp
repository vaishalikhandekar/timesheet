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
	<h3 class="well">Registration Form</h3>
	<div class="container" style="border: thin solid black"> 
		<br>

		<!-- <div class="modal fade" id="modal-1" data-keyboard="false"
				data-backdrop="static">
				
					<div class="modal-dialog modal-lg">
				
						<div class="modal-content">
					
							<div class="modal-header">
							
								<button class="close" type="button" data-dismiss="modal">&times;</button>
										<h3 class="modal-title">Create New Project</h3>
						</div>

						<div class="modal-body"> -->

		<s:form class="form-inline" name="Registration"
			action="/CreatePersonSubmit" method="POST" role="form"
			theme="bootstrap">

            <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
			<div class="form-group">

				<label>Name<span class="glyphicon glyphicon-asterisk-ok icon-red"></span></label>
				<s:select
					list="#{'Mr.':'Mr.', 'Mrs.':'Mrs.','Miss.':'Miss.', 'Kumar':'Kumar'}"
					name="personDetail.title" placeholder="Title"
					class="form-control" >
                    <span class="glyphicon glyphicon-asterisk"></span>
				</s:select>
				<!-- <input type="email" class="form-control" id="email" placeholder="Enter email">-->
			</div>

			<div class="form-group">
				<s:textfield type="text" name="personDetail.firstName"
					placeholder="FirstName" class="form-control" />
			</div>


			<div class="form-group">
				<s:textfield type="text" name="personDetail.middleName"
					placeholder="MiddleName" class="form-control" />
			</div>

			<div class="form-group">
				<s:textfield type="text" name="personDetail.lastName"
					placeholder="LastName" class="form-control" />
			</div>
			<br>
			<br>
            
			<div class="form-group">
				<label>DateOfBirth:</label> 
                <s:textfield type="text" name="personDetail.dateOfBirth"
                    class="form-control" placeholder="mm/dd/yy"/>
           
			</div>

			<%--  <s:select label="Gender" list="genderMap" name="personDetail.gender" class="form-control" /> --%>
			<s:radio list="{'Male','Female'}" name="personDetail.gender"></s:radio>


			<br>
			<br>

			<div class="form-group">
				<label>UserName:</label>
				<s:textfield type="text" name="personDetail.usersDetail.userName"
					class="form-control" />
                    
                    
			</div>

			<div class="form-group">
				<label>Password:</label>
				<s:textfield type="password" name="personDetail.usersDetail.password"
					class="form-control" />
			</div>
			
			
			<div class="form-group">
				<label>Start Date:</label>
				<s:textfield type="text" name="personDetail.startDate"
					class="form-control" placeholder="mm/dd/yy"/>
			</div>
            
			<div class="form-group">
				<label>End Date:</label>
				<s:textfield type="text" name="personDetail.endDate"
					class="form-control" placeholder="mm/dd/yy"/>
			</div>

			
			

			<br>
			<br>
			<br>
			<br>
						

			
			
			<s:submit type="submit" id="submit" value="Register"
				class="btn btn-primary" />
			<div class="checkbox">
				<label><input type="checkbox"> Remember me</label>
			</div>
		</s:form>

		<!-- <s:form action="/TimeSheet/personLogOut" method="POST" class="form-inline">
			<br>
			 <s:submit type="submit" value="Cancel" class="btn btn-primary" /> 
		</s:form> -->
        <br/>
	</div>
</body>
</html>