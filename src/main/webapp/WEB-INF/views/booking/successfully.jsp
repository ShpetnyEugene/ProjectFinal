<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Successfully">
    <jsp:body>
        <div class="page-header">
            <h1><fmt:message key="successfully" bundle="${messages}"/></h1>
            <h3><fmt:message key="needPay" bundle="${messages}"/> ${price} </h3>
            <h3><fmt:message key="cash" bundle="${messages}"/> ${number}  </h3>
        </div>
    </jsp:body>
</t:_layout>