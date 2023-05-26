<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Издательство</title>
    </head>
    <body>
        <h1>Издательство: информация</h1>
        <hr>
        <table id="fullInfo">
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Страна</th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <tr id="publisher">
                <td id="publisherId">${publisher.id}</td>
                <td>${publisher.name}</td>
                <td>${publisher.country}</td>
                <td>${publisher.createdAt}</td>
                <td>${publisher.updatedAt}</td>
                <td>
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <form method="post" action="<c:url value="delete"/>" style="display:inline;">
                        <input type="hidden" name="id" value="${publisher.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/publishers/all/page"/>"><button type="button">Вернуться к списку издательств</button></a>
    </body>
</html>