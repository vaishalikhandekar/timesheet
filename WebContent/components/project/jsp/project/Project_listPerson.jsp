
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>
<head>
<title></title>
<body>

<jsp:include page="Project_navProject.jsp"></jsp:include>
                    <!-- *******************************code to display Project List******************************* -->


                    <s:form name="ListForm" id="ListForm" method="post">

                        <div class="container">
                            <table class="table table-striped" border="1" ; width=100%>
                                <thead>

                                    <tr class="success">
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Start Date</th>
                                        <th>Role</th>
                                        <th>End Date</th>
                                        <th colspan=3>Action</th>
                                    </tr>
                                </thead>

                                <s:iterator value="projectDetailList" status="stat">

                                    <tr>
                                        <td><s:property value="projectName" /></td>
                                        <td><s:property value="recordStatus" /></td>
                                        <td><s:property value="startDate" /></td>
                                        <td><s:property value="endDate" /></td>
                                        <td><s:property value="endDate" /></td>

                                    </tr>
                                </s:iterator>

                            </table>
                        </div>

                    </s:form>

</body>
</html>