-- V1__Create_category_table.sql

CREATE SEQUENCE category_id_seq;

CREATE TABLE category (
    id INTEGER PRIMARY KEY DEFAULT nextval('category_id_seq'),
    name VARCHAR(255) NOT NULL UNIQUE
);

ALTER SEQUENCE category_id_seq OWNED BY category.id;

-- V1__Create_product_table.sql

CREATE SEQUENCE product_id_seq;

CREATE TABLE product (
    id INTEGER PRIMARY KEY DEFAULT nextval('product_id_seq'),
    name VARCHAR(255),
    quantity INTEGER,
    price DECIMAL(10, 2),
    category_id INTEGER,
    FOREIGN KEY (category_id) REFERENCES category(id)
);

ALTER SEQUENCE product_id_seq OWNED BY product.id;