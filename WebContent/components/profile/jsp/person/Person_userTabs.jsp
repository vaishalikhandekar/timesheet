
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<script type="text/javascript">
	$(".nav-tabs").on("click", "a", function(e) {
		e.preventDefault();
		if (!$(this).hasClass('add-contact')) {
			$(this).tab('show');
		}
	}).on("click", "span", function() {
		var anchor = $(this).siblings('a');
		$(anchor.attr('href')).remove();
		$(this).parent().remove();
		$(".nav-tabs li").children('a').first().click();
	});

	$('.add-contact')
			.click(
					function(e) {
						e.preventDefault();
						var id = $(".nav-tabs").children().length; //think about it ;)
						var tabId = 'contact_' + id;
						$(this)
								.closest('li')
								.before(
										'<li><a href="#contact_' + id + '">New Tab</a> <span> x </span></li>');
						$('.tab-content').append(
								'<div class="tab-pane" id="' + tabId + '">Contact Form: New Contact '
										+ id + '</div>');
						$('.nav-tabs li:nth-child(' + id + ') a').click();
					});
</script>

<style type="text/css">
.container {
	margin-top: 5px;
}

.nav-tabs>li {
	position: relative;
}

.nav-tabs>li>a {
	display: inline-block;
}

.nav-tabs>li>span {
	display: none;
	cursor: pointer;
	position: absolute;
	right: 6px;
	top: 8px;
	color: red;
}

.nav-tabs>li:hover>span {
	display: inline-block;
}
</style>
</head>

<body>
    <!-- code for tab -->

    <div class="container">

        <ul class="nav nav-tabs" role="tablist">

            <li class="active">
                <a data-toggle="tab" href="#PersonName">
                    <s:property value="personDetail.firstName" />
                    &nbsp;
                    <s:property value="personDetail.lastName" />
                </a>
                <span>x</span>
            </li>

            <li>
                <a data-toggle="tab" href="#PersonSearch" data-url="/TimeSheet/Profile/SearchPerson">Person Search</a>
                <span>x</span>
            </li>

        </ul>

    </div>

</body>

</html>