<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Издательство: результат поиска</title>
    </head>
    <body>
        <div class="container">
            <h1>Результат поиска</h1>
            <hr>
            <div class="table">
                <table>
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
                                    <div class="button">
                                        <a href="<c:url value="${publisher.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                                    </div>
                                    <div class="button">
                                        <a href="<c:url value="${publisher.id}/delete"/>"><button type="button">Удалить</button></a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/publishers/all/page"/>"><button type="button">Вернуться к списку издательств</button></a>
            </div>
        </div>
    </body>
</html>