<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<title>Views all Station</title>

<t:_layout>
    <jsp:body>

        <form class="form-horizontal" method="post">
            <div class="form-group">
                <label class="control-label col-xs-5" for="lastName">Станция отправления:</label>
                <div class="col-xs-3">
                    <input type="text" name="stationArrival" class="form-control" id="lastName"
                           placeholder="Введите станцию отправления">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-5" for="firstName">Станция прибытия:</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name="firstName" id="firstName"
                           placeholder="Введите станцию прибытия">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-xs-5">Дата отправления:</label>

                <div class="col-xs-3">
                    <input type="text" name="date" class="form-control" id="datetimepicker">
                </div>
            </div>
            <div class="form-signin">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
            </div>
        </form>


        <script type="text/javascript">
            $(function () {
                $('#datetimepicker').datetimepicker(
                        {pickTime: false, language: 'ru'}
                );
            });
        </script>
    </jsp:body>
</t:_layout>