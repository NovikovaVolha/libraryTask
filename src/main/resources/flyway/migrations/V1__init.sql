CREATE TABLE user
(
    id                      INT         NOT NULL AUTO_INCREMENT,
    name                    VARCHAR(45) NOT NULL,
    surname                 VARCHAR(45) NOT NULL,
    passport                VARCHAR(45) NULL,
    phone_number            VARCHAR(45),
    created_at              timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at              timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    username                VARCHAR(255) DEFAULT NULL,
    password                VARCHAR(255) DEFAULT NULL,
    account_non_expired     BIT(1)      NOT NULL DEFAULT 1,
    account_non_locked      BIT(1)      NOT NULL DEFAULT 1,
    credentials_non_expired BIT(1)      NOT NULL DEFAULT 1,
    enabled                 BIT(1)      NOT NULL DEFAULT 1,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id INT NOT NULL,
    roles   VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (user_id),
    CONSTRAINT user_id
        FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE author
(
    id         INT         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(45) NOT NULL,
    surname    VARCHAR(45) NOT NULL,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE publisher
(
    id         INT         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(45) NOT NULL,
    country    VARCHAR(45) NOT NULL,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id         INT         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(45) NOT NULL,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE catalogue
(
    id         INT         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(45) NOT NULL,
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE book
(
    id            INT          NOT NULL AUTO_INCREMENT,
    ISBN          VARCHAR(45)  NOT NULL,
    title         VARCHAR(150) NOT NULL,
    publisher_id  INT          NOT NULL,
    year_of_issue INT          NOT NULL,
    catalogue_id  INT          NOT NULL,
    book_amount   INT          NOT NULL DEFAULT 1,
    created_at    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT publisherId
        FOREIGN KEY (publisher_id) REFERENCES publisher (id),
    CONSTRAINT catalogueId
        FOREIGN KEY (catalogue_id) REFERENCES catalogue (id)
);

CREATE TABLE book_author
(
    id         int NOT NULL AUTO_INCREMENT,
    book_id    int NOT NULL,
    author_id  int NOT NULL,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT author_id
        FOREIGN KEY (author_id) REFERENCES author (id),
    CONSTRAINT book_id
        FOREIGN KEY (book_id) REFERENCES book (id)
);

CREATE TABLE book_category
(
    id          INT NOT NULL,
    book_id     INT NOT NULL,
    category_id INT NOT NULL,
    created_at  TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT book_id_book
        FOREIGN KEY (book_id) REFERENCES book (id),
    CONSTRAINT category_id_cat
        FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE request
(
    id             INT NOT NULL AUTO_INCREMENT,
    librarian_id   INT NOT NULL,
    reader_id      INT NOT NULL,
    book_id        INT NOT NULL,
    date_of_issue  DATE NULL,
    date_of_return DATE NULL,
    request_status VARCHAR(100) NULL,
    request_type   VARCHAR(100) NULL,
    created_at     TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT librarianID
        FOREIGN KEY (librarian_id) REFERENCES user (id),
    CONSTRAINT readerID
        FOREIGN KEY (reader_id) REFERENCES user (id),
    CONSTRAINT bookID
        FOREIGN KEY (book_id) REFERENCES book (id)
);