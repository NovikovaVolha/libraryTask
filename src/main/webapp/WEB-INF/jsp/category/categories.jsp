<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категории</title>
    </head>
    <body>
        <h1>Категории</h1>
        <hr>
        <a href="<c:url value="/categories/create"/>">Добавить категорию</a>
        <hr>
        <a href="<c:url value="/categories/search"/>">Поиск</a>
        <hr>
        <table class="table table-striped">
            <tr class="thead-light">
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>
                        <a href="<c:url value="/categories/${category.id}/update"/>">Редактировать</a>
                        <a href="<c:url value="/categories/${category.id}/delete"/>">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>