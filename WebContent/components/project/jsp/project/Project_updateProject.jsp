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

    <div class="container" style="border: thin solid black">

        <s:form action="/ProjectUpdateSubmit" namespace="/Project" method="POST">
            <h3 class="well">Update Project</h3>

            <table style="width: 100%;">
                <col width="20%" />
                <col width="30%" />
                <col width="20%" />
                <col width="30%" />

                <tr>
                    <th>Project Name :</th>
                    <td>
                        <input name="projectDetail.projectName" />
                    </td>
                    <th>Description :</th>
                    <td>
                        <input name="projectDetail.description" />
                    </td>
                </tr>

                <tr class="break">
                    <td colspan="2"></td>
                </tr>

                <tr>
                    <th>Comments :</th>
                    <td>
                        <input name="projectDetail.comments" />
                    </td>
                    <th>Start Date :</th>
                    <td>
                        <input name="projectDetail.startDate" />
                    </td>
                </tr>
                <tr>
                    <th>End Date :</th>
                    <td>
                        <input name="projectDetail.endDate" />
                    </td>
                </tr>


                <s:submit type="submit" value="submit" class="btn btn-primary" />
                <s:hidden name="projectDetail.projectID"></s:hidden>
                <s:hidden name="projectDetail.versionNo"></s:hidden>
            </table>
            <br />

        </s:form>
    </div>
    <br />

</body>
</html>