<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Views all Station">
    <jsp:body>


        <br>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/order-tickets/reservation" method="get">
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



    </jsp:body>
</t:_layout>

<script type="text/javascript">
    var options = {
        url: "${pageContext.request.contextPath}/suggest/station",
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