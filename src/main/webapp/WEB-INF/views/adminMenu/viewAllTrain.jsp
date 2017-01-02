<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Views all train</title>

<t:_layout>
    <jsp:body>

        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>


        <table class="table table-hover">
            <thead>
            <tr>
                <th style="width: 10%"><fmt:message key="id" bundle="${messages}"/></th>
                <th style="width: 25%"><fmt:message key="nameTrain" bundle="${messages}"/></th>
                <th style="width: 25%"><fmt:message key="numberFreePlaces" bundle="${messages}"/></th>
                <th style="width: 25%"><fmt:message key="delete" bundle="${messages}"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="train" items="${trains}">
                <tr>
                    <th>${train.idTrain}</th>
                    <th>${train.name}</th>
                    <th style="width: 25%">${train.numberFreePlaces}</th>
                    <th>
                        <form name = "Delete" method="post">
                            <button type="submit" name = "Delete" value="${train.idTrain}"><fmt:message key="delete" bundle="${messages}"/></button>
                        </form>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="col-xs-offset-4 col-xs-9">
            <div class="col-xs-3">
                <a href="${pageContext.request.contextPath}/admin" style="width: 170%" type="button" class="btn btn-lg btn-primary btn-block"><fmt:message key="backToAdminMenu" bundle="${messages}"/></a>
            </div>
        </div>

    </jsp:body>
</t:_layout>