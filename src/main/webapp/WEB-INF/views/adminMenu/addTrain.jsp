<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<t:_layout title="Add Train">
    <jsp:body>

        <div class="page-header">
            <h1><fmt:message key="enterNewTrain" bundle="${messages}"/></h1>
        </div>

        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                <form method="post">
                    <div class="form-group">
                        <label for="firstName">
                            <fmt:message key="nameTrain" bundle="${messages}"/>
                        </label>
                        <input type="text" name="name" class="form-control" id="firstName" placeholder="<fmt:message key="enterNameTrain" bundle="${messages}"/>">
                    </div>
                    <div class="form-group">
                        <label for="lastName">
                            <fmt:message key="numberFreePlaces" bundle="${messages}"/>
                        </label>
                        <input type="text" name="numberFreePlaces" class="form-control" id="lastName"
                               placeholder="<fmt:message key="enterNumberFreePlaces" bundle="${messages}"/>">
                    </div>
                    <div>
                        <input type="submit" class="btn btn-primary"
                               value="<fmt:message key="addRecords" bundle="${messages}"/>">
                        <input type="reset" class="btn btn-default"
                               value="<fmt:message key="clearForm" bundle="${messages}"/>">
                    </div>
                </form>

            </div>
            <div class="col-md-4"></div>
        </div>
    </jsp:body>
</t:_layout>