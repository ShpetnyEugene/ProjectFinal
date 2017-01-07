<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:_layout title="Home">
    <jsp:body>

        <fmt:setLocale value="${locale}"/>
        <fmt:setBundle basename="messages" var="messages"/>
        <div class="page-header">
            <h1>Главная страница</h1>
            <p class="lead"><fmt:message key="homeHello" bundle="${messages}"/></p>
        </div>


        <!-- Button trigger modal -->


        <button data-target="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</button>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                    </div>
                    <div class="modal-body">
                fghfggfghfghfghfhfhfghfg
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:_layout>