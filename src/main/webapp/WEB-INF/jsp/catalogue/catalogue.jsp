<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталоги</title>
    </head>
    <body>
        <h1>Каталоги</h1>
        <hr>
        <a href="<c:url value="catalogues/add"/>">Добавить каталог</a>
        <hr>
        <a href="<c:url value="catalogues/search"/>">Поиск</a>
        <hr>
        <table class="table table-striped">
            <tr class="thead-light">
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
                <c:forEach items="${catalogues}" var="catalogue">
                    <tr>
                        <td>${catalogue.id}</td>
                        <td>${catalogue.name}</td>
                        <td>
                            <a href="<c:url value="catalogues/${catalogue.id}/update"/>">Редактировать</a>
                            <a href="<c:url value="catalogues/${catalogue.id}/delete"/>">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
        </table>
    </body>
</html>