
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>
<head>
<title></title>
<body>

    <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>
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
                        <td><s:property value="personDetail.firstName" /></td>
                        <td><s:property value="personDetail.lastName" /></td>
                        <td><s:property value="role" /></td>

                    </tr>
                </s:iterator>

            </table>
        </div>

    </s:form>

</body>
</html>