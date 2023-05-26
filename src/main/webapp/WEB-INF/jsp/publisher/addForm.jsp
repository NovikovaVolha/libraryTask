<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить новое издательство</title>
    </head>
    <body>
        <h1>Создание нового издательства</h1>
        <hr>
            <sf:form method="post" action="/publishers/save" modelAttribute="publisher">
                <table id="addForm">
                    <tr>
                        <sf:hidden path="id"/>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="name">Название(обязательно)</sf:label>
                        </td>
                        <td>
                            <sf:input path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="country">Страна(обязательно)</sf:label>
                        </td>
                        <td>
                            <sf:input path="country" required="required" title="Обязательно к заполнению"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="reset" value="Сброс">
                            <input type="submit" value="Сохранить">
                        </td>
                    </tr>
                </table>
            </sf:form>
        <hr>
        <a href="<c:url value="/publishers/all/page"/>"><button type="button">Вернуться к списку издательств</button></a>
    </body>
</html>