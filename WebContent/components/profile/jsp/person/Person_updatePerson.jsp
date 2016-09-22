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
        <s:form action="/Profile/UpdatePersonSubmit" method="POST">
            <h3 class="well">Update Person</h3>


            <table>
                <tr>
                    <td>Title</td>
                    <td>
                        <s:textfield name="personDetail.title" />
                    </td>
                </tr>

                <tr>
                    <td>First Name</td>
                    <td>
                        <s:textfield name="personDetail.firstName" />
                    </td>
                </tr>
                <tr>
                    <td>Middle Name</td>
                    <td>
                        <s:textfield name="personDetail.middleName" />
                    </td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td>
                        <s:textfield name="personDetail.lastName" />
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <s:textfield name="personDetail.gender" />
                    </td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td>
                        <s:textfield name="personDetail.dateOfBirth" />
                    </td>
                </tr>
                <tr>
                    <td>Registration Date</td>
                    <td>
                        <s:textfield name="personDetail.registrationDate" />
                    </td>
                </tr>

                <s:submit type="submit" value="submit" class="btn btn-primary" />

                <s:hidden name="personDetail.personID"></s:hidden>
                <s:hidden name="personDetail.versionNo"></s:hidden>

            </table>
            <br />

        </s:form>
        <br />
    </div>

</body>
</html>