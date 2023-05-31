<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Авторизация</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1 align="center">Авторизация</h1>
            <hr>
            <form method="post" action="/login">
                <div class="table">
                    <table align="center">
                        <tr>
                            <td>
                                Имя пользователя:
                            </td>
                            <td>
                                <input type="text" name="username"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Пароль:
                            </td>
                            <td>
                                <input type="password" name="password"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" value="Войти"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>