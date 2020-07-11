USE coffee_store;

SELECT * FROM customers; #We will start adding the spaces to enforce the spacing
SELECT  last_name FROM customers;
SELECT last_name, phone_number FROM customers; #You can call the same column twice

#Inequalities work the same as normal programming
SELECT * FROM products
WHERE price = 3.00
AND coffee_origin = 'Colombia'; #There are no such products yet
								#OR will do as expected
                                
SELECT * FROM customers
WHERE phone_number IS NULL; # ! = NOT

-- ----------------------------------------------------
SELECT first_name, phone_number FROM customers
WHERE gender = 'F'
AND last_name = 'Bluth';

SELECT name FROM products 
WHERE price > 3.00
AND coffee_origin = 'Sri Lanka';

SELECT * FROM customers
WHERE gender ='M'
AND phone_number IS NULL;
-- -----------------------------------------------------

SELECT * FROM customers
WHERE last_name IN ('Taylor', 'Bluth', 'Armstrong');

SELECT product_id, customer_id, order_time FROM orders
WHERE order_time BETWEEN '2017-01-01' AND '2017-01-07';

/*
% = means any number of unknown characters
_ = means only one is allowed.
As noted, these signs can be used in front and back.
*/
SELECT * FROM customers
WHERE last_name LIKE 'W%';
SELECT * FROM customers
WHERE last_name LIKE '%O%'; 

SELECT * FROM products
ORDER BY price
AND name; #DESC is implicit. There is also ASC. More than one parameter is allowed

-- -----------------------------------------------------------
SELECT * FROM products
WHERE coffee_origin IN ('Brazil', 'Indonesia')
ORDER BY NAME ASC;

SELECT * FROM orders
WHERE customer_id in (2, 4, 6, 8)
AND order_time BETWEEN '2017-01-31' AND '2017-02-28';

SELECT first_name, phone_number FROM customers
WHERE last_name LIKE '%ar%';