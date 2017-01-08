<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout>
    <jsp:body>
        <h1 style="text-align: center"> <fmt:message key="ouch" bundle="${messages}"/></h1>
        <h3 style="text-align: center"><fmt:message key="error" bundle="${messages}"/></h3>
    </jsp:body>
</t:_layout>