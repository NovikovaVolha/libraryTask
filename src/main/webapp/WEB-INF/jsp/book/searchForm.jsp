<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск книги</title>
    </head>
    <body>
        <div class="container">
            <h1>Поиск</h1>
            <hr>
            <form id="searchForm" action="/books/findBy" method="get">
                <div class="table-search">
                    <table>
                        <tr>
                            <td>
                                <select form="searchForm" name="paramName">
                                    <option name="title" value="title" selected>Заголовок</option>
                                    <option name="ISBN" value="ISBN">ISBN</option>
                                    <option name="authorName" value="authorName">Автор</option>
                                    <option name="categoryName" value="categoryName">Категория</option>
                                    <option name="publisherName" value="publisherName">Издательство</option>
                                    <option name="yearOfIssue" value="yearOfIssue">Год издания</option>
                                    <option name="catalogueName" value="catalogueName">Каталог</option>
                                    <option name="bookAmount" value="bookAmount">Количество экземпляров</option>
                                </select>
                            </td>
                            <td>
                                <input form="searchForm" name="paramValue" type="text" size="40">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="button">
                                    <input type="reset" value="Сброс">
                                    <input type="submit" value="Поиск">
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            <hr>
            <div class="button">
                <a href="<c:url value="/books/all/page"/>"><button type="button">К списку книг</button></a>
            </div>
        </div>
    </body>
</html>

