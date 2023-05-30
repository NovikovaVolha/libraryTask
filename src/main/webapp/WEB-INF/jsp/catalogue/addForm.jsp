<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Добавить новый каталог</title>
    </head>
    <body>
        <div class="container">
            <h1>Создание нового каталога</h1>
            <hr>
                <sf:form method="post" action="/catalogues/save" modelAttribute="catalogue">
                <div class="table">
                    <table>
                        <tr>
                            <sf:hidden path="id"/>
                        </tr>
                        <tr>
                            <td>
                                <sf:label path="name">Название(обязательно)</sf:label>
                            </td>
                            <td>
                                <sf:input path="name" required="required" title="Обязательно к заполнению"/>
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
                <a href="<c:url value="/catalogues/all/page"/>"><button type="button">К списку каталогов</button></a>
            </div>
        </div>
    </body>
</html>