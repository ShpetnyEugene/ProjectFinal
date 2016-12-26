<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>


<title>Add Station</title>

<t:_layout>
    <jsp:body>


        <form method="post" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-xs-3" for="station">Название станции:</label>
                <div class="col-xs-4">
                    <input type="text" name="nameStation" class="form-control" id="station"
                           placeholder="Введите название поезда">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3" for="lastName">Количество свободных мест:</label>
                <div class="col-xs-4">
                    <input type="text" name="nameStation" class="form-control" id="lastName"
                           placeholder="Введите колличество свободных мест">
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-9">
                    <input type="submit" class="btn btn-primary" value="Добавить запись">
                    <input type="reset" class="btn btn-default" value="Очистить форму">
                </div>
            </div>
        </form>


    </jsp:body>
</t:_layout>