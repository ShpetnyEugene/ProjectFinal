<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Login</title>

<t:_layout>
    <jsp:body>

        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>

        <title><fmt:message key="login" bundle="${messages}"/></title>


        <div class="container" >

            <form class="form-signin" method="post">
                <h2 class="form-signin-heading" style="text-align: center"><fmt:message key="login" bundle="${messages}"/></h2>
                <label for="inputEmail" class="sr-only"><fmt:message key="emailAdress" bundle="${messages}"/></label>
                <input type="email" style="width: 100%" name="email" id="inputEmail" class="form-control" placeholder="<fmt:message key="emailAdress" bundle="${messages}"/>" required autofocus>
                <label for="inputPassword" class="sr-only"><fmt:message key="password" bundle="${messages}"/></label>
                <input type="password" style="width: 100%" id="inputPassword" name="password" class="form-control" placeholder="<fmt:message key="password" bundle="${messages}"/>" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="signIn" bundle="${messages}"/></button>
                <a href="${pageContext.request.contextPath}/registration" type="button" class="btn btn-lg btn-primary btn-block"><fmt:message key="registers" bundle="${messages}"/></a>
            </form>

            <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie10-viewport-bug-workaround.js"></script>
        </div>

     </jsp:body>
</t:_layout>