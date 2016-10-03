


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
						<h3>Person Details</h3>
					</div>
				</div>



				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">Person List</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>Title</th>
												<th>First Name</th>
												<th>Middle Name</th>
												<th>Last Name</th>
												<th>Gender</th>
												
												<th>Registration Date</th>
												<th>Record Status</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator value="personDetailList" status="stat">

												<tr>
													

													<td align="center"><s:property value="title" /></td>

													<td align="center"><s:property value="firstName" /></td>

													<td align="center"><s:property value="middleName" />
													</td>

													<td align="center"><s:property value="lastName" /></td>

													<td align="center"><s:property value="gender" /></td>
													
													<td align="center"><s:date name="registrationDate" />
													</td>

													<td align="center"><s:property value="recordStatus" />
													</td>
													<td align="center"><s:url var="readPersonURL"
															action="PersonRead" escapeAmp="false">
															<s:param name="personDetail.personID" value="%{personID}" />
														</s:url> <s:a href="%{readPersonURL}">
															<span class="glyphicon glyphicon-eye-open"></span>
															<!-- View -->
														</s:a> &nbsp;&nbsp; <s:url var="updatePersonURL"
															action="PersonRead" escapeAmp="false">
															<s:param name="personDetail.personID" value="%{personID}" />
															<s:param name="act" value="%{updateAction}" />
															<s:param name="returnFrom" value="%{returnPage}" />
														</s:url> <s:a href="%{updatePersonURL}">
															<span class="glyphicon glyphicon-pencil"></span>
															<!-- Update -->
														</s:a> &nbsp;&nbsp; <a href="#DeletePerson" data-toggle="modal"
														data-id="%{personID}"> <span
															class="glyphicon glyphicon-trash"></span> <!-- Delete -->
													</a> &nbsp;&nbsp; </td>

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
                <button class="btn btn-block"> Help </button>
                <button class="btn btn-primary btn-block"> Tickets</button>
                <button class="btn btn-info btn-block"> New </button>
                <button class="btn btn-success btn-block"> Users </button>
                <button class="btn btn-danger btn-block"> Profit </button>
                <button class="btn btn-warning btn-block"> Sales </button>
                <button class="btn btn-inverse btn-block"> Stock </button>
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

	
	</div>

	<!--END MAIN WRAPPER -->

	<!-- FOOTER -->
	<div id="footer">
		<%@ include file="/components/core/jsp/footer.jsp"%>
	</div>
	<!--END FOOTER -->

