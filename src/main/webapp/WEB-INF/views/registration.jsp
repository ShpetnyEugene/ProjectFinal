<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<title>Registration</title>

<t:_layout>

    <jsp:body>
        <div class="page-header">
            <h1><fmt:message key="registers" bundle="${messages}"/></h1>
        </div>
        <div class="row">
            <div class="col-md-8">
                <p class="lead">описание прав пользователя Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab
                    ad adipisci alias amet assumenda, earum exercitationem expedita illum minima non obcaecati pariatur
                    quae quia quos reprehenderit sint, suscipit tempora veniam.</p>
            </div>
            <div class="col-md-4">

                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <h4 class="text-center">${error}</h4>
                    </div>
                </c:if>

                <form class="form-signin" method="post">
                    <div class="form-group">
                        <label class="control-label  " for="lastName"><fmt:message key="lastName"
                                                                                   bundle="${messages}"/>:
                            <input type="text" name="lastName" class="form-control" id="lastName"
                                   placeholder="<fmt:message key="enterLastName" bundle="${messages}"/>"></label>
                    </div>
                    <div class="form-group">
                        <label class="control-label  " for="firstName"><fmt:message key="firstName"
                                                                                    bundle="${messages}"/>:
                            <input type="text" class="form-control" name="firstName" id="firstName"
                                   placeholder="<fmt:message key="enterFirstName" bundle="${messages}"/>"></label>
                    </div>
                    <div class="form-group">
                        <label class="control-label  " for="fatherName"><fmt:message key="patronymic"
                                                                                     bundle="${messages}"/>
                            <input type="text" class="form-control" name="patronymic" id="fatherName"
                                   placeholder="<fmt:message key="enterPatronymic" bundle="${messages}"/>"></label>
                    </div>
                    <div class="form-group">
                        <label class="control-label  "><fmt:message key="birthDay" bundle="${messages}"/>

                            <input type="text" name="birthDay" class="form-control" id="datetimepicker"></label>
                    </div>

                    <div class="form-group">
                        <label class="control-label  " for="inputEmail"><fmt:message key="login"
                                                                                     bundle="${messages}"/>
                            <input type="email" name="login" class="form-control" id="inputEmail"
                                   placeholder="Email"></label>
                    </div>
                    <div class="form-group">
                        <label class="control-label  " for="inputPassword"><fmt:message key="password"
                                                                                        bundle="${messages}"/>
                            <input type="password" name="password" class="form-control" id="inputPassword"
                                   placeholder="<fmt:message key="enterPassword" bundle="${messages}"/>"></label>
                    </div>


                    <div class="form-group">
                        <label class="control-label  " for="firstName"><fmt:message key="identificationNumber"
                                                                                    bundle="${messages}"/>
                            <input type="text" name="identificationNumber" class="form-control" id="postalAddress"
                                   placeholder="<fmt:message key="enterIdentificationNumber" bundle="${messages}"/>"></label>
                    </div>


                    <input type="submit" class="btn btn-primary"
                           value="<fmt:message key="registration" bundle="${messages}"/>">
                    <input type="reset" class="btn btn-default"
                           value="<fmt:message key="clearForm" bundle="${messages}"/>">

                </form>
                <br>
                <br>
            </div>
        </div>


    </jsp:body>
</t:_layout>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker(
            {pickTime: false, language: 'ru'}
        );
    });
</script>
