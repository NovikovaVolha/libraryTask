<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Поиск заявок</title>
        <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Поиск</h1>
            <hr>
            <form id="searchForm" action="/requests/findBy" method="get">
                <div class="table-search">
                    <table align="center">
                        <tr>
                            <td>
                                <select form="searchForm" name="paramName">
                                    <option name="reader" value="reader" selected>Читатель</option>
                                    <option name="librarian" value="librarian">Библиотекарь</option>
                                    <option name="book" value="book">Книга</option>
                                    <option name="dateOfIssue" value="dateOfIssue">Дата выдачи</option>
                                    <option name="dateOfReturn" value="dateOfReturn">Дата возврата</option>
                                    <option name="requestStatus" value="requestStatus">Статус заявки</option>
                                    <option name="requestType" value="requestType">Запрос</option>
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
                <a href="<c:url value="/requests/all/page"/>"><button type="button">К списку заявок</button></a>
            </div>
        </div>
    </body>
</html>

