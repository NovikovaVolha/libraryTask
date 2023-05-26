<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                margin: 0;
            }

            .navbar {
                overflow: hidden;
                background-color: #333;
                font-family: Arial, Helvetica, sans-serif;
            }

            .navbar a {
                float: left;
                font-size: 16px;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            .dropdown {
                float: left;
                overflow: hidden;
            }

            .dropdown .dropbtn {
                font-size: 16px;
                border: none;
                outline: none;
                color: white;
                padding: 14px 16px;
                background-color: inherit;
                font: inherit;
                margin: 0;
            }

            .navbar a:hover, .dropdown:hover .dropbtn {
                background-color: rgba(4, 112, 170, 0.45);
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                width: 100%;
                left: 0;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content .header {
                background: rgba(4, 112, 170, 0.45);
                padding: 16px;
                color: white;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            /* Create three equal columns that floats next to each other */
            .column {
                float: left;
                width: 33.33%;
                padding: 10px;
                background-color: #ccc;
                height: 250px;
            }

            .column a {
                float: none;
                color: black;
                padding: 16px;
                text-decoration: none;
                display: block;
                text-align: left;
            }

            .column a:hover {
                background-color: #ddd;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .column {
                    width: 100%;
                    height: auto;
                }
            }
        </style>
    </head>
    <body>
        <div class="navbar">
            <a href="#home">Главная</a>
            <div class="dropdown">
                <button class="dropbtn">Меню
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <div class="row">
                        <div class="column">
                            <h3>Авторы</h3>
                            <a href="<c:url value="/authors/all/page"/>">Список</a>
                            <a href="<c:url value="/authors/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/authors/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Заявки</h3>
                            <a href="<c:url value="/requests/all/page"/>">Список</a>
                            <a href="<c:url value="/requests/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/requests/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Издательства</h3>
                            <a href="<c:url value="/publishers/all/page"/>">Список</a>
                            <a href="<c:url value="/publishers/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/publishers/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Каталоги</h3>
                            <a href="<c:url value="/catalogues/all/page"/>">Список</a>
                            <a href="<c:url value="/catalogues/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/catalogues/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Категории</h3>
                            <a href="<c:url value="/categories/all/page"/>">Список</a>
                            <a href="<c:url value="/categories/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/categories/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Книги</h3>
                            <a href="<c:url value="/books/all/page"/>">Список</a>
                            <a href="<c:url value="/books/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/books/addForm"/>">Добавить</a>
                        </div>
                        <div class="column">
                            <h3>Пользователи</h3>
                            <a href="<c:url value="/users/all/page"/>">Список</a>
                            <a href="<c:url value="/users/searchForm"/>">Поиск</a>
                            <a href="<c:url value="/users/addForm"/>">Добавить</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="padding:16px">
            <h3>Добро пожаловать в систему!</h3>
        </div>
    </body>
</html>