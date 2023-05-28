<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Книга: результат поиска</title>
    </head>
    <body>
        <h1>Результат поиска</h1>
        <hr>
        <table id="searchResult">
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
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
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
                        <a href="<c:url value="${book.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                        <form method="post" action="<c:url value="${book.id}/delete"/>" style="display:inline;">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/books/all/page"/>"><button type="button">Вернуться к списку книг</button></a>
    </body>
</html>