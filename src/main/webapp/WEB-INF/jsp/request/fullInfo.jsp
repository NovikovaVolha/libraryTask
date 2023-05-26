<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Заявки</title>
    </head>
    <body>
        <h1>Заявка: информация</h1>
        <hr>
        <table id="fullInfo">
            <tr>
                <th>№</th>
                <th>Библиотекарь</th>
                <th>Читатель</th>
                <th>Книга</th>
                <th>Дата выдачи</th>
                <th>Дата возврата</th>
                <th>Статус заявки</th>
                <th>Запрос</th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <tr id="request">
                <td id="requestId">${request.id}</td>
                <td>${request.librarian}</td>
                <td>${request.reader}</td>
                <td>${request.book}</td>
                <td>${request.dateOfIssue}</td>
                <td>${request.dateOfReturn}</td>
                <td>${request.requestStatus}</td>
                <td>${request.requestType}</td>
                <td>${request.createdAt}</td>
                <td>${request.updatedAt}</td>
                <td>
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <a href="<c:url value="delete"/>"><button type="button">Удалить</button></a>

                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/requests/all/page"/>"><button type="button">Вернуться к списку заявок</button></a>
    </body>
</html>