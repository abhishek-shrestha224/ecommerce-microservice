-- V2__Seed_category_table.sql

INSERT INTO category (name) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home & Kitchen'),
('Sports & Outdoors');

-- V2__Seed_product_table.sql

INSERT INTO product (name, quantity, price, category_id) VALUES
('Laptop', 10, 999.99, 1),
('Smartphone', 20, 699.00, 1),
('T-Shirt', 50, 29.99, 2),
('Jeens', 30, 49.99, 2),
('The Lord of the Rings', 15, 19.95, 3),
('Harry Potter and the Sorcerer''s Stone', 25, 15.50, 3),
('Blender', 12, 59.99, 4),
('Coffee Maker', 8, 79.00, 4),
('Basketball', 40, 24.99, 5),
('Running Shoes', 35, 89.95, 5);