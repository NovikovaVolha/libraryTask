<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать пользователя</title>
    </head>
    <body>
        <h1>Редактирование</h1>
        <hr>
        <sf:form id="updateForm" method="post" action="/users/save" modelAttribute="user">
            <table id="updateForm">
                <tr>
                    <sf:hidden path="id"/>
                </tr>
                <tr>
                    <td>
                        <sf:label path="name">Имя</sf:label>
                    </td>
                    <td>
                        <sf:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="surname">Фамилия</sf:label>
                    </td>
                    <td>
                        <sf:input path="surname"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="passport">№ паспорта</sf:label>
                    </td>
                    <td>
                        <sf:input path="passport"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="phoneNumber">№ телефона</sf:label>
                    </td>
                    <td>
                        <sf:input path="phoneNumber"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="role">Читатель/библиотекарь</sf:label>
                    </td>
                    <td>
                        <sf:input path="role"/>
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
        <a href="<c:url value="/users/all/page"/>"><button type="button">Вернуться к списку пользователей</button></a>
    </body>
</html>