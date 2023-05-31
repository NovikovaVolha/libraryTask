<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Пользователь: результат поиска</title>
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
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>№ паспорта</th>
                        <th>№ телефона</th>
                        <th>Читатель/библиотекарь</th>
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
                            <td>
                                <c:forEach items="${user.roles}" var="role">
                                    ${role}
                                </c:forEach>
                            </td>
                            <td>${user.createdAt}</td>
                            <td>${user.updatedAt}</td>
                            <td>
                                <div class="button">
                                    <a href="<c:url value="${user.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                                </div>
                                <div class="button">
                                    <a href="<c:url value="${user.id}/delete"/>"><button type="button">Удалить</button></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/users/all/page"/>"><button type="button">Вернуться к списку пользователей</button></a>
            </div>
        </div>
    </body>
</html>