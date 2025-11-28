use opencart_db;

-- Doha ramadan database positive tests
-- DB 1: User Registration
INSERT INTO oc_customer (customer_id, customer_group_id, firstname, lastname, email, telephone, password, status, date_added) VALUES
(1001, 1, 'Doha', 'Ramadan', 'doha.ramadan@test.com', '123456789', 'hashed_password_123', 1, '2024-01-15 10:00:00');
SELECT * FROM oc_customer WHERE customer_id = 1001;

-- DB 2: Product Management
INSERT INTO oc_product (product_id, model, quantity, price, status, date_added) VALUES
(1001, 'PROD-001', 50, 99.99, 1, '2024-01-15 10:00:00');
SELECT * FROM oc_product WHERE product_id = 1001;

-- DB 3: Order Creation
INSERT INTO oc_order (order_id, customer_id, firstname, lastname, email, total, order_status_id, date_added) VALUES
(1001, 1001, 'Doha', 'Ramadan', 'doha.ramadan@test.com', 199.98, 1, '2024-01-15 11:00:00');
SELECT * FROM oc_order WHERE order_id = 1001;

-- DB 4: Category Structure
INSERT INTO oc_category (category_id, parent_id, status) VALUES
(1001, 0, 1),
(1002, 1001, 1);
SELECT * FROM oc_category WHERE category_id IN (1001, 1002);

-- DB 5: Customer Login
INSERT INTO oc_customer_login (customer_login_id, email, ip, total, date_added, date_modified) VALUES
(1001, 'doha.ramadan@test.com', '192.168.1.100', 1, '2024-01-15 10:05:00', '2024-01-15 10:05:00');
SELECT * FROM oc_customer_login WHERE customer_login_id = 1001;

-- DB 6: Shopping Cart
INSERT INTO oc_cart (cart_id, customer_id, product_id, quantity, date_added) VALUES
(1001, 1001, 1001, 1, '2024-01-15 10:30:00');
SELECT * FROM oc_cart WHERE cart_id = 1001;

-- DB 7: Product Search
INSERT INTO oc_product_description (product_id, language_id, name, description, tag) VALUES
(1001, 1, 'Test Product', 'This is a test product description', 'test,product');
SELECT * FROM oc_product_description WHERE product_id = 1001;

-- DB 8: Inventory Management
INSERT INTO oc_product (product_id, model, quantity, stock_status_id, status, date_added) VALUES
(1002, 'PROD-002', 0, 5, 1, '2024-01-15 10:00:00');
SELECT * FROM oc_product WHERE product_id = 1002;

-- DB 9: Customer Addresses
INSERT INTO oc_address (address_id, customer_id, firstname, lastname, address_1, city, postcode, country_id, zone_id) VALUES
(1001, 1001, 'Doha', 'Ramadan', '123 Test Street', 'Test City', '12345', 1, 1);
SELECT * FROM oc_address WHERE address_id = 1001;

-- DB 10: Product Reviews
INSERT INTO oc_review (review_id, product_id, customer_id, author, text, rating, status, date_added) VALUES
(1001, 1001, 1001, 'Doha Ramadan', 'Great test product!', 5, 1, '2024-01-15 12:00:00');
SELECT * FROM oc_review WHERE review_id = 1001;

-- Ahmed Ghoneim database positive tests
-- DB 11: Wishlist Functionality
INSERT INTO oc_customer_wishlist (customer_id, product_id, date_added) VALUES
(1001, 1001, '2024-01-15 10:45:00');
SELECT * FROM oc_customer_wishlist WHERE customer_id = 1001;

-- DB 12: Order Status Updates
INSERT INTO oc_order_history (order_history_id, order_id, order_status_id, comment, date_added) VALUES
(1001, 1001, 2, 'Order processing started', '2024-01-15 11:30:00');
SELECT * FROM oc_order_history WHERE order_history_id = 1001;

-- DB 13: Tax Calculations
INSERT INTO oc_tax_rate (tax_rate_id, name, rate, type) VALUES
(1001, 'Test Tax Rate', 8.00, 'P');
SELECT * FROM oc_tax_rate WHERE tax_rate_id = 1001;

