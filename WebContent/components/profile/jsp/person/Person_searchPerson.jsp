
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

            <li class="active"><a data-toggle="tab" href="#PersonSearch">Search Person</a></li>
        </ul>

        <div class="tab-content">

            <div id="PersonSearch" class="tab-pane fade in active">

                <div class="container">

                    <s:form action="/SearchPersonSubmit" method="POST" class="form-inline" theme="bootstrap">
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

                        <table class="table table-striped">

                            <thead>
                                <tr>
                                    <th>Title</th>
                                    <th>First Name</th>
                                    <th>Middle Name</th>
                                    <th>Last Name</th>
                                    <th>Gender</th>
                                    <th>Date Of Birth</th>
                                </tr>
                            </thead>

                            <s:iterator value="personSearchResult.personDetailList" status="stat">

                                <tr>
                                    <td><s:property value="title" /></td>
                                    <td><s:property value="firstName" /></td>
                                    <td><s:property value="middleName" /></td>
                                    <td><s:property value="lastName" /></td>
                                    <td><s:property value="gender" /></td>
                                    <td><s:property value="dateOfBirth" /></td>
                                </tr>

                            </s:iterator>

                            <s:hidden name="personDetail.personID" />
                        </table>

                    </s:form>

                </div>

            </div>

        </div>

    </div>

</body>

</html>