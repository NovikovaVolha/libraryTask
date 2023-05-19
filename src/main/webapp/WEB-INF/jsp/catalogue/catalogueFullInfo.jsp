<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталог</title>
    </head>
    <body>
        <h1>Каталог: информация</h1>
        <hr>
        <table class="table table-striped">
            <tr class="thead-light">
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
            <c:forEach var="catalogue" items="${catalogueByName}">
            <tr>
                <td>${catalogue.id}</td>
                <td>${catalogue.name}</td>
                <td>
                    <a href="<c:url value="${catalogue.id}/update"/>">Редактировать</a>
                    <a href="<c:url value="${catalogue.id}/delete"/>">Удалить</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/catalogues"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>