<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск каталога</title>
    </head>
    <body>
        <h1>Поиск</h1>
        <hr>
            <form id="searchForm" action="/catalogues/findByName" method="get">
                <table>
                    <tr>
                        <td>
                            <select name="paramName">
                                <option name="name" selected>Название</option>
                            </select>
                        </td>
                        <td>
                            <input form="searchForm" name="name" type="text">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="reset" value="Сброс">
                            <input type="submit" value="Поиск">
                        </td>
                    </tr>
                </table>
            </form>
        <hr>
        <a href="<c:url value="/catalogues/all/page"/>"><button type="button">Вернуться к списку каталогов</button></a>
    </body>
</html>

