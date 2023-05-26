<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить заявку</title>
    </head>
    <body>
        <h1>Создание заявки</h1>
        <hr>
        <sf:form method="post" action="/requests/save" modelAttribute="request">
            <table id="addForm">
                <tr>
                    <sf:hidden path="id"/>
                </tr>
                <tr>
                    <td>
                        <sf:label path="librarian">Библиотекарь(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="librarian">
                            <sf:options items="${librarians}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="reader">Читатель(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="reader">
                            <sf:options items="${readers}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="book">Книга(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="book">
                            <sf:options items="${books}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="dateOfIssue">Дата выдачи</sf:label>
                    </td>
                    <td>
                        <sf:input path="dateOfIssue" title="Формат ввода: yyyy-MM-dd"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="dateOfReturn">Дата возврата</sf:label>
                    </td>
                    <td>
                        <sf:input path="dateOfReturn" title="Формат ввода: yyyy-MM-dd"/>
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
                        <input type="submit" value="Сохранить">
                    </td>
                </tr>
            </table>
        </sf:form>
        <hr>
        <a href="<c:url value="/requests/all/page"/>"><button type="button">Вернуться к списку заявок</button></a>
    </body>
</html>