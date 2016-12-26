<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<title>Views all train</title>

<t:_layout>
    <jsp:body>



        <table class="table table-hover">
            <thead>
            <tr>
                <th>idTrain</th>
                <th>Name</th>
                <th>Number free places</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="train" items="${trains}">
                <tr>
                    <th>${train.idTrain}</th>
                    <th>${train.name}</th>
                    <th>${train.numberFreePlaces}</th>
                    <th>
                        <form name = "Delete" method="post">
                            <button type="submit" name = "Delete" value="${train.idTrain}">Delete</button>
                        </form>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>



        <div class="col-xs-offset-5 col-xs-10">
            <div class="col-xs-3">
                <a href="/admin-menu" type="button" class="btn btn-lg btn-primary btn-block">Вернуться в админ меню</a>
            </div>
        </div>

    </jsp:body>
</t:_layout>