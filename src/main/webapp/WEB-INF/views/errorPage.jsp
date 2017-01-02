<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:_layout>
    <jsp:body>

        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>
        
        <h1 style="text-align: center"> <fmt:message key="oops" bundle="${messages}"/></h1>

        <h3 style="text-align: center"><fmt:message key="pageNotFound" bundle="${messages}"/></h3>
    </jsp:body>
</t:_layout>