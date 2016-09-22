<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>

    <div class="container" style="border: thin solid black">

        <s:form action="/UpdatePersonFromProjectSubmit" namespace="/Project" method="POST">
            <h3 class="well">Update Person</h3>


            <table>
                <tr>
                    <td>Title</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.title" />
                    </td>
                </tr>

                <tr>
                    <td>First Name</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.firstName" />
                    </td>
                </tr>
                <tr>
                    <td>Middle Name</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.middleName" />
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.lastName" />
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.gender" />
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.dateOfBirth" />
                    </td>
                </tr>
                <tr>
                    <td>Registration Date</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.personDetail.registrationDate" />
                    </td>
                </tr>
                <tr>
                    <td>Role</td>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.role" />
                    </td>
                </tr>

                <s:submit type="submit" value="submit" class="btn btn-primary" />

                <s:hidden name="projectPersonLinkDetail.projectPersonLinkID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.projectID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.personDetail.personID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.personDetail.versionNo"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.projectDetail.projectID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.versionNo"></s:hidden>

            </table>
            <br />

        </s:form>
        <br />
    </div>

</body>
</html>