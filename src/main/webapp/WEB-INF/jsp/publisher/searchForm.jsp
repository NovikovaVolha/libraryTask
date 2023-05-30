<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск издательства</title>
    </head>
    <body>
        <div class="container">
            <h1>Поиск</h1>
            <hr>
            <form id="searchForm" action="/publishers/findBy" method="get">
                <div class="table-search">
                    <table>
                        <tr>
                            <td>
                                <select name="paramName">
                                    <option name="name" value="name" selected>Название</option>
                                    <option name="country" value="country">Страна</option>
                                </select>
                            </td>
                            <td>
                                <input form="searchForm" name="paramValue" type="text" size="40">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="button">
                                    <input type="reset" value="Сброс">
                                    <input type="submit" value="Поиск">
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
            <hr>
            <div class="button">
                <a href="<c:url value="/publishers/all/page"/>"><button type="button">К списку издательств</button></a>
            </div>
        </div>
    </body>
</html>