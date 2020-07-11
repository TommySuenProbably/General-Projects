CREATE DATABASE test;

USE test;

CREATE TABLE addresses(
	id INT,
    house_number INT,
    city VARCHAR(20),
    zip_code VARCHAR(7)
);

CREATE TABLE people(
	id INT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    address_id INT
);

CREATE TABLE pets(
	id INT,
    name VARCHAR(20),
    species VARCHAR(20),
    owner_id INT
);

DESCRIBE addresses;
DESCRIBE people;
DESCRIBE pets;

ALTER TABLE addresses
ADD PRIMARY KEY(id);
#DROP PRIMARY KEY; #This will keep the column from accepting null values

ALTER TABLE people
ADD PRIMARY KEY(id);

ALTER TABLE pets
ADD PRIMARY KEY(id);

ALTER TABLE people
ADD CONSTRAINT fk_people_address
FOREIGN KEY (address_id) REFERENCES addresses(id);
/*
DROP FOREIGN KEY <constraintName>;
*/

ALTER TABLE pets
ADD CONSTRAINT u_species UNIQUE (species); #Rememebr the name has no effect on the actual constraint
ALTER TABLE pets
DROP INDEX u_species; #This is cmd is a little weird because it uses index
SELECT*FROM pets;

ALTER TABLE pets
CHANGE `species` `type` VARCHAR(20);
ALTER TABLE pets
CHANGE `type` `species` VARCHAR(20);

ALTER TABLE pets
MODIFY `species` VARCHAR(30); #If there is already data, you would be unlikely to change it to a smaller type
DESCRIBE PETS;

ALTER TABLE pets
ADD PRIMARY KEY (id);
ALTER TABLE pets
ADD CONSTRAINT fk_owner_id
FOREIGN KEY (owner_id) REFERENCES people(id);
ALTER TABLE people
ADD COLUMN email VARCHAR(20);
ALTER TABLE people
ADD CONSTRAINT u_people UNIQUE (email);
ALTER TABLE pets
CHANGE `name` `first_name` VARCHAR(20);
ALTER TABLE addresses
MODIFY `zip_code` CHAR(7);
