
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>
<head>
<title></title>

<script>
    $(function() {
        $('.datepick').each(function() {

            $(this).datepicker({

                changeMonth : true,
                changeYear : true,

            });
        });
    });
</script>

<body>
    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>

    <!-- *******************************Modal to Add Person in the Project ******************************* -->

    <div class="pull-right" class="container">

        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add Person</button>
        <br />
        <br />


        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">

                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Add Person to Project</h3>
                    </div>

                    <div class="modal-body">
                         <a href="SearchPerson">Person Search</a>
                        <s:form namespace="/" action="CreateProjectPersonLinkSubmit" method="POST" class="form-inline" theme="bootstrap">

                               <br>
                               <br>
                            <div class="form-group">
                                <label>Role:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.role" />
                            </div>
                            <br/>
                            <br/>
                            
                            <div class="form-group">
                                <label>PersonID:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.personID" />
                            </div>
                            <br/>
                            <br/>

                            <div class="form-group">
                                <label>Comments:</label> <s:textfield type="text" class="form-control" name="projectPersonLinkDetail.comments" />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>Start Date:</label> <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectPersonLinkDetail.startDate"
                                    placeholder="mm/dd/yy"  />
                            </div>
                            <br>
                            <br>

                            <div class="form-group">
                                <label>End Date:</label> <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectPersonLinkDetail.endDate"
                                    placeholder="mm/dd/yy" />
                            </div>
                            <br>
                            <br>

                            <div class="modal-footer">
                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                            <s:hidden name="projectPersonLinkDetail.projectID" value="%{projectDetail.projectID}"></s:hidden>


                        </s:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- *******************************code to display Project List******************************* -->

    <s:form name="ListForm" id="ListForm" method="post">

        <div class="container">
            <table class="table table-striped" border="1" ; width=100%>
                <thead>

                    <tr class="success">
                        <th align="center">First Name</th>
                        <th align="center">Last Name</th>
                        <th align="center">Role</th>
                    </tr>
                </thead>

                <s:iterator value="projectPersonLinkDetailList" status="stat">

                    <tr>
                        <td>
                            <s:property value="personDetail.firstName" />
                        </td>
                        <td>
                            <s:property value="personDetail.lastName" />
                        </td>
                        <td>
                            <s:property value="role" />
                        </td>

                    </tr>
                </s:iterator>

            </table>
        </div>

    </s:form>
</body>
</html>