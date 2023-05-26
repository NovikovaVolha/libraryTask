<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Книга</title>
    </head>
    <body>
        <h1>Книга: информация</h1>
        <hr>
        <table id="fullInfo">
            <tr>
                <th>№</th>
                <th>ISBN</th>
                <th>Название</th>
                <th>Автор</th>
                <th>Категория</th>
                <th>Издательство</th>
                <th>Год издания</th>
                <th>Каталог</th>
                <th>Количество экземпляров</th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <tr id="book">
                <td id="bookId">${book.id}</td>
                <td>${book.ISBN}</td>
                <td>${book.title}</td>
                <td>${book.authors}</td>
                <td>${book.categories}</td>
                <td>${book.publisher}</td>
                <td>${book.yearOfIssue}</td>
                <td>${book.catalogue}</td>
                <td>${book.bookAmount}</td>
                <td>${book.createdAt}</td>
                <td>${book.updatedAt}</td>
                <td>
                    <a href="<c:url value="updateForm"/>"><button type="button">Редактировать</button></a>
                    <form method="post" action="<c:url value="delete"/>" style="display:inline;">
                        <input type="hidden" name="id" value="${book.id}">
                        <input type="submit" value="Удалить">
                    </form>
                </td>
            </tr>
        </table>
        <hr>
        <a href="<c:url value="/books/all/page"/>"><button type="button">Вернуться к списку книг</button></a>
    </body>
</html>