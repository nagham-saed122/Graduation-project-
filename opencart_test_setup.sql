-- OpenCart Test Database Setup

-- 1. Create database
CREATE DATABASE IF NOT EXISTS opencart_test;
USE opencart_test;

-- 2. Create tables
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DECIMAL(10,2),
    stock INT
);

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    product_id INT,
    quantity INT,
    order_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- 3. Insert sample data
INSERT INTO users (firstname, lastname, email, password) VALUES
('John', 'Doe', 'john@example.com', 'pass123'),
('Jane', 'Smith', 'jane@example.com', 'pass456');

INSERT INTO products (name, price, stock) VALUES
('MacBook Pro', 1500.00, 10),
('iPhone 15', 1200.00, 5),
('Logitech Mouse', 50.00, 20);

INSERT INTO orders (user_id, product_id, quantity, order_date) VALUES
(1, 1, 1, '2025-11-10'),
(2, 2, 2, '2025-11-11');

-- 4. Sample queries for validation
-- Total users
SELECT COUNT(*) AS total_users FROM users;

-- Products in stock
SELECT name, stock FROM products WHERE stock > 0;

-- Orders for a specific user
SELECT o.id AS order_id, u.firstname, u.lastname, p.name AS product_name, o.quantity
FROM orders o
JOIN users u ON o.user_id = u.id
JOIN products p ON o.product_id = p.id
WHERE u.email = 'john@example.com';

-- Expensive products
SELECT * FROM products WHERE price > 1000;

-- Total order value per user
SELECT u.firstname, u.lastname, SUM(p.price * o.quantity) AS total_spent
FROM orders o
JOIN users u ON o.user_id = u.id
JOIN products p ON o.product_id = p.id
GROUP BY u.id;
