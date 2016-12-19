<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <c:if test = "${not empty user}">
        <h3>${user.login}  ${user.role}</h3>
        <form action="logout" method="post">
            <input type="submit" value="logout">
        </form>

        <c:if test="${empty user}">
            <h3>Guest</h3>
            <a href="login">login</a>
        </c:if>


    </c:if>
</body>
</html>
