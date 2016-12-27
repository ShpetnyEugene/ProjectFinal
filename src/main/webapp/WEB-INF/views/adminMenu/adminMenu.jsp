<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<title>Administration menu</title>

<t:_layout>
    <jsp:body>


        <div class="form-horizontal">
            <div class="col-xs-offset-5 col-xs-10">
                <div class="col-xs-3">
                    <a href="${pageContext.request.contextPath}/admin/trains/add" type="button" class="btn btn-lg btn-primary btn-block">Добавить
                        запись</a>
                </div>
            </div>

            <br>
            <p>

            <div class="col-xs-offset-5 col-xs-10">
                <div class="col-xs-3">
                    <a href="${pageContext.request.contextPath}/admin/trains" type="button" class="btn btn-lg btn-primary btn-block">Показать все поезда
                    </a>
                </div>
            </div>



        </div>


        <div class="form-horizontal">
            <div class="form-group">


            </div>
        </div>


    </jsp:body>
</t:_layout>