
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="en">
    <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
                <html>
                    <head>
                        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                            <title>Time Sheet List</title>
                    </head>
                    <body>

                        <jsp:include page="ProjectNav.jsp"></jsp:include>


                        <s:form action="/ReadProject" method="post">
                            <br>
                                <br>


                                    <table class="table table-striped">
                                        <thead>

                                            <tr>
                                                <th>Project Name</th>
                                                <th>Description</th>
                                                <th>Record Status</th>
                                                <th>Start Date</th>
                                                <th>End Date</th>
                                            </tr>
                                        </thead>



                                        <tbody>
                                            <tr>
                                                <td>
                                                    <s:property value="projectDetail.projectName" />
                                                </td>
                                                <td>
                                                    <s:property value="projectDetail.description" />
                                                </td>
                                                <td>
                                                    <s:property value="projectDetail.recordStatus" />
                                                </td>
                                                <td>
                                                    <s:property value="projectDetail.startDate" />
                                                </td>
                                                <td>
                                                    <s:property value="projectDetail.endDate" />
                                                </td>

                                            </tr>
                                            <s:hidden name="projectDetail.projectID"></s:hidden>
                                        </tbody>


                                    </table>
                                    <br>


                        </s:form>

                    </div>
                    </body>
                </html>