<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Пользователь: результат поиска</title>
    </head>
    <body>
        <h1>Результат поиска</h1>
        <hr>
        <table id="searchResult">
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>№ паспорта</th>
                <th>№ телефона</th>
                <th></th>
                <th>Создание</th>
                <th>Редактирование</th>
                <th>Действия</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.passport}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.role.name}</td>
                    <td>${user.createdAt}</td>
                    <td>${user.updatedAt}</td>
                    <td>
                        <a href="<c:url value="${user.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                        <form method="post" action="<c:url value="${user.id}/delete"/>" style="display:inline;">
                            <input type="hidden" name="id" value="${user.id}">
                            <input type="submit" value="Удалить">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <a href="<c:url value="/users/all/page"/>"><button type="button">Вернуться к списку пользователей</button></a>
    </body>
</html>