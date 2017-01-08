<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Order Tickets">
    <jsp:body>


        <br>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/order-tickets/booking" method="get">
            <div class="form-group">
                <label class="control-label col-xs-5" for="stationArrival"><fmt:message key="departureStation" bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="text" name="stationArrival" class="form-control" id="stationArrival"
                           placeholder=<fmt:message key="enterStationDeparture" bundle="${messages}"/>>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-5" for="stationEnd"><fmt:message key="stationStart" bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name="stationEnd" id="stationEnd"
                           placeholder=<fmt:message key="enterStationArrival" bundle="${messages}"/>>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-xs-5"><fmt:message key="DepartureDate" bundle="${messages}"/></label>
                <div class="col-xs-3">
                    <input type="text" name="date" class="form-control" id="datetimepicker">
                </div>
            </div>

            <div class="col-md-6"></div>
            <div>
                <button class="btn btn-lg btn-primary btn-block" style="width: auto" type="submit"><fmt:message key="search" bundle="${messages}"/></button>
            </div>
            <div class="col-md-4"></div>

        </form>



    </jsp:body>
</t:_layout>

<script type="text/javascript">

    var options = {
        url: "${pageContext.request.contextPath}/suggest/station",
        getValue: "${name}",

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