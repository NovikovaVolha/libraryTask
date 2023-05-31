<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Книга</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Книга: информация</h1>
            <hr>
            <div class="table">
                <table align="center">
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
                        <td>
                            <c:forEach items="${book.authors}" var="author">
                                ${author}
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${book.categories}" var="category">
                                ${category}
                            </c:forEach>
                        </td>
                        <td>${book.publisher}</td>
                        <td>${book.yearOfIssue}</td>
                        <td>${book.catalogue}</td>
                        <td>${book.bookAmount}</td>
                        <td>${book.createdAt}</td>
                        <td>${book.updatedAt}</td>
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
                <a href="<c:url value="/books/all/page"/>"><button type="button">Вернуться к списку книг</button></a>
            </div>
        </div>
    </body>
</html>