<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить новый каталог</title>
    </head>
    <body>
        <h1>Создание нового каталога</h1>
        <hr>
            <sf:form action="/catalogues/save" modelAttribute="catalogue">
                <label for="name">Название: </label><sf:input id="name" path="name"/> <br>
                <input type="reset">
                <input type="submit" value="Создать">
            </sf:form>
        <hr>
        <a href="<c:url value="/catalogues"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>