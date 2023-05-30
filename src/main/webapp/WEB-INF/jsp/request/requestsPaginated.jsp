<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Заявки</title>
    </head>
    <body>
        <div class="container">
            <h1>Заявки</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/requests/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/requests/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Читатель</th>
                        <th>Статус заявки</th>
                        <th>Действия</th>
                    </tr>
                    <c:forEach items="${requests}" var="request">
                        <tr>
                            <td>${request.id}</td>
                            <td>${request.reader}</td>
                            <td>${request.requestStatus}</td>
                            <td>
                                <a href="<c:url value="/requests/${request.id}/fullInfo"/>">Подробнее</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <br>
            <br>
            <br>
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
            <div class="button">
                <a href="<c:url value="/"/>"><button type="button">На главную</button></a>
            </div>
        </div>
    </body>
</html>