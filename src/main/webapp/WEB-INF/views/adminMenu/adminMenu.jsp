<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<title>Administration menu</title>

<t:_layout>
    <jsp:body>
        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>


        <table class="table table-condensed">
            <thead>
            <tr>
                <th><fmt:message key="trainControl" bundle="${messages}"/></th>
                <th><fmt:message key="userControl" bundle="${messages}"/></th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <th>
                    <div class="col-xs-offset-4 col-xs-9">
                        <div class="col-xs-6">
                            <a style="text-align: center" href="${pageContext.request.contextPath}/admin/trains/add"><fmt:message key="addRecords" bundle="${messages}"/></a>
                        </div>
                    </div>
                </th>

                <th>

                    <div class="col-xs-offset-5 col-xs-9">
                        <div class="col-xs-7">
                            <a style="text-align: center" href="${pageContext.request.contextPath}/admin/users"><fmt:message key="showAllUsers" bundle="${messages}"/></a>
                        </div>
                    </div>

                </th>
            </tr>

            <tr>
                <th>
                    <div class="col-xs-offset-4 col-xs-9">
                        <div class="col-xs-7">
                            <a style="text-align: center" href="${pageContext.request.contextPath}/admin/trains"><fmt:message key="showAllTrains" bundle="${messages}"/></a>
                        </div>
                    </div>
                </th>
            </tr>
            </tbody>
        </table>


        <div class="col-xs-offset-4 col-xs-9">
            <div class="col-xs-3">
                <a href="${pageContext.request.contextPath}/home" style="width: 170%" type="button" class="btn btn-lg btn-primary btn-block"><fmt:message key="backHomePage" bundle="${messages}"/></a>
            </div>
        </div>


    </jsp:body>
</t:_layout>