-- DB 14: Shipping Methods
INSERT INTO oc_length_class (length_class_id, value) VALUES
(1001, 1.00000000);
SELECT * FROM oc_length_class WHERE length_class_id = 1001;

-- DB 15: Payment Methods
INSERT INTO oc_order (order_id, customer_id, payment_method, total, order_status_id, date_added) VALUES
(1002, 1001, 'Credit Card', 150.00, 1, '2024-01-15 12:00:00');
SELECT * FROM oc_order WHERE order_id = 1002;

-- Nagham Ahmed database positive tests
-- DB 16: Customer Groups
INSERT INTO oc_customer_group (customer_group_id, approval, sort_order) VALUES
(1001, 0, 2);
SELECT * FROM oc_customer_group WHERE customer_group_id = 1001;

-- DB 17: Product Options
INSERT INTO oc_product_option (product_option_id, product_id, option_id, required) VALUES
(1001, 1001, 1, 1);
SELECT * FROM oc_product_option WHERE product_option_id = 1001;

-- DB 18: Discount Coupons
INSERT INTO oc_coupon (coupon_id, name, code, type, discount, status, date_added) VALUES
(1001, 'Test Coupon', 'TEST10', 'P', 10.00, 1, '2024-01-15 10:00:00');
SELECT * FROM oc_coupon WHERE coupon_id = 1001;

-- DB 19: Manufacturer Data
INSERT INTO oc_manufacturer (manufacturer_id, name, sort_order) VALUES
(1001, 'Test Manufacturer', 1);
SELECT * FROM oc_manufacturer WHERE manufacturer_id = 1001;

-- DB 20: Multi-store Setup
INSERT INTO oc_store (store_id, name, url) VALUES
(1001, 'Test Store', 'http://teststore.com');
SELECT * FROM oc_store WHERE store_id = 1001;


-- DB 21: Product Discount
INSERT INTO oc_product_discount (product_discount_id, product_id, customer_group_id, quantity, priority, price, date_start, date_end) VALUES
(1001, 1001, 1, 10, 1, 79.99, '2024-01-01', '2024-12-31');
SELECT * FROM oc_product_discount WHERE product_discount_id = 1001;

-- DB 22: Product filter
INSERT INTO oc_product_filter (product_id, filter_id) VALUES
(1001, 1);
SELECT * FROM oc_product_filter WHERE product_id = 1001 AND filter_id = 1;

-- DB 23: Attribute Group
INSERT INTO oc_attribute_group (attribute_group_id, sort_order) VALUES
(1001, 1);
SELECT * FROM oc_attribute_group WHERE attribute_group_id = 1001;

-- DB 24: Filter Group
INSERT INTO oc_filter_group (filter_group_id, sort_order) VALUES
(1001, 1);
SELECT * FROM oc_filter_group WHERE filter_group_id = 1001;

-- DB 25: Customer Reward
INSERT INTO oc_customer_reward (customer_reward_id, customer_id, order_id, description, points, date_added) VALUES
(1001, 1001, 1001, 'Purchase Reward', 100, '2024-01-15 12:00:00');
SELECT * FROM oc_customer_reward WHERE customer_reward_id = 1001;



-- Kareem Fareed database postive tests
-- DB 26: Customer online
INSERT INTO oc_customer_online (ip, customer_id, url, referer, date_added) VALUES
('192.168.1.100', 1001, 'http://teststore.com/product', 'http://google.com', '2024-01-15 10:00:00');
SELECT * FROM oc_customer_online WHERE customer_id = 1001;

-- DB 27: Return
INSERT INTO oc_return (return_id, order_id, product_id, customer_id, firstname, lastname, email, telephone, product, model, quantity, opened, return_reason_id, return_status_id, date_added) VALUES
(1001, 1001, 1001, 1001, 'Doha', 'Ramadan', 'doha.ramadan@test.com', '123456789', 'Test Product', 'PROD-001', 1, 0, 1, 1, '2024-01-15 13:00:00');
SELECT * FROM oc_return WHERE return_id = 1001;

