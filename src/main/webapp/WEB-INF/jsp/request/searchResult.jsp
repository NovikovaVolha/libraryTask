<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Заявка: результат поиска</title>
    </head>
    <body>
        <div class="container">
            <h1>Результат поиска</h1>
            <hr>
            <div class="table">
                <table>
                    <tr>
                        <th>№</th>
                        <th>Библиотекарь</th>
                        <th>Читатель</th>
                        <th>Книга</th>
                        <th>Дата выдачи</th>
                        <th>Дата возврата</th>
                        <th>Статус заявки</th>
                        <th>Запрос</th>
                        <th>Создание</th>
                        <th>Редактирование</th>
                        <th>Действия</th>
                    </tr>
                    <c:forEach var="request" items="${requests}">
                        <tr>
                            <td>${request.id}</td>
                            <td>${request.librarian}</td>
                            <td>${request.reader}</td>
                            <td>${request.book}</td>
                            <td>${request.dateOfIssue}</td>
                            <td>${request.dateOfReturn}</td>
                            <td>${request.requestStatus}</td>
                            <td>${request.requestType}</td>
                            <td>${request.createdAt}</td>
                            <td>${request.updatedAt}</td>
                            <td>
                                <div class="button">
                                    <a href="<c:url value="/${request.id}/updateForm"/>"><button type="button">Редактировать</button></a>
                                </div>
                                <div class="button">
                                    <a href="<c:url value="/${request.id}/delete"/>"><button type="button">Удалить</button></a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <hr>
            <div class="button">
                <a href="<c:url value="/requests/all/page"/>"><button type="button">Вернуться к списку заявок</button></a>
            </div>
        </div>
    </body>
</html>