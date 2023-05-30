<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск автора</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Поиск</h1>
            <hr>
            <form id="searchForm" action="/authors/findBy" method="get">
                <div class="table-search">
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
                <a href="<c:url value="/authors/all/page"/>"><button type="button">К списку авторов</button></a>
            </div>
        </div>
    </body>
</html>