<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1 class="well">Create New Project</h1>
	<div class="container" style="border: thin solid black">
		<br>




		<s:form class="form-inline" name="Create Project"
			action="/CreateTimeSheetLineItemSubmit" method="POST" role="form"
			theme="bootstrap">
			
			<!-- <div class="form-group">
				<label>Project:</label> <input type="text" class="form-control"
					name="" />
			</div> -->
			<br>
			
			<div class="form-group">
				<label>Start Date:</label> <input type="text" id="datepicker"
					class="dateTxt" name="timeSheetLineItemDetail.startDate" placeholder="mm/dd/yy"/>
			</div>
			<br>

			<div class="form-group">
				<label>End Date:</label> <input type="text" id="datepicker"
					class="dateTxt" name="timeSheetLineItemDetail.endDate" placeholder="mm/dd/yy"/>
			</div><br>
			
			<s:submit type="submit" id="submit" value="Submit"
				class="btn btn-primary" />
				
				
			<br><br>
			
			<table border=1>
            <thead>

                <tr>
                    <th>AttendenceDate</th>
                    <th>Day</th>
                    <th>Category</th>
                    <th>ActualRegularHoursWorked</th>
                    <th>ActualOvertimeHoursWorked</th>
                    <th>Remarks</th>
                </tr>
            </thead>

            <s:iterator value="employeeSearchResult.employeeDetailList" status="stat">

                <tbody>
                    <tr>
                        <td><s:property value="attendenceDate" /></td>
                        <td><s:property value="day" /></td>
                        <td><s:property value="category" /></td>
                        <td><s:property value="actualRegularHoursWorked" /></td>
                        <td><s:property value="actualOvertimeHoursWorked" /></td>
                        <td><s:property value="comments" /></td>
                    </tr>
                </tbody>
            </s:iterator>


        </table>
    
		<br>
			<br>

			<s:submit type="submit" id="submit" value="Submit"
				class="btn btn-primary" />

		</s:form>
	</div>
</body>
</html>