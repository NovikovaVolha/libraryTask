<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать категорию</title>
    </head>
    <body>
        <h1>Редактирование категории</h1>
        <hr>
            <sf:form method="post" action="/categories/submit" modelAttribute="category">
                <sf:hidden path="id"/> <br>
                <sf:label path="name">Название: </sf:label><sf:input path="name"/><br>
                <input type="reset">
                <input type="submit" value="Сохранить изменения">
            </sf:form>
        <hr>
        <a href="<c:url value="/categories"/>"><button type="button">Вернуться к списку категорий</button></a>
    </body>
</html>