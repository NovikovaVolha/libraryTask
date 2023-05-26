INSERT INTO user (id, name, surname, passport, phone_number, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES
    (1, 'Ivan', 'Ivanov', '2010190C017PB3', '375291234567', 'reader1', '$2a$12$sqm0MyVDNa.musAxnR0jQOrCbf2mqHYDA0yX0hZi1EEerAtkewQSC', 1, 1, 1, 1),
    (2, 'Fedor', 'Fedorov', '2020285C017PB3', '375299876543', 'reader2', '$2a$12$IQ1O2yFSa9aZKxOhzXaO3.im9WtwQMBPy17D39Htyg15qWBt45/py', 1, 1, 1, 1),
    (3, 'Anna', 'Karenina', '2030380C017PB3', '375331112233', 'librarian1', '$2a$12$GdgG..TPeH2t.Pskr6kY0OhkXYdcHkd/ntZChLtig13fl8km5T5a6', 1, 1, 1, 1),
    (4, 'Jane', 'Osten', '2040499C017PB3', '375449998877', 'librarian2', '$2a$12$/eRiF1tP8JSZpDZQM5aVvOmaDTTWF172QCk5ntGDoArPUBOUK.oQm', 1, 1, 1, 1);

INSERT INTO user_roles (user_id, roles)
VALUES
    (1, 'ROLE_READER'),
    (2, 'ROLE_READER'),
    (3, 'ROLE_LIBRARIAN'),
    (4, 'ROLE_LIBRARIAN');

INSERT INTO category (id, name)
VALUES
    (1, 'Художественная литература'),
    (2, 'Нехудожественная литература'),
    (3, 'Детская литература'),
    (4, 'Бизнес-литература'),
    (5, 'Учебная литература'),
    (6, 'Психология'),
    (7, 'Медицина'),
    (8, 'Изучение иностранных языков'),
    (9, 'Комиксы и манга'),
    (10, 'Кулинария и напитки'),
    (11, 'Красота, здоровье и спорт');

INSERT INTO author (id, name, surname)
VALUES
    (1, 'Ольга ', 'Примаченко'),
    (2, 'Эрих Мария', 'Ремарк'),
    (3, 'Антуан ', 'де Сент-Экзюпери'),
    (4, 'Джордж ', 'Клейсон'),
    (5, 'Оливер ', 'Сакс');

INSERT INTO publisher (id, name, country)
VALUES
    (1, 'Эксмо', 'Россия'),
    (2, 'АСТ', 'Россия'),
    (3, 'Попурри', 'Беларусь');

INSERT INTO catalogue (id, name)
VALUES
    (1, 'Каталог');

INSERT INTO book (id, ISBN, title, publisher_id, year_of_issue, catalogue_id, book_amount)
VALUES
    (1, '978-5-04-117369-2', 'К себе нежно: книга о том, как ценить и беречь себя', 1, 2020, 1, 2),
    (2, '978-5-17-105398-7', 'Триумфальная арка', 2, 2017, 1, 15),
    (3, '978-5-17-111569-2', 'Три товарища', 2, 2019, 1, 7),
    (4, '978-5-699-94326-5', 'Маленький принц', 1, 2019, 1, 10),
    (5, '978-985-15-5098-8', 'Самый богатый человек в Вавилоне', 3, 2022, 1, 3),
    (6, '978-5-17-112172-3', 'Музкофилия', 2, 2018, 1, 3),
    (7, '978-5-17-090264-4', 'Человек, который принял жену за шляпу', 2, 2015, 1, 4);

INSERT INTO book_author (id, book_id, author_id)
VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 2),
    (4, 4, 3),
    (5, 5, 4),
    (6, 6, 5),
    (7, 7, 5);

INSERT INTO book_category (id, book_id, category_id)
VALUES
    (1, 1, 2),
    (2, 1, 6),
    (3, 2, 1),
    (4, 3, 1),
    (5, 4, 3),
    (6, 5, 4),
    (7, 6, 7),
    (8, 7, 6);

INSERT INTO request (id, librarian_id, reader_id, book_id, date_of_issue, date_of_return, request_status, request_type)
VALUES
    (1, 3, 1, 2, '2023-04-19', '2023-04-22', 'BOOK_ISSUED', 'CHECK_OUT'),
    (2, 4, 2, 5, '2023-04-19', '2023-04-19', 'BOOK_ISSUED', 'READ_IN_READING_ROOM');





