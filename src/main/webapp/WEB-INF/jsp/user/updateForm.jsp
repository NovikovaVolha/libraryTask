<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать пользователя</title>
    </head>
    <body>
        <div class="container">
            <h1>Редактирование</h1>
            <hr>
                <sf:form id="updateForm" method="post" action="/users/save" modelAttribute="user">
            <div class="table-update">
                <table>
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
                            <sf:label path="roles">Читатель/библиотекарь</sf:label>
                        </td>
                        <td>
                            <sf:input path="roles"/>
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
                <a href="<c:url value="/users/all/page"/>"><button type="button">К списку пользователей</button></a>
            </div>
        </div>
    </body>
</html>