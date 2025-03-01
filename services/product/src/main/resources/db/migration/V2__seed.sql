-- Insert categories
INSERT INTO category (id, name) VALUES
(nextval('category_seq'), 'Electronics'),
(nextval('category_seq'), 'Clothing'),
(nextval('category_seq'), 'Books'),
(nextval('category_seq'), 'Home Appliances'),
(nextval('category_seq'), 'Toys');

-- Insert products
INSERT INTO product (id, name, quantity, price, category_id) VALUES
-- Electronics
(nextval('product_seq'), 'Smartphone', 10, 699.99, (SELECT id FROM category WHERE name = 'Electronics')),
(nextval('product_seq'), 'Laptop', 5, 1299.99, (SELECT id FROM category WHERE name = 'Electronics')),
(nextval('product_seq'), 'Headphones', 15, 199.99, (SELECT id FROM category WHERE name = 'Electronics')),

-- Clothing
(nextval('product_seq'), 'T-Shirt', 50, 19.99, (SELECT id FROM category WHERE name = 'Clothing')),
(nextval('product_seq'), 'Jeans', 30, 49.99, (SELECT id FROM category WHERE name = 'Clothing')),
(nextval('product_seq'), 'Jacket', 20, 99.99, (SELECT id FROM category WHERE name = 'Clothing')),

-- Books
(nextval('product_seq'), 'Programming Book', 20, 39.99, (SELECT id FROM category WHERE name = 'Books')),
(nextval('product_seq'), 'Science Fiction Novel', 15, 24.99, (SELECT id FROM category WHERE name = 'Books')),
(nextval('product_seq'), 'History Book', 10, 29.99, (SELECT id FROM category WHERE name = 'Books')),

-- Home Appliances
(nextval('product_seq'), 'Microwave', 10, 199.99, (SELECT id FROM category WHERE name = 'Home Appliances')),
(nextval('product_seq'), 'Vacuum Cleaner', 8, 149.99, (SELECT id FROM category WHERE name = 'Home Appliances')),
(nextval('product_seq'), 'Air Purifier', 12, 179.99, (SELECT id FROM category WHERE name = 'Home Appliances')),

-- Toys
(nextval('product_seq'), 'Lego Set', 25, 59.99, (SELECT id FROM category WHERE name = 'Toys')),
(nextval('product_seq'), 'Board Game', 30, 34.99, (SELECT id FROM category WHERE name = 'Toys')),
(nextval('product_seq'), 'Action Figure', 40, 14.99, (SELECT id FROM category WHERE name = 'Toys'));