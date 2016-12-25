<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Booking Tickets</title>


    <!-- ... -->
    <!-- 1. Подключить библиотеку jQuery -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
    <!-- 2. Подключить скрипт moment-with-locales.min.js для работы с датами -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/moment-with-locales.min.js"></script>
    <!-- 3. Подключить скрипт платформы Twitter Bootstrap 3 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <!-- 4. Подключить скрипт виджета "Bootstrap datetimepicker" -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
    <!-- 5. Подключить CSS платформы Twitter Bootstrap 3 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
    <!-- 6. Подключить CSS виджета "Bootstrap datetimepicker" -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-datetimepicker.min.css" />


    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/signin.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie8-responsive-file-warning.js"></script>

    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

  <fmt:setBundle basename="messages" var="messages"/>



  <c:if test = "${not empty user}">
    <%--<form action="home" align="right" method="post">--%>
      <%--<input type="submit" align="right" value="Logout">--%>
    <%--</form>--%>



    <ul class="btn btn-inverse">
      <li class="next">
        <form action="home"  method="post">
          <input type="submit"  value="Logout">
        </form>
      </li>
    </ul>

    <h5><fmt:message key="hello" bundle="${messages}" /> ${user.login}  ${user.role}</h5>

    <c:if test="${empty user}">

      <a href="login">login</a>
    </c:if>
  </c:if>


  <jsp:doBody/>

  </div>

  </body>
</html>