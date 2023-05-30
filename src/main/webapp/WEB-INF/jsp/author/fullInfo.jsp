<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Автор</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Автор: информация</h1>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Создание</th>
                        <th>Редактирование</th>
                        <th>Действия</th>
                    </tr>
                    <tr id="author">
                        <td id="authorId">${author.id}</td>
                        <td>${author.name}</td>
                        <td>${author.surname}</td>
                        <td>${author.createdAt}</td>
                        <td>${author.updatedAt}</td>
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
                <a href="<c:url value="/authors/all/page"/>"><button type="button">Вернуться к списку авторов</button></a>
            </div>
        </div>
    </body>
</html>