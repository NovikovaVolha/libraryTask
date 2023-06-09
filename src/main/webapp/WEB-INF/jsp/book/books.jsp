<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Книги</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <<div class="container">
            <h1>Книги</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/books/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <br>
            <br>
            <div class="button">
                <a href="<c:url value="/books/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Автор</th>
                        <th>Заголовок</th>
                        <th>Действия</th>
                    </tr>
                    <c:forEach items="${books}" var="book">
                        <tr>
                            <td>${book.id}</td>
                            <td>${book.authors}</td>
                            <td>${book.title}</td>
                            <td>
                                <a href="<c:url value="/books/${book.id}/fullInfo"/>">Подробнее</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>