<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категория</title>
    </head>
    <body>
        <h1>Категория: информация</h1>
        <hr>
        <table class="table table-striped">
            <tr class="thead-light">
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td>
                            <a href="<c:url value="${category.id}/update"/>">Редактировать</a>
                            <a href="<c:url value="${category.id}/delete"/>">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/categories"/>"><button type="button">Вернуться к списку категорий</button></a>
    </body>
</html>