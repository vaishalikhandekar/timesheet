<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body><br>



       
			<a href="SearchEmployee">Search Employee</a><br><br><br>
		    
    <s:form action="/CreateProjectPersonLinkSubmit" method="POST">
    
    		
			<br>
			
   			 <div class="form-group">
				<label>Role:</label> <input type="text" class="form-control"
					name="projectPersonLinkDetail.role" />
			</div>
			<br>

			<div class="form-group">
				<label>Comments:</label> <input type="text" class="form-control"
					name="projectPersonLinkDetail.comments" />
			</div>
			<br>

			<div class="form-group">
				<label>Start Date:</label> <input type="text" id="datepicker"
					class="dateTxt" name="projectPersonLinkDetail.startDate" placeholder="mm/dd/yy"/>
			</div>
			<br>

			<div class="form-group">
				<label>End Date:</label> <input type="text" id="datepicker"
					class="dateTxt" name="projectPersonLinkDetail.endDate" placeholder="mm/dd/yy"/>
			</div>

			<br>
			<br>

				<s:hidden name="projectPersonLinkDetail.projectDetail.projectID"></s:hidden>
				
			<s:submit type="submit" id="submit" value="Submit"
				class="btn btn-primary" />
    
    
    </s:form>
 
			

     


		
</body>
</html>