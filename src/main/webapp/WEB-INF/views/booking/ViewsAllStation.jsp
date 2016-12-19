<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stations</title>

    <head>
        <!-- ... -->
        <!-- 1. Подключить библиотеку jQuery -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/jquery-1.11.1.min.js"></script>
        <!-- 2. Подключить скрипт moment-with-locales.min.js для работы с датами -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/moment-with-locales.min.js"></script>
        <!-- 3. Подключить скрипт платформы Twitter Bootstrap 3 -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
        <!-- 4. Подключить скрипт виджета "Bootstrap datetimepicker" -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
        <!-- 5. Подключить CSS платформы Twitter Bootstrap 3 -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" />
        <!-- 6. Подключить CSS виджета "Bootstrap datetimepicker" -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-datetimepicker.min.css" />
    </head>



</head>

<form method="post">

    <div class="row">
        <div class="col-xs-6">
            <div class="form-group">
        <input type="text" name = "arrivalDate" class="form-control" id="datetimepicker">
    </div>
</div>

        <div class="row">
            <div class="col-xs-6">
                <div class="form-group">
                    <input type="text" name = "arrivalStation" class="form-control">
                </div>
            </div>



            <input type="submit" value="Искать">
</form>





<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker(
                {pickTime: false, language: 'ru'}
        );
    });
</script>
</html>
