<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Заявки</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Заявки</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/requests/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <br>
            <br>
            <div class="button">
                <a href="<c:url value="/requests/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <hr>
            <div class="table">
                <table>
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
            </div>
        </div>
    </body>
</html>