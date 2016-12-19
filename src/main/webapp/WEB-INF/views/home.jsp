<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>


<t:_layout>
    <jsp:body>

       <a href="/login"> <button>Войти</button></a>


        <c:if test = "${not empty user}">
            <form action="home" method="post">
                <input type="submit" value="logout">
            </form>


            <h3>${user.login}  ${user.role}</h3>

            <c:if test="${empty user}">
                <h3>Guest</h3>
                <a href="login">login</a>
            </c:if>
        </c:if>


        <table class="table table-hover">
            <thead>
                <tr>
                    <th>idTrain</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="train" items="${trains}">
                    <tr>
                        <th>${train.idTrain}</th>
                        <th>${train.name}</th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </jsp:body>
</t:_layout>