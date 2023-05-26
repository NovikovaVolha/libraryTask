<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск автора</title>
    </head>
    <body>
        <h1>Поиск</h1>
        <hr>
        <form id="searchForm" action="/authors/findBy" method="get">
            <table>
                <tr>
                    <td>
                        <select name="paramName">
                            <option name="name" value="name" selected>Имя</option>
                            <option name="surname" value="surname">Фамилия</option>
                        </select>
                    </td>
                    <td>
                        <input form="searchForm" name="paramValue" type="text" size="40">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="reset" value="Сброс">
                        <input type="submit" value="Поиск">
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="<c:url value="/authors/all/page"/>"><button type="button">Вернуться к списку авторов</button></a>
    </body>
</html>