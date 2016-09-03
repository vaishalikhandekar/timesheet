
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Insert title here</title>
    </head>
    <body>

        <jsp:include page="/components/project/jsp/project/ProjectNav.jsp"></jsp:include>

        <s:form action="/ListOfPersonInTheProject" method="post">

            <s:url id="AddPersonToProject" action="AddPersonToProject" escapeAmp="false">
                <s:param name="projectPersonLinkDetail.projectDetail.projectID" value="%{projectDetail.projectID}" />
            </s:url>
            <s:a href="%{AddPersonToProject}">Add Person</s:a>



            <table class="table table-striped">
                <thead>

                    <tr>
                        <th align="left">Project Name</th>
                        <th>Role</th>
                        <th>Employee Name</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th colspan=3>Action</th>
                    </tr>
                </thead>

                <s:iterator value="projectPersonLinkDetailList" status="stat">

                    <tbody>
                        <tr>
                            <td>
                                <s:property value="projectName" />
                            </td>
                            <td>
                                <s:property value="role" />
                            </td>
                            <td>
                                <s:property value="employeeName" />
                            </td>
                            <td>
                                <s:property value="startDate" />
                            </td>
                            <td>
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