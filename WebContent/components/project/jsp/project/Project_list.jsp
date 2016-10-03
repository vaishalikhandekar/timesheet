



<!-- HEADER SECTION -->
 <div id="top">

	<%@ include file="/components/core/jsp/header.jsp"%>
</div> 
<!-- END HEADER SECTION -->



<!-- MENU SECTION -->
 <div id="left">
	<%@ include file="/components/core/jsp/menu.jsp"%>

</div>
<!--END MENU SECTION -->



<!--PAGE CONTENT -->
<div id="content">

	<div class="inner">
		<div class="row">
			<div class="col-lg-12">
				<h3>Project Details</h3>
			</div>
		</div>



		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Project List</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
									<tr class="success">
										<th style="text-align: center">Action</th>
										<th style="text-align: center">Project Name</th>
										<th style="text-align: center">Acronym</th>
										<th style="text-align: center">Description</th>
										<th style="text-align: center">Start Date</th>
										<th style="text-align: center">End Date</th>
										<th style="text-align: center">Record Status</th>

									</tr>
								</thead>
								<tbody>
									<s:iterator value="projectDetailList" status="stat">

										<tr>
											<td align="center"><s:url id="ViewProjectURL"
													action="ProjectRead" namespace="/Project" escapeAmp="false">
													<s:param name="projectDetail.projectID"
														value="%{projectID}" />
												</s:url> <s:a href="%{ViewProjectURL}">
													<span class="glyphicon glyphicon-eye-open"></span>
													<!-- View -->
												</s:a> &nbsp;&nbsp; <s:url var="updateProjectURL"
													action="ProjectRead" namespace="/Project" escapeAmp="false">
													<s:param name="projectDetail.projectID"
														value="%{projectID}" />
													<s:param name="act" value="%{updateAction}" />
												</s:url> <s:a href="%{updateProjectURL}">
													<span class="glyphicon glyphicon-pencil"></span>
													<!-- Update -->
												</s:a> &nbsp;&nbsp; <%-- <s:url id="updateProjectURL">
                                            </s:url> <s:a href="%{updateProjectURL}" id="updateProjectID">Update</s:a> --%>

												<s:url id="ProjectDeleteURL">
												</s:url> <s:a href="%{ProjectDeleteURL}" id="deleteProjectID">
													<span class="glyphicon glyphicon-trash"></span>
													<!-- Delete -->
												</s:a> <!-- <s:a href="%{ProjectDeleteURL}" onclick="return confirm('Are
                                                                    u sure?');">Delete</s:a> -->
												<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    data-target="#modal-2"
                                                                    value="%{projectID}">Delete</button> -->
												<!-- <button type="button" class="btn btn-primary" data-toggle="modal"
                                                                    onclick="check()"
                                                                    value="%{projectID}">Delete</button> -->
											</td>

											<td align="center"><s:property value="projectName" /></td>
											<td align="center"><s:property value="acronym" /></td>
											<td align="center"><s:property value="description" /></td>
											<td align="center"><s:property value="startDate" /></td>
											<td align="center"><s:property value="endDate" /></td>
											<td align="center"><s:property value="recordStatus" />
											</td>

											<!-- Script for delete -->

										</tr>


									</s:iterator>

								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--END PAGE CONTENT -->

<!-- RIGHT STRIP  SECTION -->
<div id="right">


	<div class="well well-small">
		<ul class="list-unstyled">
			<li>Visitor &nbsp; : <span>23,000</span></li>
			<li>Users &nbsp; : <span>53,000</span></li>
			<li>Registrations &nbsp; : <span>3,000</span></li>
		</ul>
	</div>
	<div class="well well-small">
		<button class="btn btn-block">Help</button>
		<button class="btn btn-primary btn-block">Tickets</button>
		<button class="btn btn-info btn-block">New</button>
		<button class="btn btn-success btn-block">Users</button>
		<button class="btn btn-danger btn-block">Profit</button>
		<button class="btn btn-warning btn-block">Sales</button>
		<button class="btn btn-inverse btn-block">Stock</button>
	</div>
	<div class="well well-small">
		<span>Profit</span><span class="pull-right"><small>20%</small></span>

		<div class="progress mini">
			<div class="progress-bar progress-bar-info" style="width: 20%"></div>
		</div>
		<span>Sales</span><span class="pull-right"><small>40%</small></span>

		<div class="progress mini">
			<div class="progress-bar progress-bar-success" style="width: 40%"></div>
		</div>
		<span>Pending</span><span class="pull-right"><small>60%</small></span>

		<div class="progress mini">
			<div class="progress-bar progress-bar-warning" style="width: 60%"></div>
		</div>
		<span>Summary</span><span class="pull-right"><small>80%</small></span>

		<div class="progress mini">
			<div class="progress-bar progress-bar-danger" style="width: 80%"></div>
		</div>
	</div>




</div>
<!-- END RIGHT STRIP  SECTION -->



<!--END MAIN WRAPPER -->

<!-- FOOTER -->
 <div id="footer">
	<%@ include file="/components/core/jsp/footer.jsp"%>
</div> 
<!--END FOOTER -->

 