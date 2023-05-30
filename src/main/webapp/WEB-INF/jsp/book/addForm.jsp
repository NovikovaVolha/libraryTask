<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить книгу</title>
    </head>
    <body>
        <div class="container">
            <h1>Создание книги</h1>
            <hr>
            <sf:form method="post" action="/books/save" modelAttribute="book">
                <div class="table">
                    <table>
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
                                <sf:select path="authors" multiple="true">
                                    <c:forEach items="${authors}" var="author">
                                        <sf:option value="${author}" label="${author.name} ${author.surname}"/>
                                    </c:forEach>
                                </sf:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="categories">Категория(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:select path="categories" multiple="true">
                                    <c:forEach items="${categories}" var="category">
                                        <sf:option value="${category}" label="${category.name}"/>
                                    </c:forEach>
                                </sf:select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="publisher">Издательство(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:select path="publisher">
                                    <c:forEach items="${publishers}" var="publisher">
                                        <sf:option value="${publisher}" label="${publisher.name} ${publisher.country}"/>
                                    </c:forEach>
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
                                    <c:forEach items="${catalogues}" var="catalogue">
                                        <sf:option value="${catalogue}" label="${catalogue.name}"/>
                                    </c:forEach>
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
                                <div class="button">
                                    <input type="reset" value="Сброс">
                                    <input type="submit" value="Сохранить">
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