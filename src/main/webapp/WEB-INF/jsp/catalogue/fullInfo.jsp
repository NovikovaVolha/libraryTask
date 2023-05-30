<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталог</title>
    </head>
    <body>
        <div class="container">
            <h1>Каталог: информация</h1>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th>Создание</th>
                        <th>Редактирование</th>
                        <th>Действия</th>
                    </tr>
                    <tr id="catalogue">
                        <td id="catalogueId">${catalogue.id}</td>
                        <td>${catalogue.name}</td>
                        <td>${catalogue.createdAt}</td>
                        <td>${catalogue.updatedAt}</td>
                        <td>
                            <div class="button">
                                <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                            </div>
                            <div class="button">
                                <a href="<c:url value="delete"/>"><button type="button">Удалить</button></a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
            </div>
        </div>
    </body>
</html>