<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить заявку</title>
    </head>
    <body>
        <div class="container">
            <h1>Создание заявки</h1>
            <hr>
                <sf:form method="post" action="/requests/save" modelAttribute="request">
                <div class="table">
                    <table>
                        <tr>
                            <sf:hidden path="id"/>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="librarian">Библиотекарь(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:select path="librarian">
                                    <c:forEach items="${librarians}" var="librarian">
                                        <sf:option value="${librarian}" label="${librarian.name} ${librarian.surname}"/>
                                    </c:forEach>
                                </sf:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="reader">Читатель(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:select path="reader">
                                    <c:forEach items="${readers}" var="reader">
                                        <sf:option value="${reader}" label="${reader.name} ${reader.surname}"/>
                                    </c:forEach>
                                </sf:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="book">Книга(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:select path="book">
                                    <c:forEach items="${books}" var="book">
                                        <sf:option value="${book}"/>
                                    </c:forEach>
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
                                    <input type="submit" value="Сохранить">
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