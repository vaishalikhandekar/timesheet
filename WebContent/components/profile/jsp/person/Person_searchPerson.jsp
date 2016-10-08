
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>

<body>

    <!-- HEADER SECTION -->
    <div id="top">

        <%@ include file="/components/core/jsp/header.jsp"%>
    </div>
    <!-- END HEADER SECTION -->



    <!-- MENU SECTION -->
    <div id="left">
        <%@ include file="/components/core/jsp/menu.jsp"%>

    </div>
    <!--END MENU SECTION -->



    <!--PAGE CONTENT -->
    <div id="content">

        <div class="inner">
            <div class="row">
                <div class="col-lg-12"></div>
            </div>



                            <jsp:include page="Person_userTabs.jsp"></jsp:include>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">Person Search</div>
                        <div class="panel-body">


                            <div class="tabbable full-width-tabs">


                                <div class="tab-content">

                                    <div id="PersonSearch" class="tab-pane fade in active">

                                        <div class="container">

                                            <s:form action="/Profile/PersonSearchSubmit" method="POST" class="form-inline" theme="bootstrap">
                                                <h4 class="well well-sm">Search Criteria</h4>

                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <s:textfield type="text" name="personSearchDetails.personSearchCriteria.firstName" class="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Middle Name</label>
                                                    <s:textfield type="text" name="personSearchDetails.personSearchCriteria.middleName" class="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <s:textfield type="text" name="personSearchDetails.personSearchCriteria.lastName" class="form-control" />
                                                </div>

                                                <div>
                                                    <input type="submit" value="Submit">
                                                </div>
                                                <br />
                                                <br />

                                                <table class="table table-striped" id="dataTables-example">

                                                    <thead>
                                                        <tr>
                                                            <th style="text-align: center">Title</th>
                                                            <th style="text-align: center">First Name</th>
                                                            <th style="text-align: center">Middle Name</th>
                                                            <th style="text-align: center">Last Name</th>
                                                            <th style="text-align: center">Gender</th>
                                                            <th style="text-align: center">Date Of Birth</th>
                                                        </tr>
                                                    </thead>

                                                    <s:iterator value="personSearchResult.personDetailList" status="stat">

                                                        <tr>
                                                            <td align="center">
                                                                <s:property value="title" />
                                                            </td>
                                                            <td align="center">
                                                                <s:property value="firstName" />
                                                            </td>
                                                            <td align="center">
                                                                <s:property value="middleName" />
                                                            </td>
                                                            <td align="center">
                                                                <s:property value="lastName" />
                                                            </td>
                                                            <td align="center">
                                                                <s:property value="gender" />
                                                            </td>
                                                            <td align="center">
                                                                <s:property value="dateOfBirth" />
                                                            </td>
                                                        </tr>

                                                    </s:iterator>

                                                    <s:hidden name="personDetail.personID" />
                                                </table>

                                            </s:form>

                                        </div>

                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!-- FOOTER -->
    <div id="footer">
        <%@ include file="/components/core/jsp/footer.jsp"%>
    </div>
    <!--END FOOTER -->

</body>

</html>