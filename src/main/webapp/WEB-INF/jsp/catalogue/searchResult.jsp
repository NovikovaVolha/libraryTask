<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <title>Каталог: результат поиска</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Результат поиска</h1>
            <hr>
            <div class="table">
                <table align="center">
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th>Действия</th>
                    </tr>
                        <c:forEach var="catalogue" items="${catalogues}">
                            <s>
                                <td>${catalogue.id}</td>
                                <td>${catalogue.name}</td>
                                <sec:authorize access="hasRole('LIBRARIAN')">
                                <td>
                                    <div class="button">
                                        <a href="<c:url value="${catalogue.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                                    </div>
                                    <div class="button">
                                        <a href="<c:url value="${catalogue.id}/delete"/>"><button type="button">Удалить</button></a>
                                    </div>
                                </td>
                                </sec:authorize>
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