
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
  $( function() {
    $( "#accordion" ).accordion({
      collapsible: true
    });
  } );
</script>

</head>

<body>

    <div id="accordion">
        <h1>Person</h1>
        <div>
            <br /> <a href="SearchPerson">Person Search</a> <br /> <br /> <a href="ListPerson">Person List</a>
        </div>

        <h1>Project</h1>
        <div>

            <br /> <a href="ListProject">Project List</a> <br /> <br /> <a href="ProjectNav">ProjectNav</a>

        </div>

        <h1>Time Sheet</h1>
        <div>

            <br /> <a href="TimeSheetList">TimeSheet List</a> <br /> <br /> <a href="CreateTimeSheetLineItem">Create TimeSheetLineItem</a>

        </div>

    </div>


    <!-- <div class="panel panel-default">
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
        
        -->

</body>

</html>