<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Авторы</title>
    </head>
    <body>
        <h1>Авторы</h1>
        <hr>
        <a href="<c:url value="/authors/addForm"/>"><button type="button">Создать</button></a>
        <hr>
        <a href="<c:url value="/authors/searchForm"/>"><button type="button">Поиск</button></a>
        <hr>
        <table id="allAuthors">
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.surname}</td>
                    <td>
                        <a href="<c:url value="/authors/${author.id}/fullInfo"/>">Подробнее</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>