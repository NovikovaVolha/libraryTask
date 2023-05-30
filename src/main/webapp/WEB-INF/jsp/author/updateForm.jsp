<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать автора</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Редактирование</h1>
            <hr>
                <sf:form id="updateForm" method="post" action="/authors/save" modelAttribute="author">
            <div class="table-update">
                <table>
                    <tr>
                        <sf:hidden path="id"/>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="name">Имя:</sf:label>
                        </td>
                        <td>
                            <sf:input path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="surname">Фамилия:</sf:label>
                        </td>
                        <td>
                            <sf:input path="surname"/>
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
                <a href="<c:url value="/authors/all/page"/>"><button type="button">К списку авторов</button></a>
            </div>
        </div>
    </body>
</html>