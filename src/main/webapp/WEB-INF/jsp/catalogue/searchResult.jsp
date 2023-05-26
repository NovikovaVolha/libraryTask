<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Каталог: результат поиска</title>
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
                <c:forEach var="catalogue" items="${catalogues}">
                    <tr>
                        <td>${catalogue.id}</td>
                        <td>${catalogue.name}</td>
                        <td>
                            <a href="<c:url value="${catalogue.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                            <form method="post" action="<c:url value="${catalogue.id}/delete"/>" style="display:inline;">
                                <input type="hidden" name="id" value="${catalogue.id}">
                                <input type="submit" value="Удалить">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>