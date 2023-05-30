<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Автор: результат поиска</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
    <div class="container">
        <h1>Результат поиска</h1>
        <hr>
        <div class="table">
        <table>
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Действия</th>
            </tr>
                <c:forEach var="author" items="${authors}">
                    <tr>
                        <td>${author.id}</td>
                        <td>${author.name}</td>
                        <td>${author.surname}</td>
                        <td>
                            <div class="button">
                                <a href="<c:url value="${author.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            </div>
                            <div class="button">
                                <a href="<c:url value="${author.id}/delete"/>"><button type="button">Удалить</button></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        </div>
        <hr>
        <div class="button">
            <a href="<c:url value="/authors/all/page"/>"><button type="button">Вернуться к списку авторов</button></a>
        </div>
    </div>
    </body>
</html>