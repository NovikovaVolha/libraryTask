<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Авторы</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Авторы</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/authors/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/authors/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <hr>
            <div class="table">
                <table>
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
            </div>
        </div>
    </body>
</html>