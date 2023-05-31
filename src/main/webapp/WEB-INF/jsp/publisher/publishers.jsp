<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Издательства</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Издательства</h1>
            <hr>
            <div class="button">
                <a href="<c:url value="/publishers/addForm"/>"><button type="button">Создать</button></a>
            </div>
            <br>
            <br>
            <div class="button">
                <a href="<c:url value="/publishers/searchForm"/>"><button type="button">Поиск</button></a>
            </div>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Название</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${publishers}" var="publisher">
                        <tr>
                            <td>${publisher.id}</td>
                            <td>${publisher.name}</td>
                            <td>
                                <a href="<c:url value="/publishers/${publisher.id}/fullInfo"/>">Подробнее</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>