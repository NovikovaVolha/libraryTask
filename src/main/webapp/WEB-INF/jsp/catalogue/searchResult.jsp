<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталог: результат поиска</title>
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
                        <th>Действия</th>
                    </tr>
                        <c:forEach var="catalogue" items="${catalogues}">
                            <tr>
                                <td>${catalogue.id}</td>
                                <td>${catalogue.name}</td>
                                <td>
                                    <div class="button">
                                        <a href="<c:url value="${catalogue.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                                    </div>
                                    <div class="button">
                                        <a href="<c:url value="${catalogue.id}/delete"/>"><button type="button">Удалить</button></a>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
            </div>
        </div>
    </body>
</html>