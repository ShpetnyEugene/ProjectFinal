<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Home">
    <jsp:body>
        <div class="page-header">
            <h1><fmt:message key="homePage" bundle="${messages}"/></h1>
            <p class="lead"><fmt:message key="homeHello" bundle="${messages}"/></p>
        </div>
    </jsp:body>
</t:_layout>