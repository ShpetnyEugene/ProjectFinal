<%--suppress ALL --%>
<%--suppress ALL --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Views all Station</title>

<t:_layout>
    <jsp:body>


        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>


        <br>
        <form class="form-horizontal" action="/order-tickets/reservation" method="post">
            <div class="form-group">
                <label class="control-label col-xs-5" for="stationArrival">Станция отправления:</label>
                <div class="col-xs-3">
                    <input type="text" name="stationArrival" class="form-control" id="stationArrival"
                           placeholder="Введите станцию отправления">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-5" for="stationEnd">Станция прибытия:</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name="stationEnd" id="stationEnd"
                           placeholder="Введите станцию прибытия">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-xs-5">Дата отправления:</label>
                <div class="col-xs-3">
                    <input type="text" name="date" class="form-control" id="datetimepicker">
                </div>
            </div>

            <div style="align-content: center">
                <button class="btn btn-lg btn-primary btn-block" style="width: auto" type="submit">Search</button>
            </div>


        </form>


        <script type="text/javascript">

            var options = {
                url: "http://localhost:8080/suggest/station",


                getValue: "name",

                list: {
                    match: {
                        enabled: true
                    }
                },
                theme: "square"
            };

            $("#stationArrival,#stationEnd").easyAutocomplete(options);


            $(function () {
                $('#datetimepicker').datetimepicker(
                        {pickTime: false, language: 'ru'}
                );
            });
        </script>
    </jsp:body>
</t:_layout>