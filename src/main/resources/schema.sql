CREATE TABLE BOOK_GENRE(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    desc VARCHAR(1000) NULL
);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE AUTHOR(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    data_of_birth DATE NULL,
    data_of_death DATE NULL
);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE USER_LIBRARY(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NULL,
    date_of_birth DATE NOT NULL,
    picture BINARY(100) NULL
);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE BOOK(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    price BIGINT NOT NULL,
    genre_id BIGINT
);
ALTER TABLE BOOK
    ADD CONSTRAINT BOOK_GENRE_ID
    FOREIGN KEY (genre_id) REFERENCES BOOK_GENRE(id);

------------------------------------------------------------------------------------------------------------------------
CREATE TABLE BOOK_AUTHORS(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    author_id BIGINT NULL
);
ALTER TABLE BOOK_AUTHORS
    ADD CONSTRAINT BOOK_AUTHORS_BOOK_ID
    FOREIGN KEY (book_id) REFERENCES BOOK(id);
ALTER TABLE BOOK_AUTHORS
    ADD CONSTRAINT BOOK_AUTHORS_AUTHOR_ID
    FOREIGN KEY (author_id) REFERENCES AUTHOR(id);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE COMMENT(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    rating INTEGER NOT NULL,
    content VARCHAR(1000) NULL,
    created DATE NOT NULL,
    book_id BIGINT,
    user_id BIGINT
);
ALTER TABLE COMMENT
    ADD CONSTRAINT COMMENT_BOOK_ID
    FOREIGN KEY (book_id) REFERENCES BOOK(id);
ALTER TABLE COMMENT
    ADD CONSTRAINT COMMENT_USER_ID
    FOREIGN KEY (user_id) REFERENCES USER_LIBRARY(id);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE TRANSACTION(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_transaction DATE NOT NULL
);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE SHOPPING_CART(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    transaction_id BIGINT NULL
);
ALTER TABLE SHOPPING_CART
    ADD CONSTRAINT SHOPPING_CART_USER_ID
    FOREIGN KEY (user_id) REFERENCES USER_LIBRARY(id);
ALTER TABLE SHOPPING_CART
    ADD CONSTRAINT SHOPPING_CART_TRANSACTION_ID
    FOREIGN KEY (transaction_id) REFERENCES TRANSACTION(id);
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE CART_ITEM(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    shopping_cart_id BIGINT NOT NULL
);
ALTER TABLE CART_ITEM
    ADD CONSTRAINT CART_ITEM_BOOK_ID
    FOREIGN KEY (book_id) REFERENCES BOOK(id);
ALTER TABLE CART_ITEM
    ADD CONSTRAINT CART_ITEM_SHOPPING_CART_ID
    FOREIGN KEY (shopping_cart_id) REFERENCES SHOPPING_CART(id);
------------------------------------------------------------------------------------------------------------------------

