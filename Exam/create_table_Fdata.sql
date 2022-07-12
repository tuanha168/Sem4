CREATE SCHEMA `FData` ;

USE `FData`;

CREATE TABLE `tbUser` (
                          `id` INT NOT NULL AUTO_INCREMENT,
                          `username` VARCHAR(255) NULL,
                          `password` VARCHAR(255) NULL,
                          PRIMARY KEY (`id`));

INSERT INTO `tbUser` (`username`, `password`) VALUES ('admin', '1234567');

CREATE TABLE `tbProducts` (
                              `id` INT NOT NULL AUTO_INCREMENT,
                              `name` VARCHAR(255) NULL,
                              `price` FLOAT NULL,
                              `amount` INT NULL,
                              `details` VARCHAR(255) NULL,
                              PRIMARY KEY (`id`));

INSERT INTO `tbProducts` (`name`, `price`, `amount`, `details`) VALUES ('test1', '100', '50', 'test product');
