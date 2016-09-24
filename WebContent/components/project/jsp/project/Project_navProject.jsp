
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>

    <div class="tabbable full-width-tabs">

        <ul class="nav nav-tabs">

            <li class="active">
                <a data-toggle="tab" href="#ProjectName">Project Name</a>
            </li>

        </ul>

        <div class="tab-content">

            <div id="ProjectName" class="tab-pane fade in active">

                <!-- add pannel to the page -->

                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            <s:property value="projectDetail.projectName" />
                        </h3>
                    </div>

                    <div class="panel-body">
                        <br />
                        <br />
                    </div>
                </div>


                <!-- Code for NavBar -->
                <div class="bs-example">
                    <nav role="navigation" class="navbar navbar-light" style="background-color: #e3f2fd">
                        <div class="navbar-header">
                            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <div id="navbarCollapse" class="collapse navbar-collapse">
                            <ul class="nav navbar-nav">

                                <li class="active">

                                    <s:url var="ProjectHome" action="ProjectRead" namespace="/Project">
                                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                                    </s:url>
                                    <a href="${ProjectHome}">
                                        <span class="glyphicon glyphicon-home"></span>
                                        Home
                                    </a>

                                </li>

                                <li>

                                    <s:url var="ProjectPersonList" action="ProjectPersonList" namespace="/Project">
                                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                                    </s:url>
                                    <a href="${ProjectPersonList}">
                                        <span class="glyphicon glyphicon-user"></span>
                                        Persons
                                    </a>

                                </li>

                                <li>
                                    <s:url var="ProjectTeams" action="ProjectTeams" namespace="/Project">
                                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                                    </s:url>
                                    <a href="${ProjectTeams}">Teams</a>
                                </li>

                                <li>
                                    <s:url var="TimeSheetsForProject" action="TimeSheetsForProject" namespace="/TimeSheet">
                                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                                    </s:url>
                                    <a href="${TimeSheetsForProject}">Time Sheets</a>
                                </li>

                                <li>
                                    <s:url var="ProjectTimeSheetsProcessList" action="ProjectTimeSheetsProcessList" namespace="/TimeSheet">
                                        <s:param name="projectDetail.projectID" value="%{projectDetail.projectID}" />
                                    </s:url>
                                    <a href="${ProjectTimeSheetsProcessList}">Time Sheet Process</a>
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