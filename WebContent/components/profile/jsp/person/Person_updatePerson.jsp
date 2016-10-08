<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<style type="text/css">
tr.break td {
	height: 10px;
}
</style>
</head>
<body>
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
                <div class="col-lg-12"></div>
            </div>

            <div class="row">
                <div class="col-lg-12">

                    <div class="container" style="border: thin solid black">
                        <s:form action="PersonUpdateSubmit" namespace="/Profile" method="POST">
                            <h4 class="well well-sm">Update Person</h4>

                            <table style="width: 100%;">
                                <col width="20%" />
                                <col width="30%" />
                                <col width="20%" />
                                <col width="30%" />

                                <tr>
                                    <th>Title :</th>
                                    <td>
                                        <s:textfield name="personDetail.title" theme="simple" />
                                    </td>
                                    <th>First Name :</th>
                                    <td>
                                        <s:textfield name="personDetail.firstName" theme="simple" />
                                    </td>
                                </tr>

                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>

                                <tr>
                                    <th>Middle Name :</th>
                                    <td>
                                        <s:textfield name="personDetail.middleName" theme="simple" />
                                    </td>
                                    <th>Last Name :</th>
                                    <td>
                                        <s:textfield name="personDetail.lastName" theme="simple" />
                                    </td>
                                </tr>

                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>

                                <tr>
                                    <th>Gender :</th>
                                    <td>
                                        <s:textfield name="personDetail.gender" theme="simple" />
                                    </td>
                                    <th>Date Of Birth :</th>
                                    <td>
                                        <s:textfield name="personDetail.dateOfBirth" theme="simple" />
                                    </td>
                                </tr>

                                <tr class="break">
                                    <td colspan="2"></td>
                                </tr>

                                <tr>
                                    <th>Registration Date :</th>
                                    <td>
                                        <s:textfield name="personDetail.registrationDate" theme="simple" />
                                    </td>
                                    <th></th>
                                    <td>
                                        <s:submit type="submit" value="submit" class="btn btn-primary" theme="simple" />
                                    </td>
                                </tr>


                                <s:hidden name="personDetail.personID"></s:hidden>
                                <s:hidden name="personDetail.versionNo"></s:hidden>
                            </table>


                            <br />

                        </s:form>
                    </div>
                </div>
            </div>
        </div>

        <br />
    </div>

    <!-- FOOTER -->
    <div id="footer">
        <%@ include file="/components/core/jsp/footer.jsp"%>
    </div>
    <!--END FOOTER -->

</body>
</html>