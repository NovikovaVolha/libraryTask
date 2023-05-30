<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск пользователя</title>
    </head>
    <body>
        <div class="container">
            <h1>Поиск</h1>
            <hr>
            <form id="searchForm" action="/users/findBy" method="get">
                <div class="table-search">
                    <table>
                        <tr>
                            <td>
                                <select form="searchForm" name="paramName">
                                    <option name="name" value="name" selected>Имя</option>
                                    <option name="surname" value="surname">Фамилия</option>
                                    <option name="passport" value="passport">№ паспорта</option>
                                    <option name="phoneNumber" value="phoneNumber">№ телефона</option>
                                    <option name="roles" value="roles">Читатель/библиотекарь</option>
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
                <a href="<c:url value="/users/all/page"/>"><button type="button">К списку пользователей</button></a>
            </div>
        </div>
    </body>
</html>

