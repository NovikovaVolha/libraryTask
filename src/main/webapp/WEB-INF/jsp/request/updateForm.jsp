<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать заявку</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Редактирование</h1>
            <hr>
                <sf:form id="updateForm" method="post" action="/requests/save" modelAttribute="request">
            <div class="table-update">
                <table align="center">
                    <tr>
                        <sf:hidden path="id"/>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="librarian">Библиотекарь</sf:label>
                        </td>
                        <td>
                            <sf:input path="librarian" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="reader">Читатель</sf:label>
                        </td>
                        <td>
                            <sf:input path="reader" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="book">Книга</sf:label>
                        </td>
                        <td>
                            <sf:input path="book" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="dateOfIssue">Дата выдачи</sf:label>
                        </td>
                        <td>
                            <sf:input path="dateOfIssue" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="dateOfReturn">Дата возврата</sf:label>
                        </td>
                        <td>
                            <sf:input path="dateOfReturn" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="requestStatus">Статус заявки</sf:label>
                        </td>
                        <td>
                            <sf:radiobuttons path="requestStatus" items="${requestStatuses}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="requestType">Запрос</sf:label>
                        </td>
                        <td>
                            <sf:radiobuttons path="requestType" items="${requestTypes}"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div class="button">
                                <input type="reset" value="Сброс">
                                <input type="submit" value="Сохранить изменения">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
                </sf:form>
            <hr>
            <div class="button">
                <a href="<c:url value="/requests/all/page"/>"><button type="button">К списку заявок</button></a>
            </div>
        </div>
    </body>
</html>