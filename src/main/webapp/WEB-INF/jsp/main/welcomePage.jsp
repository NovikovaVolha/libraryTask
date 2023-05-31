<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Стартовая страница</title>
        <link rel="stylesheet" href="/css/welcomePage.css" type="text/css"/>
    </head>
    <body>
        <div class="bgimg">
            <div class="middle">
                <h1>
                    Добро пожаловать в систему Библиотека!
                </h1>
                <hr>
                <p>
                    <a href="<c:url value="/login"/>">Войдите</a>
                </p>
                <br>
                <p>
                    <a href="<c:url value="/registration"/>">Зарегистрируйтесь</a>
                </p>
            </div>
        </div>
    </body>
</html>