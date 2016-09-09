
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

    <div class="tabbable full-width-tabs">
        <ul class="nav nav-tabs">

            <li class="active">
                <a data-toggle="tab" href="#PersonList">Person Name</a>
            </li>
        </ul>

        <div class="tab-content">
            <div id="PersonList" class="tab-pane fade in active">

                <!-- add pannel to the page -->
                <div class="panel panel-primary">

                    <div class="panel-heading">
                        <h3 class="panel-title"></h3>
                    </div>

                    <div class="panel-body">
                        <img src="/image/RunAppDownload.jpg" class="img-rounded" alt="Cinque Terre" width="150" height="150"> 
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
                    <nav role="navigation" class="navbar navbar-light" style="background-color: #e3f2fd">
                        <div class="navbar-header">
                            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                                    class="icon-bar"></span>
                            </button>
                        </div>
                        <div id="navbarCollapse" class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">

                                <li class="active">
                                    <s:url var="PersonHome" action="/ReadPerson">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${PersonHome}">
                                        <span class="glyphicon glyphicon-home"></span> Home
                                    </a>
                                </li>

                                <li>
                                    <s:url var="PersonProjectList" action="/PersonProjectList">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${PersonProjectList}">Projects</a>
                                </li>

                                <li>
                                    <s:url var="TimeSheetList" action="/PersonTimeSheetList">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${TimeSheetList}">Time Sheets</a>
                                </li>

                            </ul>

                        </div>
                    </nav>
                </div>

            </div>
        </div>
    </div>

</body>
</html>