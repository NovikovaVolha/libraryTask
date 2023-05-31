<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить пользователя</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Создание пользователя</h1>
            <hr>
            <sf:form method="post" action="/users/save" modelAttribute="user">
                <div class="table">
                    <table align="center">
                        <tr>
                            <sf:hidden path="id"/>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="name">Имя(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:input path="name" required="required" title="Обязательно к заполнению"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="surname">Фамилия(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:input path="surname" required="required" title="Обязательно к заполнению"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="passport">№ паспорта</sf:label>
                            </td>
                            <td>
                                <sf:input path="passport" title="Необязательно к заполнению"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="phoneNumber">№ телефона</sf:label>
                            </td>
                            <td>
                                <sf:input path="phoneNumber" title="Необязательно к заполнению"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="roles">Читатель/библиотекарь(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:radiobuttons path="roles" items="${roles}"/>
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
                <a href="<c:url value="/users/all/page"/>"><button type="button">К списку пользователей</button></a>
            </div>
        </div>
    </body>
</html>