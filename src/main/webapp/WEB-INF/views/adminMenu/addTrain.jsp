<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Add Train</title>

<t:_layout>
    <jsp:body>

        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>

        <br>
        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-xs-4" for="firstName"><fmt:message key="nameTrain"
                                                                                   bundle="${messages}"/></label>
                <div class="col-xs-4">
                    <input type="text" name="name" class="form-control" id="firstName"
                           placeholder="<fmt:message key="enterNameTrain" bundle="${messages}"/>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-4" for="lastName"><fmt:message key="numberFreePlaces"
                                                                                  bundle="${messages}"/></label>
                <div class="col-xs-4">
                    <input type="text" name="numberFreePlaces" class="form-control" id="lastName"
                           placeholder="<fmt:message key="enterNumberFreePlaces" bundle="${messages}"/>">
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-9">
                    <input type="submit" class="btn btn-primary"
                           value="<fmt:message key="addRecords" bundle="${messages}"/>">
                    <input type="reset" class="btn btn-default"
                           value="<fmt:message key="clearForm" bundle="${messages}"/>">
                </div>
            </div>
        </form>


        <div class="col-xs-offset-4 col-xs-9">
            <div class="col-xs-3">
                <a href="${pageContext.request.contextPath}/admin" style="width: 170%" type="button"
                   class="btn btn-lg btn-primary btn-block"><fmt:message key="backToAdminMenu"
                                                                         bundle="${messages}"/></a>
            </div>
        </div>

    </jsp:body>
</t:_layout>