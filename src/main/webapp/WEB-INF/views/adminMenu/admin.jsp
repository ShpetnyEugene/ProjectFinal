<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Administration menu">
    <jsp:body>
        <ul class="list-group">
            <li class="list-group-item list-group-item-info"><fmt:message key="trainControl" bundle="${messages}"/></li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/admin/trains/add"><fmt:message key="addRecords"
                                                                                           bundle="${messages}"/></a>
            </li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/admin/users"><fmt:message key="showAllUsers"
                                                                                      bundle="${messages}"/></a>
            </li>

            <li class="list-group-item list-group-item-info"><fmt:message key="userControl" bundle="${messages}"/></li>
            <li class="list-group-item">
                <a href="${pageContext.request.contextPath}/admin/trains"><fmt:message key="showAllTrains"
                                                                                       bundle="${messages}"/></a>
            </li>
        </ul>
    </jsp:body>
</t:_layout>