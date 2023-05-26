<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Автор</title>
    </head>
    <body>
        <h1>Автор: информация</h1>
        <hr>
        <table id="fullInfo">
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
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <form method="post" action="<c:url value="delete"/>" style="display:inline;">
                        <input type="hidden" name="id" value="${author.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/authors/all/page"/>"><button type="button">Вернуться к списку авторов</button></a>
    </body>
</html>