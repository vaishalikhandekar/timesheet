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
    <s:form action="/UpdateProjectPersonLinkSubmit" method="POST">
        <h3 class="well">Update Project</h3>

        <table style="width: 100%;">
            <col width="20%" />
            <col width="30%" />
            <col width="20%" />
            <col width="30%" />

            <tr>
                <th>Role :</th>
                <td>
                    <input name="projectPersonLinkDetail.role" />
                </td>
                <th>Comments :</th>
                <td>
                    <input name="projectPersonLinkDetail.comments" />
                </td>
            </tr>

            <tr class="break">
                <td colspan="2"></td>
            </tr>

            <tr>
                <th>Start Date</th>
                <td>
                    <input name="projectPersonLinkDetail.startDate" />
                </td>
                <th>End Date</th>
                <td>
                    <input name="projectPersonLinkDetail.endDate" />
                </td>
            </tr>


                    <s:submit type="submit" value="submit" class="btn btn-primary"/>
                    <s:hidden name="projectPersonLinkDetail.projectPersonLinkID"></s:hidden>
                    <s:hidden name="projectPersonLinkDetail.personID"></s:hidden>
                    <s:hidden name="projectPersonLinkDetail.versionNo"></s:hidden>


        </table>

    </s:form>
</div>


</body>
</html>