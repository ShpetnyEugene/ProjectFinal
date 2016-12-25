<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>


<t:_layout>
    <jsp:body>




        <table class="table table-hover">
            <thead>
                <tr>
                    <th>idTrain</th>
                    <th>Name</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="train" items="${trains}">
                    <tr>
                        <th>${train.idTrain}</th>
                        <th>${train.name}</th>
                        <th>
                            <form name = "Delete" method="post">
                            <button type="submit" name = ${train.idTrain}>
                                Delete
                            </button>
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>



    </jsp:body>

</t:_layout>