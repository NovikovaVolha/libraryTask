<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категории</title>
    </head>
    <body>
        <h1>Категории</h1>
        <hr>
        <a href="<c:url value="/categories/addForm"/>"><button type="button">Создать</button></a>
        <hr>
        <a href="<c:url value="/categories/searchForm"/>"><button type="button">Поиск</button></a>
        <hr>
        <table id="allCategories">
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td>
                        <a href="<c:url value="/categories/${category.id}/fullInfo"/>">Подробнее</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>