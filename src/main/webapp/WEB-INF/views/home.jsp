<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:_layout>
    <jsp:body>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>
        <div class="page-header">
            <h1>Главная страница</h1>
            <p class="lead"><fmt:message key="homeHello" bundle="${messages}"/></p>
        </div>

    </jsp:body>
</t:_layout>