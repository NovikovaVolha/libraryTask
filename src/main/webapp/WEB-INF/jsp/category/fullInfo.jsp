<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категория</title>
    </head>
    <body>
        <h1>Категория: информация</h1>
        <hr>
        <table id="fullInfo">
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <tr id="category">
                <td id="categoryId">${category.id}</td>
                <td>${category.name}</td>
                <td>${category.createdAt}</td>
                <td>${category.updatedAt}</td>
                <td>
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <form method="post" action="<c:url value="delete"/>" style="display:inline;">
                        <input type="hidden" name="id" value="${category.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/categories/all/page"/>"><button type="button">Вернуться к списку категорий</button></a>
    </body>
</html>