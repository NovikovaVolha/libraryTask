<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить новый каталог</title>
    </head>
    <body>
    <p>Создание нового каталога</p>
        <hr>
            <sf:form action="save" modelAttribute="catalogue">
                    Название: <sf:input path="name"/> <br>
                <input type="submit" value="Создать">
            </sf:form>

    <hr>

    <a href="<c:url value="/catalogues"/>">Вернуться к списку каталогов</a>
    </body>
</html>