DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id   BIGINT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    isbn  VARCHAR(255) NOT NULL UNIQUE
);