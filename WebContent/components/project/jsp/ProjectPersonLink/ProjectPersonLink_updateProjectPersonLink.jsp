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
    
        <s:form action="/UpdateProjectPersonLinkSubmit" namespace="/Project" method="POST">
            <h3 class="well">Update Project</h3>

            <table style="width: 100%;">
                <col width="20%" />
                <col width="30%" />
                <col width="20%" />
                <col width="30%" />

                <tr>
                    <th>Role :</th>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.role" theme="simple"/>
                    </td>
                    <th>Comments :</th>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.comments" theme="simple"/>
                    </td>
                </tr>

                <tr class="break">
                    <td colspan="2"></td>
                </tr>

                <tr>
                    <th>Start Date</th>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.startDate" theme="simple"/>
                    </td>
                    <th>End Date</th>
                    <td>
                        <s:textfield name="projectPersonLinkDetail.endDate" theme="simple"/>
                    </td>
                </tr>


                <s:submit type="submit" value="submit" class="btn btn-primary" />
                <s:hidden name="projectPersonLinkDetail.projectPersonLinkID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.personID"></s:hidden>
                <s:hidden name="projectPersonLinkDetail.versionNo"></s:hidden>


            </table>

        </s:form>
        
    </div>


</body>
</html>