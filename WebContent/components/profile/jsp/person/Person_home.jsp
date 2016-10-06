
<% String  projectCount = "0"; %>

<%
	if (request.getAttribute("projectCount") != null) {

		projectCount = (String) request.getAttribute("projectCount");
		
	}
%>

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
				<h3>Admin Dashboard</h3>
			</div>
		</div>

		<hr />
		<!--BLOCK SECTION -->
		<div class="row">
			<div class="col-lg-12">
				<div style="text-align: center;">

					<a class="quick-btn" href="/TimeSheet/Project/ProjectList"> <i
						class="icon-th-large icon-2x"></i> <span> Project</span> <span
						class="label label-danger"> <%=projectCount%></span>
					</a> <a class="quick-btn" href="#"> <i
						class="icon-envelope icon-2x"></i> <span>Messages</span> <span
						class="label label-success">456</span>
					</a> <a class="quick-btn" href="#"> <i class="icon-signal icon-2x"></i>
						<span>Profit</span> <span class="label label-warning">+25</span>
					</a> <a class="quick-btn" href="#"> <i
						class="icon-external-link icon-2x"></i> <span>value</span> <span
						class="label btn-metis-2">3.14159265</span>
					</a> <a class="quick-btn" href="#"> <i class="icon-lemon icon-2x"></i>
						<span>tasks</span> <span class="label btn-metis-4">107</span>
					</a> <a class="quick-btn" href="#"> <i class="icon-bolt icon-2x"></i>
						<span>Tickets</span> <span class="label label-default">20</span>
					</a>

				</div>

			</div>

		</div>
		<!--END BLOCK SECTION -->



	</div>
</div>
<!--END PAGE CONTENT -->

<!-- RIGHT STRIP  SECTION -->
<div id="right">

	<%@ include file="/components/core/jsp/rightMenu.jsp"%>

</div>
<!-- END RIGHT STRIP  SECTION -->

</div>

<!--END MAIN WRAPPER -->

<!-- FOOTER -->
<div id="footer">
	<%@ include file="/components/core/jsp/footer.jsp"%>
</div>
<!--END FOOTER -->

