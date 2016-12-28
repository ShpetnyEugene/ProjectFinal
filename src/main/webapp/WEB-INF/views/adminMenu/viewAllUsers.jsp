<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Views all users</title>

<t:_layout>
    <jsp:body>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>idUser</th>
                <th>First Name</th>
                <th>Last name</th>
                <th>Patronymic</th>
                <th>Age</th>
                <th>Identification Number</th>
                <th>Login</th>
                <th>Password</th>
                <th>Role</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <th>${user.idUser}</th>
                    <th>${user.firstName}</th>
                    <th>${user.lastName}</th>
                    <th>${user.patronymic}</th>
                    <th>${user.birthDay}</th>
                    <th>${user.identificationNumber}</th>
                    <th>${user.login}</th>
                    <th>${user.password}</th>
                    <th>${user.role}</th>
                    <th>
                        <form name = "Delete" method="post">
                            <button type="submit" name = "Delete" value="${user.idUser}">Delete</button>
                        </form>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="col-xs-offset-5 col-xs-10">
            <div class="col-xs-3">
                <a href="${pageContext.request.contextPath}/admin" type="button" class="btn btn-lg btn-primary btn-block">Вернуться в админ меню</a>
            </div>
        </div>

    </jsp:body>
</t:_layout>