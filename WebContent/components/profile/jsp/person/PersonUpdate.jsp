<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
  $( function() {
    $( "#updatePersonModal" ).dialog({
      resizable: false,
      height: "auto",
      width: 200,
      modal: true,
    });
  } );
  </script>

</head>
<body>
	
     <div class="pull-right" class="container">

        <div class="modal fade" id="updatePersonModal" data-keyboard="false" data-backdrop="static">

            <div class="modal-dialog modal-lg">

                <div class="modal-content">

                    <div class="modal-header">
                          <button class="close" type="button" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Delete Project</h3>
                    </div>

                    <div class="modal-body">
	<s:form
		action="/UpdatePersonSubmit"
		method="POST">

		
		<table>
			<tr>
				<td>Title </td>
				<td><s:textfield name="personDetail.title"
					/></td>
			</tr>

			<tr>
				<td>First Name </td>
				<td><s:textfield name="personDetail.firstName"
					/></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><s:textfield name="personDetail.middleName"
					/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><s:textfield name="personDetail.lastName"
					/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><s:textfield name="personDetail.gender"
					/></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><s:textfield name="personDetail.dateOfBirth"
					/></td>
			</tr>
			<tr>
				<td>Registration Date</td>
				<td><s:textfield name="personDetail.registrationDate"
					/></td>
			</tr>
		</table>

                  <div class="modal-footer">
				<td><s:submit type="submit" value="submit" class="btn btn-primary"/>
                <s:hidden name="personDetail.personID"></s:hidden>
                <s:hidden name="personDetail.versionNo"></s:hidden>

            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>

                        </s:form>

                    </div>

                </div>

            </div>

        </div>

    </div>
            




</body>
</html>