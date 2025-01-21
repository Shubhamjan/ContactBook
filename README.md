# ContactBook

A simple web application where users can add, edit, and delete contacts. The application supports user authentication and allows multiple contacts for each user. Built with Java, MySQL, Servlet, JSP, Bootstrap, HTML, CSS, and JavaScript.

## Features

-**Frontend** :
 - HTML
  - CSS
  - JavaScript
  - Bootstrap

  -**Backend** :
  - Java (Servlets, JSP)
  - JDBC for MySQL database interaction
    
  -**Database** :
  - MySQL

## Prerequisites

Before running the project, ensure you have the following:

- **Java JDK** (version 8 or higher)
- **Apache Tomcat** (for running the servlet and JSP application)
- **MySQL Database** (for storing user and contact information)
- **JDBC Driver** for MySQL

## Installation

### Step 1: Set up the MySQL Database

1. Create a MySQL database:

   ```sql
   CREATE DATABASE contact_book;

2. Create a table for storing users:

  ```sql
  CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) DEFAULT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    email VARCHAR(45) NOT NULL UNIQUE,
    password VARCHAR(45) DEFAULT NULL,
    mobile_number VARCHAR(45) DEFAULT NULL,
    address VARCHAR(45) DEFAULT NULL,
    gender VARCHAR(45) DEFAULT NULL
);

3. Create a table for storing Contacts:
  
  CREATE TABLE contacts (
    contact_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(45) DEFAULT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    email VARCHAR(45) DEFAULT NULL,
    phone_number VARCHAR(45) DEFAULT NULL,
    about VARCHAR(1200) DEFAULT NULL,
    userId INT DEFAULT NULL,
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
);


### Step 2: Configure Database Connection
Update the DBConnection.java class to use your MySQL database credentials (username, password, and database URL).
Step 3: Deploy the Project
Import the project into your IDE (e.g., Eclipse) and run it using Apache Tomcat.
Ensure that the necessary JAR files for JDBC are placed in the WEB-INF/lib folder.
Step 4: Access the Application
Open your web browser and navigate to http://localhost:8080/ContactBook/.
Usage
Login: Users must log in with their username and password (stored in the users table).
Add Contact: After logging in, users can add new contacts by filling out a form.
Edit Contact: Users can edit the details of any existing contact.
Delete Contact: Users can delete any contact from their list.



