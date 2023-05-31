<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Книги</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
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
                            <td>
                                <c:forEach items="${book.authors}" var="author">
                                   ${author}
                                </c:forEach>
                            </td>
                            <td>${book.title}</td>
                            <td>
                                <a href="<c:url value="/books/${book.id}/fullInfo"/>">Подробнее</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <hr>
            <div class="table-pagination">
                <table>
                    <tr>
                        Total rows: ${totalElements}
                    </tr>
                    <tr>
                        <td>
                            <c:if test="${currentPage != 1}">
                                <a href="<c:url value="?page=${currentPage - 1}"/>">Предыдущая</a>
                            </c:if>
                        </td>
                        <td>
                            <c:forEach begin="${currentPage}" end="${totalPages}" var="p">
                                <c:choose>
                                    <c:when test="${currentPage eq p}">
                                        ${p}
                                    </c:when>
                                    <c:otherwise>
                                        <a href="<c:url value="?page=${p}"/>">${p}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </td>
                        <td>
                            <c:if test="${currentPage lt totalPages}">
                                <a href="<c:url value="?page=${currentPage + 1}"/>">Следующая</a>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/main"/>"><button type="button">На главную</button></a>
            </div>
        </div>
    </body>
</html>