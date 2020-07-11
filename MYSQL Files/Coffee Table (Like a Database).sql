/*
TRUNCATE TABLE test;
This drops and recreates the table. All data will be nulled.
*/

SHOW DATABASES;

CREATE DATABASE coffee_store;

USE coffee_store;

CREATE TABLE products(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    price DECIMAL(3,2) #Remember (length, decimal places)
);

CREATE TABLE customers(
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10),
    last_name VARCHAR(10),
    gender ENUM('F','M'),
    phone_number VARCHAR(11)
);

CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
	product_id INT,
    customer_id INT,
    order_time DATETIME,
    
    #The names hold no value until we reference the appropriate columns
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

SHOW TABLES;

-- EXPERIMENT 2
SELECT*FROM products;

ALTER TABLE products
ADD COLUMN coffee_origin VARCHAR(30);

ALTER TABLE products
DROP COLUMN coffee_origin;
