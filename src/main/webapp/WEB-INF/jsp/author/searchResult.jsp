<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Автор: результат поиска</title>
    </head>
    <body>
        <h1>Результат поиска</h1>
        <hr>
        <table id="searchResult">
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
                            <a href="<c:url value="${author.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            <form method="post" action="<c:url value="${author.id}/delete"/>" style="display:inline;">
                                <input type="hidden" name="id" value="${author.id}">
                                <input type="submit" value="Удалить">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/authors/all/page"/>"><button type="button">Вернуться к списку авторов</button></a>
    </body>
</html>