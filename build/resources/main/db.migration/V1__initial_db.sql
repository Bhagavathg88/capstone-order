create extension if not exists "uuid-ossp";

create table ORDERS(
    ORDER_ID LONG AUTO_INCREMENT PRIMARY KEY,
    ORDER_KEY uuid not null,
    PRODUCT_ID LONG NOT NULL,
    USER_ID VARCHAR(30) NOT NULL,
    ORDER_DATE timestamp NOT NULL,
    STATUS VARCHAR(30) NOT NULL
);