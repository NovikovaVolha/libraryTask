<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категория</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Категория: информация</h1>
            <hr>
            <div class="table">
                <table align="center">
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
                            <div class="button">
                                <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                            </div>
                            <div class="button">
                                <a href="<c:url value="delete"/>"><button type="button">Удалить</button></a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/categories/all/page"/>"><button type="button">Вернуться к списку категорий</button></a>
            </div>
        </div>
    </body>
</html>