<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>



<t:_layout>

    <jsp:body>


    <title>Registration</title>



    <h2>Регистрация</h2>
        <form class="form-horizontal" method="post">
            <div class="form-group">
                <label class="control-label col-xs-4"  for="lastName">Фамилия:</label>
                <div class="col-xs-3">
                    <input type="text" name = "lastName" class="form-control" id="lastName" placeholder="Введите фамилию">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-4" for="firstName">Имя:</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name = "firstName" id="firstName" placeholder="Введите имя">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-4" for="fatherName">Отчество:</label>
                <div class="col-xs-3">
                    <input type="text" class="form-control" name = "patronymic" id="fatherName" placeholder="Введите отчество">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-4">Дата рождения:</label>

                <div class="col-xs-3">
                        <input type="text" name = "date" class="form-control" id="datetimepicker">
                    </div>
            </div>

        <div class="form-group">
            <label class="control-label col-xs-4" for="inputEmail">Email:</label>
            <div class="col-xs-3">
                <input type="email" name="login" class="form-control" id="inputEmail" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-4" for="inputPassword">Пароль:</label>
            <div class="col-xs-3">
                <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Введите пароль">
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-xs-4" for="firstName">Серия паспорта:</label>
            <div class="col-xs-3">
                <input type="text" name="passportSerial" class="form-control" id="postalAddress" placeholder="Введите серию паспорта">
            </div>
        </div>
        <br />
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <input type="submit" class="btn btn-primary" value="Регистрация">
                <input type="reset" class="btn btn-default" value="Очистить форму">
            </div>
        </div>
    </form>



    </jsp:body>
</t:_layout>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker').datetimepicker(
                {pickTime: false, language: 'ru'}
        );
    });
</script>