-- DB 28: Customer Group Description
INSERT INTO oc_customer_group_description (customer_group_id, language_id, name, description) VALUES
(1001, 1, 'Premium Members', 'Premium customer group');
SELECT * FROM oc_customer_group_description WHERE customer_group_id = 1001;

-- DB 29: Download
INSERT INTO oc_download (download_id, filename, mask, date_added) VALUES
(1001, 'digital_product.pdf', 'digital_file_001.pdf', '2024-01-15 10:00:00');
SELECT * FROM oc_download WHERE download_id = 1001;

-- DB 30: Customer affiliate
INSERT INTO oc_customer_affiliate (customer_id, company, website, tracking, commission, tax, cheque, paypal, bank_name, bank_branch_number, bank_swift_code, bank_account_name, bank_account_number, custom_field, status, date_added) VALUES
(1001, 'Test Company', 'http://test.com', 'TRACK1001', 5.00, '', 'Check Payable', '', '', '', '', '', '', '', 1, '2024-01-15 10:00:00');
SELECT * FROM oc_customer_affiliate WHERE customer_id = 1001;

-- Ahmed Ghoneim database negative tests

-- DB 31: Customer (User Registration fails with NULL email)
INSERT INTO oc_customer (customer_id, firstname, lastname, email) VALUES
(2001, 'Test', 'User', NULL);
SELECT * FROM oc_customer WHERE customer_id = 2001;

-- DB 32: Product (Product creation fails with negative price)
INSERT INTO oc_product (product_id, model, price, status) VALUES
(2001, 'NEG-001', -99.99, 1);
SELECT * FROM oc_product WHERE product_id = 2001;

-- DB 33: Order (Order creation fails with non-existent customer_id)
INSERT INTO oc_order (order_id, customer_id, total, date_added) VALUES
(2001, 9999, 100.00, NOW());
SELECT * FROM oc_order WHERE order_id = 2001;

-- DB 34: Category (Category creation fails with invalid parent_id)
INSERT INTO oc_category (category_id, parent_id, sort_order, status) VALUES
(2001, 9999, 1, 1);
SELECT * FROM oc_category WHERE category_id = 2001;

-- DB 35: Customer Login (Login entry fails with invalid IP)
INSERT INTO oc_customer_login (customer_login_id, email, ip, date_added) VALUES
(2001, 'test@test.com', '999.999.999.999', NOW());
SELECT * FROM oc_customer_login WHERE customer_login_id = 2001;

-- Kareem Fareed database negative tests

-- DB 36: Cart (Shopping cart entry fails with zero quantity)
INSERT INTO oc_cart (cart_id, customer_id, product_id, quantity, date_added) VALUES
(2001, 1001, 1001, 0, NOW());
SELECT * FROM oc_cart WHERE cart_id = 2001;

-- DB 37: Product Description (Fails with empty name and description)
INSERT INTO oc_product_description (product_id, language_id, name, description) VALUES
(1004, 1, '', '');
SELECT * FROM oc_product_description WHERE product_id = 1004;

-- DB 38: Address (Fails with NULL postcode)
INSERT INTO oc_address (address_id, customer_id, firstname, lastname, postcode) VALUES
(2001, 1001, 'Test', 'User', NULL);
SELECT * FROM oc_address WHERE address_id = 2001;

-- DB 39: Review (Fails with rating exceeding maximum)
INSERT INTO oc_review (review_id, product_id, customer_id, author, text, rating, status, date_added) VALUES
(2001, 1001, 1001, 'Bad User', 'Invalid rating', 10, 1, NOW());
SELECT * FROM oc_review WHERE review_id = 2001;

-- DB 40: Wishlist (Fails with non-existent product_id)
INSERT INTO oc_customer_wishlist (customer_id, product_id, date_added) VALUES
(1001, 9999, NOW());
SELECT * FROM oc_customer_wishlist WHERE product_id = 9999;
