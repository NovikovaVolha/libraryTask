<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск категории</title>
    </head>
    <body>
        <h1>Поиск</h1>
        <hr>
            <sf:form method="get" action="/categories/findByName" modelAttribute="category">
                Название: <sf:input path="name"/> <br>
                <input type="reset">
                <input type="submit" value="Поиск">
            </sf:form>
        <hr>
        <a href="<c:url value="/categories/all/page"/>"><button type="button">Вернуться к списку категорий</button></a>
    </body>
</html>