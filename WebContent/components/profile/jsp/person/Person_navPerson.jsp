
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style type="text/css">
img {
	float: left;
}

table {
	float: left;
}
</style>

</head>

<body>
    <!-- code for tab -->


    <div class="tabbable full-width-tabs">

        <jsp:include page="Person_userTabs.jsp" />

        <div class="tab-content">

            <div id="PersonName" class="tab-pane fade in active">

                <!-- add panel to the page -->
                <div class="panel panel-default">

                    <div class="panel-body">
                        <table style="width : 60%; height :100%" >
                            <col width="15%" />
                            <col width="45%" />
                            <tr>
                                <td width="15%">
                                    <img src="/TimeSheet/components/profile/images/user.png" class="img-rounded" alt="Cinque Terre" width="100" height="100" />
                                </td>

                                <td width="45%">
                                    <table style="width :100%; height :100%" >
                                        <tr>
                                            <th width="15%">Full Name :</th>
                                            <td width="30%">
                                                <s:property value="personDetail.firstName" />
                                                <s:property value="personDetail.lastName" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="15%">Date of Birth :</th>
                                            <td width="30%">
                                                <s:date name="personDetail.dateOfBirth" /> (
                                                <s:date name="personDetail.dateOfBirth" nice="true"/>)
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="15%">Email Address :</th>
                                            <td width="30%">
                                                <s:property value="personDetail.emailAddress" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th width="15%">Phone Number :</th>
                                            <td width="30%">
                                                <s:property value="personDetail.phoneNumber" />
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>

                </div>

                <!-- Code for NavBar -->

                <div class="bs-example">

                    <nav role="navigation" class="navbar navbar-light navbar-xs" style="background-color: #e3f2fd">

                        <%-- <div class="navbar-header">
                            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div> --%>

                        <div id="navbarCollapse" class="collapse navbar-collapse">

                            <ul class="nav navbar-nav">

                                <li class="active">
                                    <s:url var="PersonHome" action="PersonRead" namespace="/Profile">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${PersonHome}">
                                        <span class="glyphicon glyphicon-home"></span>
                                        Home
                                    </a>
                                </li>

                                <li>
                                    <s:url var="PersonProjectList" action="PersonProjectList" namespace="/Project">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${PersonProjectList}">Projects</a>
                                </li>

                                <li>
                                    <s:url var="TimeSheetsForPerson" action="TimeSheetsForPerson" namespace="/TimeSheet">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${TimeSheetsForPerson}">Time Sheets</a>
                                </li>

                                <li>
                                    <s:url var="ExpensesForPerson" action="ExpensesForPerson" namespace="/">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${ExpensesForPerson}">Expenses</a>
                                </li>

                                <li>
                                    <s:url var="ImmigrationForPerson" action="ImmigrationForPerson" namespace="/TimeSheet">
                                        <s:param name="personDetail.personID" value="%{personDetail.personID}" />
                                    </s:url>
                                    <a href="${ImmigrationForPerson}">Immigration</a>
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