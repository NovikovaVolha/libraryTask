<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Издательство: результат поиска</title>
    </head>
    <body>
        <h1>Результат поиска</h1>
        <hr>
        <table id="searchResult">
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Страна</th>
                <th>Действия</th>
            </tr>
                <c:forEach var="publisher" items="${publishers}">
                    <tr>
                        <td>${publisher.id}</td>
                        <td>${publisher.name}</td>
                        <td>${publisher.country}</td>
                        <td>
                            <a href="<c:url value="${publisher.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            <form method="post" action="<c:url value="${publisher.id}/delete"/>" style="display:inline;">
                                <input type="hidden" name="id" value="${publisher.id}">
                                <input type="submit" value="Удалить">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/publishers/all/page"/>"><button type="button">Вернуться к списку издательств</button></a>
    </body>
</html>