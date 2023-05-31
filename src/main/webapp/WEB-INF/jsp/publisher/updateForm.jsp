<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать издательство</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Редактирование</h1>
            <hr>
                <sf:form id="updateForm" method="post" action="/publishers/save" modelAttribute="publisher">
            <div class="table-update">
                <table align="center">
                    <tr>
                        <sf:hidden path="id"/>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="name">Название: </sf:label>
                        </td>
                        <td>
                            <sf:input path="name" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="country">Страна: </sf:label>
                        </td>
                        <td>
                            <sf:input path="country" size="50"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div class="button">
                                <input type="reset" value="Сброс">
                                <input type="submit" value="Сохранить изменения">
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
                </sf:form>
            <hr>
            <div class="button">
                <a href="<c:url value="/publishers/all/page"/>"><button type="button">К списку издательств</button></a>
            </div>
        </div>
    </body>
</html>