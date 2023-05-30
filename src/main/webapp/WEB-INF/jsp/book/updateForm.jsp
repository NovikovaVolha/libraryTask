<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Редактировать книгу</title>
    </head>
    <body>
        <div class="container">
            <h1>Редактирование</h1>
            <hr>
                <sf:form id="updateForm" method="post" action="/books/save" modelAttribute="book">
            <div class="table-update">
                <table>
                    <tr>
                        <sf:hidden path="id"/>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="ISBN">ISBN: </sf:label>
                        </td>
                        <td>
                            <sf:input path="ISBN"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="title">Заголовок: </sf:label>
                        </td>
                        <td>
                            <sf:input path="title"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="authors">Автор: </sf:label>
                        </td>
                        <td>
                            <sf:input path="authors"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="categories">Категория: </sf:label>
                        </td>
                        <td>
                            <sf:input path="categories"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="publisher">Издательство: </sf:label>
                        </td>
                        <td>
                            <sf:input path="publisher"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="yearOfIssue">Год выпуска: </sf:label>
                        </td>
                        <td>
                            <sf:input path="yearOfIssue"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="catalogue">Каталог: </sf:label>
                        </td>
                        <td>
                            <sf:input path="catalogue"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <sf:label path="bookAmount">Количество экземпляров: </sf:label>
                        </td>
                        <td>
                            <sf:input path="bookAmount"/>
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
                <a href="<c:url value="/books/all/page"/>"><button type="button">К списку книг</button></a>
            </div>
        </div>
    </body>
</html>