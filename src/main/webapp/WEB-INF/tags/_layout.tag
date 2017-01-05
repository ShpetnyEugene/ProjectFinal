<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="Yeugen Shpetny">

    <%--<link rel="icon" href="../../favicon.ico">--%>
    <title>Trains</title>

    <!-- Bootstrap core CSS -->

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/datapicker/bootstrap-datetimepicker.min.css"/>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/ie10-viewport-bug-workaround.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/easy-autocomplete/easy-autocomplete.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/easy-autocomplete/easy-autocomplete.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/easy-autocomplete/easy-autocomplete.themes.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/easy-autocomplete/easy-autocomplete.themes.min.css"
          rel="stylesheet">
</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <!-- The mobile navbar-toggle button can be safely removed since you do not need it in a non-responsive implementation -->
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Train order</a>
        </div>
        <!-- Note that the .navbar-collapse and .collapse classes have been removed from the #navbar -->
        <div id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Главная</a></li>
                <li><a href="#about">Сделать заказ</a></li>
                <li><a href="#contact">Информация</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Сменить язык <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <form method="post" action="${pageContext.request.contextPath}/config/language">
                                <button class="btn btn-default btn-block" type="submit" name="local" value="rus"> Russian</button>
                            </form>
                        </li>
                        <li>
                            <form method="post" action="${pageContext.request.contextPath}/config/language">
                                <button class="btn btn-default btn-block" type="submit" name="local" value="en">English</button>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <c:if test="${not empty user}">
                    <li><a href="#"><fmt:message key="hello" bundle="${messages}"/> ${user.login}, ${user.role}</a></li>
                    <c:if test="${user.role == 'ADMIN'}">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin" type="button" class="">
                                <span class="glyphicon glyphicon-lock"></span> <fmt:message key="adminMenu"
                                                                                            bundle="${messages}"/></a>
                        </li>
                    </c:if>
                    <li>
                        <form action="${pageContext.request.contextPath}/logout" method="post">
                            <input type="submit" value="<fmt:message key="logout" bundle="${messages}"/>">
                        </form>
                    </li>
                </c:if>
                <c:if test="${empty user}">
                    <li><a href="${pageContext.request.contextPath}/login">Войти</a></li>
                    <li><a href="${pageContext.request.contextPath}/registration">Зарегистрироваться</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <jsp:doBody/>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">Финальное задание Шпетного Евгения</p>
    </div>
</footer>
</body>

<%--TODO Recomended to include scripts in the end of page --%>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/datapicker/moment-with-locales.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/datapicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/easy-autocomplete/jquery.easy-autocomplete.js"></script>
<script src="${pageContext.request.contextPath}/resources/easy-autocomplete/jquery.easy-autocomplete.min.js"></script>


</html>
