<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать каталог</title>
    </head>
    <body>
        <h1>Редактирование каталога</h1>
        <hr>
            <sf:form id="updateForm" method="post" action="/catalogues/save" modelAttribute="catalogue">
                <sf:hidden path="id"/> <br>
                <sf:label path="name">Название: </sf:label><sf:input path="name"/><br>
                <input type="reset">
                <input type="submit" value="Сохранить изменения">
            </sf:form>
        <hr>
        <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>