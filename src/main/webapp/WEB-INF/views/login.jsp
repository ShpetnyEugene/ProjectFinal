<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<%--TODO--%>
<title>Login</title>

<t:_layout>
    <jsp:body>

        <div class="page-header">
            <h1><fmt:message key="login" bundle="${messages}"/></h1>
        </div>

        <%-- TODO wtf? <tag:text value="login"></tag:text>--%>
        <div class="row">
            <div class="col-md-8">
                <p class="lead">Чтобы воспользоваться данным ресурсом Вы должны создать аккаунт,
                    после чего вы сможете совершать покупку билетов на поезда.</p>
            </div>
            <div class="col-md-4">
                <form class="form-signin" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1"><fmt:message key="emailAdress" bundle="${messages}"/></label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                               placeholder="<fmt:message key="emailAdress" bundle="${messages}"/>" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1"><fmt:message key="password" bundle="${messages}"/></label>
                        <input type="password" class="form-control" id="exampleInputPassword1" name="password"
                               placeholder="<fmt:message key="password" bundle="${messages}"/>" required>
                    </div>
                    <button type="submit" class="btn btn-default btn-block"><fmt:message key="signIn"
                                                                               bundle="${messages}"/></button>
                </form>
                <hr>
                <h4>Еще нет аккаунта? Вы можете бесплатно зарегистрироваться</h4>
                <a href="${pageContext.request.contextPath}/registration" type="button"
                   class="btn btn-primary btn-block"><fmt:message key="registers" bundle="${messages}"/></a>
            </div>
        </div>
    </jsp:body>
</t:_layout>