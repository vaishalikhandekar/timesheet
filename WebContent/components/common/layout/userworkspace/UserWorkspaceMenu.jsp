
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Insert title here</title>

    </head>

    <body>

        <div id="accordion" class="panel-group">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Person</a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse">
                    <div class="panel-body">

                        <br />
                        <a href="SearchEmployee">Person Search</a>
                        <br />
                        <br />
                        <a href="ListEmployee">Person List</a>

                    </div>
                </div>
            </div>


            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Project</a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <div class="panel-body">

                        <br />
                        <a href="ListProject">Project List</a>
                        <br />
                        <a href="ProjectNav">ProjectNav</a>

                    </div>
                </div>
            </div>


            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Time Sheet</a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                    <div class="panel-body">

                        <br />
                        <a href="TimeSheetList">TimeSheet List</a>
                        <br />
                        <br />
                        <a href="CreateTimeSheetLineItem">Create TimeSheetLineItem</a>

                    </div>
                </div>
            </div>

        </div>

    </body>

</html>