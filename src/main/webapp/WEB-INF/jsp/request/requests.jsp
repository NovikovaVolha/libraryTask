<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Заявки</title>
    </head>
    <body>
        <h1>Заявки</h1>
        <hr>
        <a href="<c:url value="/requests/addForm"/>"><button type="button">Создать</button></a>
        <hr>
        <a href="<c:url value="/requests/searchForm"/>"><button type="button">Поиск</button></a>
        <hr>
        <table id="allRequests">
            <tr>
                <th>№</th>
                <th>Читатель</th>
                <th>Статус заявки</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.reader}</td>
                    <td>${request.requestStatus}</td>
                    <td>
                        <a href="<c:url value="/requests/${request.id}/fullInfo"/>">Подробнее</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>