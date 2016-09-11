
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <style type="text/css">
                .bs-example{
                margin: 20px;
                }
                </style> -->

</head>
<body>


    <!-- add pannel to the page -->

    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">Project Title</h3>
        </div>

        <div class="panel-body">
            <br />
            <br />
            Context Panel
        </div>
    </div>

    <!-- <ul class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">Home</a></li>
        <li><a href="#person" data-toggle="tab">Person</a></li>
        <li><a href="#team" data-toggle="tab">Team</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="home">
            Home Content

            <form action="/ListEmployee" id="login-form" method="post" name="login-form"></form>
        </div>
        <div class="tab-pane" id="person">
            Profile Content <a href="ListOfPersonInTheProject"></a>
        </div>
        <div class="tab-pane" id="team" >
        
        <a href="ListProject" id="team">Project List</a>
        
        </div>
    </div>
 -->



    <!-- Code for NavBar -->
    <div class="bs-example">
        <nav role="navigation" class="navbar navbar-light" style="background-color:#e3f2fd">
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">

                <li class="active">

                    <s:url var="ProjectHome" action="/ReadProject">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                    </s:url>
                    <a href="${ProjectHome}"><span class="glyphicon glyphicon-home"></span> Home</a>

                </li>

                <li>

                    <s:url var="ProjectPersonList" action="/ProjectPersonList">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                    </s:url>
                    <a href="${ProjectPersonList}"><span class="glyphicon glyphicon-user"></span> Person List</a>

                </li>
                
                <li>
                    <s:url var="Team" action="/ProjectPersonTeam">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                    </s:url>
                    <a href="${Team}">Team</a>
                </li>
                
                <li>
                   <s:url var="TimeSheets" action="/TimeSheets">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                    </s:url>
                    <a href="${TimeSheets}">TimeSheets</a>
                </li>
                
                <li>
                 <s:url var="TimeSheetsAdministration" action="/TimeSheetsProcess">
                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                    </s:url>
                    <a href="${TimeSheetsAdministration}">Time Sheets Process</a>
                </li>
                
            </ul>

        </div>
        </nav>
    </div>


</body>
</html>