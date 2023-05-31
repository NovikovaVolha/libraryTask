<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категория: результат поиска</title>
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
                <c:forEach var="category" items="${categories}">
                    <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td>
                            <div class="button">
                                <a href="<c:url value="${category.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            </div>
                            <div class="button">
                                <a href="<c:url value="${category.id}/delete"/>"><button type="button">Удалить</button></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        </div>
        <hr>
        <div class="button">
            <a href="<c:url value="/categories/all/page"/>"><button type="button">Вернуться к списку категорий</button></a>
        </div>
    </div>
    </body>
</html>