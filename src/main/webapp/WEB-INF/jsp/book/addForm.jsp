<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить книгу</title>
    </head>
    <body>
        <h1>Создание книги</h1>
        <hr>
        <sf:form method="post" action="/books/save" modelAttribute="book">
            <table id="addForm">
                <tr>
                    <sf:hidden path="id"/>
                </tr>
                <tr>
                    <td>
                        <sf:label path="ISBN">ISBN(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:input path="ISBN" required="required" title="Обязательно к заполнению"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="title">Заголовок(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:input path="title" required="required" title="Обязательно к заполнению"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="authors">Автор(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:input path="authors" required="required" title="Обязательно к заполнению"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="categories">Категория(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="categories" multiple="true">
                            <sf:options items="${categories}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="publisher">Издательство(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="publisher">
                            <sf:options items="${publishers}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="yearOfIssue">Год выпуска(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:input path="yearOfIssue" required="required" title="Обязательно к заполнению"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="catalogue">Каталог(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:select path="catalogue">
                            <sf:options items="${catalogues}"/>
                        </sf:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <sf:label path="bookAmount">Количество экземпляров(обязательно)</sf:label>
                    </td>
                    <td>
                        <sf:input path="bookAmount" required="required" title="Обязательно к заполнению"/>
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
        <a href="<c:url value="/books/all/page"/>"><button type="button">Вернуться к списку книг</button></a>
    </body>
</html>