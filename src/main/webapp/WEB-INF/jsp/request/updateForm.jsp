<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать заявку</title>
    </head>
    <body>
        <h1>Редактирование</h1>
        <hr>
        <sf:form id="updateForm" method="post" action="/requests/save" modelAttribute="request">
            <table id="updateForm">
                <tr>
                    <sf:hidden path="id"/>
                </tr>
                <tr>
                    <td>
                        <sf:label path="librarian">Библиотекарь</sf:label>
                    </td>
                    <td>
                        <sf:input path="librarian"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="reader">Читатель</sf:label>
                    </td>
                    <td>
                        <sf:input path="reader"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="book">Книга</sf:label>
                    </td>
                    <td>
                        <sf:input path="book"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="dateOfIssue">Дата выдачи</sf:label>
                    </td>
                    <td>
                        <sf:input path="dateOfIssue"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="dateOfReturn">Дата возврата</sf:label>
                    </td>
                    <td>
                        <sf:input path="dateOfReturn"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="requestStatus">Статус заявки</sf:label>
                    </td>
                    <td>
                        <sf:select path="requestStatus">
                            <sf:options items="${requestStatuses}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="requestType">Запрос</sf:label>
                    </td>
                    <td>
                        <sf:select path="requestType">
                            <sf:options items="${requestTypes}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="reset" value="Сброс">
                        <input type="submit" value="Сохранить изменения">
                    </td>
                </tr>
            </table>
        </sf:form>
        <hr>
        <a href="<c:url value="/requests/all/page"/>"><button type="button">Вернуться к списку заявок</button></a>
    </body>
</html>