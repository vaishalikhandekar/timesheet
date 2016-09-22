
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

        <%-- <ul class="nav nav-tabs">

            <li class="active">
                <a data-toggle="tab" href="#PersonName">
                    <s:property value="personDetail.firstName" />
                    &nbsp;
                    <s:property value="personDetail.lastName" />
                </a>
            </li>

        </ul> --%>

        <jsp:include page="Person_userTabs.jsp"></jsp:include>

        <div class="tab-content">

            <div id="PersonName" class="tab-pane fade in active">


                <!-- add pannel to the page -->
                <div class="panel panel-info">

                    <div class="panel-heading">
                        <h3 class="panel-title"></h3>
                    </div>

                    <div class="panel-body">
                        <table>
                       <col width="20%" />
                       <col width="80%" />
                            <tr>
                                <td width="45%">
                                    <img src="/TimeSheet/components/profile/images/user.png" class="img-rounded" alt="Cinque Terre" width="100" height="100" />
                                </td>

                                <td width="45%">
                                    <table>
                                        <tr>
                                            <th>Full Name :</th>
                                            <td>

                                                <s:property value="personDetail.firstName" />

                                                <s:property value="personDetail.lastName" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Email Address :</th>
                                            <td>
                                                <s:property value="personDetail.emailAddress" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <th>Phone Number:</th>
                                            <td>
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

                    <nav role="navigation" class="navbar navbar-light" style="background-color: #e3f2fd">

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

                            </ul>

                        </div>

                    </nav>

                </div>

            </div>

        </div>

    </div>

</body>

</html>