
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>

<!-- Script for delete -->
<script type="text/javascript">
	$.fx.speeds._default = 1000;
	$(function() {

		$("#deleteProjectID").click(function() {
			$("#deleteProjectID-model").dialog("open");
			return false;
		});

		$("#deleteProjectID-model").dialog({
			resizable : false,
			height : 140,
			modal : true,
			autoOpen : false,
			buttons : {
				"Delete Project" : function() {
					$(this).dialog("submit");
					submit = true;
					$('#deleteProject').submit();
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});

	});

	$(function() {
		$("#accordion").accordion({
			autoHeight : false,
			navigation : true,
			collapsible : true,
			active : false
		});
	});
</script>

<script>
  $( function() {
	  $('.datepick').each(function(){
		    $(this).datepicker(
		    		{
		    			
		    			changeMonth: true,
			    	      changeYear: true,
		    			
		    		}
		    
		    );
		});
  } );
  </script>
  
</head>

<body>

    <!-- *************************Code for Tabs************************************8 -->

    <div class="tabbable full-width-tabs">
        <ul class="nav nav-tabs">

            <li class="active"><a data-toggle="tab" href="#ListProject">Project List</a></li>
        </ul>

        <div class="tab-content">
            <div id="ListProject" class="tab-pane fade in active">


                <!-- ***************************************Code for delete modal***************************** -->

                <div class="body">

                    <div id="deleteProjectID-model" title="Delete Project">


                        <s:form namespace="/" action="DeleteProject" method="post" id="deleteProject">

                            <!-- <p>Are U sure?</p> -->

                            <s:hidden name="projectDetail.projectID" value="%{projectID}" />
                        </s:form>
                    </div>

                    <br>

                    <!-- ***************************************Code for update***************************** -->



                    <!-- <div id="updateProjectID-model" title="Update Project">


                                <s:form namespace="/" action="UpdateProjectSubmit" method="post" id="updateProjectID">
                                <table>
                                <tr>
                                <td>Project Name </td>
                                <td>
                                <s:textfield name="projectDetail.projectName" />
                                </td>
                                </tr>

                                <tr>
                                <td>Description </td>
                                <td>
                                <s:textfield name="projectDetail.description" />
                                </td>
                                </tr>
                                <tr>
                                <td>Comments</td>
                                <td>
                                <s:textfield name="projectDetail.comments" />
                                </td>
                                </tr>
                                <tr>
                                <td>Start Date</td>
                                <td>
                                <s:textfield name="projectDetail.startDate" />
                                </td>
                                </tr>
                                <tr>
                                <td>End Date</td>
                                <td>
                                <s:textfield name="projectDetail.endDate" />
                                </td>
                                </tr>

                                <tr>

                                <td>
                                <s:submit type="submit" value="submit" />
                                <s:hidden name="projectDetail.projectID"></s:hidden>
                                <s:hidden name="projectDetail.versionNo"></s:hidden>

                                </tr>


                                </table>

                                <s:hidden name="projectDetail.projectID" value="%{projectID}" />
                                </s:form>
                                </div>

                                <br>
                            -->
                    <!-- ***************************************Code to create new project***************************** -->

                    <div class="pull-right" class="container">

                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Create New Project</button>

                        <div class="modal fade" id="modal-1" data-keyboard="false" data-backdrop="static">

                            <div class="modal-dialog modal-lg">

                                <div class="modal-content">

                                    <div class="modal-header">

                                        <button class="close" type="button" data-dismiss="modal">&times;</button>
                                        <h3 class="modal-title">Create New Project</h3>
                                    </div>

                                    <div class="modal-body">

                                        <s:form class="form-inline" name="CreateProject" namespace="/" action="CreateProjectSubmit" method="POST" role="form"
                                            theme="bootstrap">

                                            <br />
                                            <table>
                                                 
                                                <div class="form-group">
                                                    <label>Project Name:</label> <s:textfield type="text" class="form-control" name="projectDetail.projectName" />
                                                </div>

                                                <br />
                                                <br />

                                                <div class="form-group">
                                                    <label>Description:</label> <s:textfield type="text" class="form-control" name="projectDetail.description" />
                                                </div>

                                                <br />
                                                <br />

                                                <div class="form-group">
                                                    <label>Start Date:</label> <input type="text" class="datepick" id="date_1" class="dateTxt" name="projectDetail.startDate"
                                                        placeholder="mm/dd/yy" />
                                                </div>

                                                <br />
                                                <br />

                                                <div class="form-group">
                                                    <label>End Date:</label> <input type="text" class="datepick" id="date_2" class="dateTxt" name="projectDetail.endDate"
                                                        placeholder="mm/dd/yy" />
                                                </div>
                                                
                                                <div class="container">
       

                                            </table>
                                            <br />

                                            <div class="modal-footer">
                                                <s:submit type="submit" id="submit" value="Submit" class="btn btn-primary" />
                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            </div>

                                        </s:form>

                                    </div>

                                </div>

                            </div>

                        </div>

                    </div>

                    <!-- *******************************code to update Project ******************************* -->



                    <!-- *******************************code to display Project List******************************* -->


                  <s:form name="ListForm" id="ListForm" method="post">

                    <!-- <a href="CreateProject">Create New Project</a> -->
                    <br> <br>
                    <div class="container">
                        <table class="table table-striped" border="1"; width=100%>
                            <thead>

                                <tr class="success">
                                    <th>Project Name</th>
                                    <th>Record Status</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th colspan=3>Action</th>
                                </tr>
                            </thead>

                            <s:iterator value="projectDetailList" status="stat">

                                <tr>
                                    <td><s:property value="projectName" /></td>
                                    <td><s:property value="recordStatus" /></td>
                                    <td><s:property value="startDate" /></td>
                                    <td><s:property value="endDate" /></td>

                                    <td><s:url id="ViewProjectURL" action="ReadProject" escapeAmp="false">
                                            <s:param name="projectDetail.projectID" value="%{projectID}" />
                                        </s:url> <s:a href="%{ViewProjectURL}">View</s:a> <!-- <s:url var="updateProjectURL" action="ReadProject"
                                                                    escapeAmp="false">
                                                                    <s:param name="projectDetail.projectID" value="%{projectID}"
                                                                    />
                                                                    <s:param name="act" value="%{updateAction}" />
                                                                    </s:url>

                                                                    <s:a href="%{updateProjectURL}">Update</s:a> --> <s:url id="updateProjectURL">
                                        </s:url> <s:a href="%{updateProjectURL}" id="updateProjectID">Update</s:a> 
                                        <s:url id="ProjectDeleteURL">
                                        </s:url> <s:a href="%{ProjectDeleteURL}" id="deleteProjectID">Delete</s:a> <!-- <s:a href="%{ProjectDeleteURL}" onclick="return confirm('Are
                                                                    u sure?');">Delete</s:a> --> <!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    data-target="#modal-2"
                                                                    value="%{projectID}">Delete</button> --> <!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    onclick="check()"
                                                                    value="%{projectID}">Delete</button> --></td>

                                </tr>

                            </s:iterator>

                        </table>
                    </div>

                     </s:form> 

                </div>
            </div>
        </div>
    </div>

</body>
</html>