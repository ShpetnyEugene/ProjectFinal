<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:_layout>
    <jsp:body>

        <h1 class="text-center">Добро пожаловать в систему по заказу <p> железнодорожных билетов</h1>

        <div class="col-md-2 col-md-offset-5">
            <a href="booking/ViewsAllStation" type="button" class="btn btn-lg btn-primary btn-block">Сделать заказ</a>
        </div>
    </jsp:body>
</t:_layout>