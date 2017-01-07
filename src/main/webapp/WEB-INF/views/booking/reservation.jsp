<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="messages" var="messages"/>

<t:_layout title="Reservation">
    <jsp:body>

        <table class="table table-hover">
            <thead>
            <tr>
                <th style="width: auto"><fmt:message key="id" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="stationStart" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="departureStation" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="ArrivalDate" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="DepartureDate" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="price" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="nameTrain" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="numberFreePlaces" bundle="${messages}"/></th>
                <th style="width: auto"><fmt:message key="action" bundle="${messages}"/></th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="schedule" varStatus="status" items="${schedules}">
                <tr>

                <th>${schedule.scheduleId}</th>
                <th>${stationStart}</th>
                <th>${stationEnd}</th>
                <th>${schedule.arrivalTime}</th>
                <th>${schedule.departureTime}</th>
                <th>${schedule.price}</th>
                <c:forEach var="train" begin="${status.index}" end="${status.index}" items="${trains}">
                    <th>${train.name}</th>
                    <th>${train.numberFreePlaces}</th>
                    <th>
                        <form name="reservation" action="${pageContext.request.contextPath}/ticket-purchase"
                              method="post">
                            <button type="submit" name="reservation" value="${train.idTrain}"><fmt:message key="reservation" bundle="${messages}"/></button>
                        </form>
                    </th>
                </c:forEach>
                </tr>
            </c:forEach>

            </tbody>
        </table>

    </jsp:body>
</t:_layout>
