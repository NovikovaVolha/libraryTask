<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать издательство</title>
    </head>
    <body>
        <h1>Редактирование</h1>
        <hr>
        <sf:form id="updateForm" method="post" action="/publishers/save" modelAttribute="publisher">
            <table id="updateForm">
                <tr>
                    <sf:hidden path="id"/>
                </tr>
                <tr>
                    <td>
                        <sf:label path="name">Название: </sf:label>
                    </td>
                    <td>
                        <sf:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="country">Страна: </sf:label>
                    </td>
                    <td>
                        <sf:input path="country"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="reset" value="Сброс">
                        <input type="submit" value="Сохранить изменения">
                    </td>
                </tr>
            </table>
        </sf:form>
        <hr>
        <a href="<c:url value="/publishers/all/page"/>"><button type="button">Вернуться к списку издательств</button></a>
    </body>
</html>