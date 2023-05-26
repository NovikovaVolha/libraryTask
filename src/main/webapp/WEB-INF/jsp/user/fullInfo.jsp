<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Пользователи</title>
    </head>
    <body>
        <h1>Пользователь: информация</h1>
        <hr>
        <table id="fullInfo">
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>№ паспорта</th>
                <th>№ телефона</th>
                <th></th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <tr id="book">
                <td id="bookId">${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.passport}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.role}</td>
                <td>${user.createdAt}</td>
                <td>${user.updatedAt}</td>
                <td>
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <a href="<c:url value="delete"/>"><button type="button">Удалить</button></a>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/users/all/page"/>"><button type="button">Вернуться к списку пользователей</button></a>
    </body>
</html>