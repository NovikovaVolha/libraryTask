<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталог</title>
    </head>
    <body>
        <h1>Каталог: информация</h1>
        <hr>
        <table id="fullInfo">
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
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <form method="post" action="<c:url value="delete"/>" style="display:inline;">
                        <input type="hidden" name="id" value="${catalogue.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>