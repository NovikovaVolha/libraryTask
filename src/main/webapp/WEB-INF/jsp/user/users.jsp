<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Пользователи</title>
    </head>
    <body>
        <h1>Пользователи</h1>
        <hr>
        <a href="<c:url value="/users/addForm"/>"><button type="button">Создать</button></a>
        <hr>
        <a href="<c:url value="/users/searchForm"/>"><button type="button">Поиск</button></a>
        <hr>
        <table id="allBooks">
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>
                        <a href="<c:url value="/users/${user.id}/fullInfo"/>">Подробнее</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>