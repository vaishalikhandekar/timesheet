<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style type="text/css">
tr.break td {
	height: 10px;
}
</style>
</head>
<body>

<br/>
    <div class="container" style="border: thin solid black">
        <s:form action="/Profile/UpdatePersonSubmit" method="POST">
            <h4 class="well well-sm">Update Person</h4>

            <table style="width: 100%;">
                <col width="20%" />
                <col width="30%" />
                <col width="20%" />
                <col width="30%" />

                <tr>
                    <th>Title :</th>
                    <td>
                        <input name="personDetail.title" />
                    </td>
                    <th>First Name :</th>
                    <td>
                        <input name="personDetail.firstName" />
                    </td>
                </tr>

                <tr class="break">
                    <td colspan="2"></td>
                </tr>

                <tr>
                    <th>Middle Name :</th>
                    <td>
                        <input name="personDetail.middleName" />
                    </td>
                    <th>Last Name :</th>
                    <td>
                        <input name="personDetail.lastName" />
                    </td>
                </tr>

                <tr class="break">
                    <td colspan="2"></td>
                </tr>

                <tr>
                    <th>Gender :</th>
                    <td>
                        <input name="personDetail.gender" />
                    </td>
                    <th>Date Of Birth :</th>
                    <td>
                        <input name="personDetail.dateOfBirth" />
                    </td>
                </tr>

                <tr class="break">
                    <td colspan="2"></td>
                </tr>

                <tr>
                    <th>Registration Date :</th>
                    <td>
                        <input name="personDetail.registrationDate" />
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