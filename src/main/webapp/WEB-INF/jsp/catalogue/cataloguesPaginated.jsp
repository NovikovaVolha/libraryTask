<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категории</title>
    </head>
    <body>
        <h1>Категории</h1>
        <hr>
        <a href="<c:url value="/catalogues/addForm"/>">Добавить категорию</a>
        <hr>
        <a href="<c:url value="/catalogues/searchForm"/>">Поиск</a>
        <hr>
        <table id="allCategories" class="table table-striped">
            <tr class="thead-light">
                <th>№</th>
                <th>Название</th>
                <th>Действия</th>
            </tr>
                <c:forEach items="${catalogues}" var="catalogue">
                    <tr>
                        <td>${catalogue.id}</td>
                        <td>${catalogue.name}</td>
                        <td>
                            <a href="<c:url value="/catalogues/${catalogue.id}/fullInfo"/>">Подробнее</a>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <br>
        <br>
        <br>
        Total rows: ${totalElements}
        <hr>

            <c:if test="${currentPage != 1}">
                <td><a href="<c:url value="?page=${currentPage - 1}"/>">Предыдущая</a></td>
            </c:if>

        <table id="pagination">
            <tr>
                <c:forEach begin="${currentPage}" end="${totalPages}" var="p">
                    <c:choose>
                        <c:when test="${currentPage eq p}">
                            <td>${p}</td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="<c:url value="?page=${p}"/>">${p}</a></td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </table>

        <c:if test="${currentPage lt totalPages}">
            <td><a href="<c:url value="?page=${currentPage + 1}"/>">Следующая</a></td>
        </c:if>
    </body>
</html>