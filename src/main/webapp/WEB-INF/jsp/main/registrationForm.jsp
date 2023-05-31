<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Добавить пользователя</title>
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    <style>
        .error {
            color: #730303;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Регистрация пользователя</h1>
        <hr>
            <sf:form method="post" action="/registration" modelAttribute="user">
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
                                <sf:label path="passport">№ паспорта(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:input path="passport" title="Обязательно к заполнению" placeholder="*******C***PB*"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="phoneNumber">№ телефона(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:input path="phoneNumber" title="Обязательно к заполнению" placeholder="375 ** *** ** **"/>
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
                            <td>
                                <sf:label path="username">Имя пользователя(обязательно)</sf:label>
                            </td>
                            <td>
                                    <div class="username">
                                        <sf:input path="username" title="Обязательно к заполнению"/>
                                        <sf:errors path="username" cssClass="error"></sf:errors>
                                    </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="password">Пароль(обязательно)</sf:label>
                            </td>
                            <td>
                                    <div class="password">
                                        <sf:input path="password" title="Обязательно к заполнению"/>
                                        <sf:errors path="password" cssClass="error"></sf:errors>
                                    </div>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <div class="button">
                                    <button type="submit" value="Сохранить">Сохранить</button>
                                    <button type="reset" value="Сброс">Сброс</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </sf:form>
        <hr>
        <div class="button">
            <a href="<c:url value="/"/>"><button type="button">Назад</button></a>
        </div>
    </div>
</body>
</html>