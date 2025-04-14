CREATE DATABASE food_delivery;
USE food_delivery;

-- Create Customer Table
CREATE TABLE Customer_Pratik(
    cusId INT AUTO_INCREMENT PRIMARY KEY,
    cname VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contactNo BIGINT NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Admin Table
CREATE TABLE Admin_Pratik(
    adminId INT AUTO_INCREMENT PRIMARY KEY,
    adminEmail VARCHAR(100) NOT NULL UNIQUE,
    adminPassword VARCHAR(255) NOT NULL
);

INSERT INTO Admin_Pratik (adminEmail, adminPassword) 
VALUES ('pratik@Company.com', 'pratik123');

-- Create Food Table
CREATE TABLE Food_Pratik (
    food_id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(255) NOT NULL,
    type ENUM('veg', 'non-veg') NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(255),
    description TEXT,
    rating INT
);

-- Create Order Table
CREATE TABLE Order_Pratik (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    billingAmount DOUBLE NOT NULL,
    orderDate DATE NOT NULL,
    email VARCHAR(100) NOT NULL,
    dropLocation VARCHAR(255) NOT NULL,
    deliveryDate TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL
);

-- Create Cart Table
CREATE TABLE Cart_Pratik (
    cartId INT AUTO_INCREMENT PRIMARY KEY,
    cusId INT,
    food_id INT,
    quantity INT NOT NULL,
    FOREIGN KEY (cusId) REFERENCES Customer_Pratik(cusId),
    FOREIGN KEY (food_id) REFERENCES Food_Pratik(food_id)
);

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


