<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталоги</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Каталоги</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/catalogues/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <br>
            <br>
            <div class="button">
                <a href="<c:url value="/catalogues/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th>Действия</th>
                    </tr>
                    <c:forEach items="${catalogues}" var="catalogue">
                        <tr>
                            <td>${catalogue.id}</td>
                            <td>${catalogue.name}</td>
                            <td>
                                <a href="<c:url value="/catalogues/${catalogue.id}/fullInfo"/>">Подробнее</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>