<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:_layout>
    <jsp:body>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>


        <h1 class="text-center"><fmt:message key="homeHello" bundle="${messages}"/></h1>

        <div class="col-md-2 col-md-offset-5">
            <a href="${pageContext.request.contextPath}/order-tickets" type="button"
               class="btn btn-lg btn-primary btn-block"><fmt:message key="makeOrder" bundle="${messages}"/></a>
        </div>
    </jsp:body>
</t:_layout>