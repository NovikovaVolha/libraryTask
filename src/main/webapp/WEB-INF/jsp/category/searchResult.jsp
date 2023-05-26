<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Категория: результат поиска</title>
    </head>
    <body>
        <h1>Результат поиска</h1>
        <hr>
        <table id="searchResult">
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
                            <a href="<c:url value="${category.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            <form method="post" action="<c:url value="${category.id}/delete"/>" style="display:inline;">
                                <input type="hidden" name="id" value="${category.id}">
                                <input type="submit" value="Удалить">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/categories/all/page"/>"><button type="button">Вернуться к списку категорий</button></a>
    </body>
</html>