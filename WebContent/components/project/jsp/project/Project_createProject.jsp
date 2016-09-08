<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>

<html lang="en">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <div class="container">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Open Modal</button>
        <div class="modal" id="modal-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Create New Project</h3>
                    </div>

                    <div class="modal-body">




                        <s:form class="form-inline" name="Create Project" action="/CreateProjectSubmit" method="POST" role="form" theme="bootstrap">

                            <br>
                            <div class="form-group">
                                <label>Project Name:</label>
                                <input type="text" class="form-control" name="projectDetail.projectName" />
                            </div>
                           
                            <br/>

                            <div class="form-group">
                                <label>Description:</label>
                                <input type="text" class="form-control" name="projectDetail.description" />
                            </div>
                            <br>

                            <div class="form-group">
                                <label>Start Date:</label> <input type="text" class="form-control" class="dateTxt" name="projectDetail.startDate"
                                    placeholder="mm/dd/yy"  />
                            </div>
                            <br>

                            <div class="form-group">
                                <label>End Date:</label> <input type="text" class="form-control" class="dateTxt" name="projectDetail.endDate"
                                    placeholder="mm/dd/yy" />
                            </div>

                            <br>
                            <br>
                            
                            
                            

                            <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                        </s:form>





                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>

                </div>

            </div>

        </div>

    </div>


    <h1 class="well">Create New Project</h1>
    <div class="container" style="border: thin solid black">
        <br>





    </div>
</body>
</html>