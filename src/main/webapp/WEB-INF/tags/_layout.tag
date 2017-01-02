<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="icon" href="../../favicon.ico">

    <title>Booking Tickets</title>




    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-1.11.1.min.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/bootstrap/js/moment-with-locales.min.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"/>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-datetimepicker.min.css"/>



    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/ie10-viewport-bug-workaround.css"
          rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/signin.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie8-responsive-file-warning.js"></script>

    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>

    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>


<form method="post" action="${pageContext.request.contextPath}/config/language">
    <button type="submit" name="local" value="rus"> Russian</button>
    <button type="submit" name="local" value="en">English</button>
</form>


<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>


<c:if test="${not empty user}">


<div class="container">

    <div style="position: relative; text-align: right;">


        <div style="float: right;">
            <fmt:message key="hello" bundle="${messages}"/> ${user.login}, ${user.role}

            <c:if test="${user.role == 'ADMIN'}">
                <a href="${pageContext.request.contextPath}/admin" type="button" class="">
                    <span class="glyphicon glyphicon-lock"></span> <fmt:message key="adminMenu" bundle="${messages}"/></a>
            </c:if>

            <div>
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="submit" value="<fmt:message key="logout" bundle="${messages}"/>">
                </form>
            </div>

        </div>
        </c:if>

        <br>
        <br>

        <jsp:doBody/>
</body>
</html>
