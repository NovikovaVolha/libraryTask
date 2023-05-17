<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
        <head>
            <title>Редактировать каталог</title>
        </head>
        <body>
            <p>Редактирование каталога</p>
            <hr>

            <sf:form method="POST" action="/save" modelAttribute="catalogue">
                Название: <sf:input path="name"/> <br>
                <input type="submit" value="Сохранить изменения">
            </sf:form>

            <hr>

            <a href="<c:url value="/catalogues"/>">Вернуться к списку каталогов</a>
        </body>
</html>