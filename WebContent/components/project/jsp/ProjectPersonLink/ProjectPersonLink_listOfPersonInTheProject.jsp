
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Insert title here</title>
    </head>
    <body>

        <jsp:include page="/components/project/jsp/project/Project_navProject.jsp"></jsp:include>

        <s:form action="/ListOfPersonInTheProject" method="post">

            <s:url id="AddPersonToProject" action="AddPersonToProject" escapeAmp="false">
                <s:param name="projectPersonLinkDetail.projectDetail.projectID" value="%{projectDetail.projectID}" />
            </s:url>
            <s:a href="%{AddPersonToProject}">Add Person</s:a>



            <table class="table table-striped">
                <thead>

                    <tr class="success">
                        <th  style="text-align: center">Project Name</th>
                        <th  style="text-align: center">Role</th>
                        <th  style="text-align: center">Employee Name</th>
                        <th  style="text-align: center">Start Date</th>
                        <th  style="text-align: center">End Date</th>
                        <th colspan=3  style="text-align: center">Action</th>
                    </tr>
                </thead>

                <s:iterator value="projectPersonLinkDetailList" status="stat">

                    <tbody>
                        <tr>
                            <td align="center">
                                <s:property value="projectName" />
                            </td>
                            <td align="center">
                                <s:property value="role" />
                            </td>
                            <td align="center">
                                <s:property value="employeeName" />
                            </td>
                            <td align="center">
                                <s:property value="startDate" />
                            </td>
                            <td align="center">
                                <s:property value="endDate" />
                            </td>

                            <!-- <td>
                                <s:url id="ViewProjectURL" action="ReadProject" escapeAmp="false">
                                <s:param name="projectDetail.projectID" value="%{projectID}"/>
                                </s:url>
                                <s:a href= "%{ViewProjectURL}">View</s:a>

                                <s:url var="updateProjectURL" action="ReadProject" escapeAmp="false">
                                <s:param name="projectDetail.projectID" value="%{projectID}"/>
                                <s:param name="act" value="%{updateAction}"/>
                                </s:url>
                                <s:a href="%{updateProjectURL}">Update</s:a>

                                <s:url id="ProjectDeleteURL" action="DeleteProject" escapeAmp="false">
                                <s:param name="projectDetail.projectID" value="%{projectID}"/>
                                </s:url>
                                <s:a href= "%{ProjectDeleteURL}">Delete</s:a>
                                </td> -->
                        </tr>
                    </tbody>
                </s:iterator>


            </table>

        </s:form>


    </body>
</html>