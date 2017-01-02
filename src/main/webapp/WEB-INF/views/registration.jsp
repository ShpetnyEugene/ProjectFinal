<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Registration</title>

<t:_layout>

    <jsp:body>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>

        <div class="form-horizontal">
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4 class="text-center">${error}</h4>
                </div>
            </c:if>

        </div>

        <h1 class="text-center"><fmt:message key="registers" bundle="${messages}"/></h1>

        <form class="form-horizontal" method="post">
            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="lastName"><fmt:message key="lastName"
                                                                                  bundle="${messages}"/>:</label>
                <div class="col-xs-3">
                    <input type="text" name="lastName" class="form-control" id="lastName"
                           placeholder="<fmt:message key="enterLastName" bundle="${messages}"/>">
                </div>
            </div>
            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="firstName"><fmt:message key="firstName"
                                                                                   bundle="${messages}"/>:</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name="firstName" id="firstName"
                           placeholder="<fmt:message key="enterFirstName" bundle="${messages}"/>">
                </div>
            </div>
            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="fatherName"><fmt:message key="patronymic"
                                                                                    bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name="patronymic" id="fatherName"
                           placeholder="<fmt:message key="enterPatronymic" bundle="${messages}"/>">
                </div>
            </div>
            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5"><fmt:message key="birthDay" bundle="${messages}"/></label>

                <div class="col-xs-3">
                    <input type="text" name="birthDay" class="form-control" id="datetimepicker">
                </div>
            </div>

            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="inputEmail"><fmt:message key="login"
                                                                                    bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="email" name="login" class="form-control" id="inputEmail" placeholder="Email">
                </div>
            </div>
            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="inputPassword"><fmt:message key="password"
                                                                                       bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="password" name="password" class="form-control" id="inputPassword"
                           placeholder="<fmt:message key="enterPassword" bundle="${messages}"/>">
                </div>
            </div>


            <div class="form-group" style="margin-right: 0">
                <label class="control-label col-xs-5" for="firstName"><fmt:message key="identificationNumber"
                                                                                   bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="text" name="identificationNumber" class="form-control" id="postalAddress"
                           placeholder="<fmt:message key="enterIdentificationNumber" bundle="${messages}"/>">
                </div>
            </div>

            <div class="col-md-3 col-md-offset-5">

                <input type="submit" class="btn btn-primary"
                       value="<fmt:message key="registration" bundle="${messages}"/>">
                <input type="reset" class="btn btn-default" value="<fmt:message key="clearForm" bundle="${messages}"/>">

            </div>

            <br>

        </form>


    </jsp:body>
</t:_layout>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker(
                {pickTime: false, language: 'ru'}
        );
    });
</script>
