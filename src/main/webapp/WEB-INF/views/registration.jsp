<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>



<t:_layout>

    <jsp:body>


    <title>Registration</title>


    <body>
    <h2>Регистрация</h2>
    <form class="form-horizontal" method="post">
        <div class="form-group">
            <label class="control-label col-xs-3" for="lastName">Фамилия:</label>
            <div class="col-xs-9">
                <input type="text" class="form-control"
                       name = "lastName" id="lastName" placeholder="Введите фамилию">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="firstName">Имя:</label>
            <div class="col-xs-9">
                <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Введите имя">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="fatherName">Отчество:</label>
            <div class="col-xs-9">
                <input type="text"
                      name = "patronymic" class="form-control" id="fatherName" placeholder="Введите отчество">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3">Дата рождения:</label>
            <div class="col-xs-3">
                <select class="form-control">
                    <option>Дата</option>
                </select>
            </div>
            <div class="col-xs-3">
                <select class="form-control">
                    <option>Месяц</option>
                </select>
            </div>
            <div class="col-xs-3">
                <select class="form-control">
                    <option>Год</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="inputEmail">Email:</label>
            <div class="col-xs-9">
                <input type="email" name="login" class="form-control" id="inputEmail" placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="inputPassword">Пароль:</label>
            <div class="col-xs-9">
                <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Введите пароль">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-3" for="postalAddress">Серия паспорта:</label>
            <div class="col-xs-9">
                <textarea rows="3" class="form-control" name="passportSerial"
                          id="postalAddress" placeholder="Введите серию паспорта"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
                <label class="checkbox-inline">
                    <input type="checkbox" value="agree">  Я согласен с <a href="#">условиями</a>.
                </label>
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


