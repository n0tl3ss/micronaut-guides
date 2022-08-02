DROP TABLE IF EXISTS book;

CREATE TABLE book (
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY,
    name  VARCHAR(255) NOT NULL,
    isbn  VARCHAR(255) NOT NULL UNIQUE
);
