## Overview
This is a simple Spring Boot + MySQL CRUD Application for managing projects and tasks.  
It demonstrates entity relationships, validation, and RESTful API endpoints.

## Technologies Used
- Java 17
- Spring Boot 2.7.18
- Spring Data JPA
- MySQL 8+
- Maven
- Postman

---

##  Database Schema (MySQL)
DataBase name :- `javaAPIdb`

Run these command on mysql command line or workbench 

## sql Query - 
CREATE DATABASE javaAPIdb;
USE javaAPIdb;

-- Table: users
CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100) NOT NULL,
  user_password VARCHAR(100) NOT NULL
);

-- Table: project_management
CREATE TABLE project_management (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(150) NOT NULL,
  project_desc TEXT,
  created_at DATETIME,
  updated_at DATETIME,
  user_id BIGINT,
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Table: task
CREATE TABLE task (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  task_name VARCHAR(150) NOT NULL,
  task_status VARCHAR(50),
  created_at DATETIME,
  updated_at DATETIME,
  project_id BIGINT,
  CONSTRAINT fk_project FOREIGN KEY (project_id) REFERENCES project_management(id)
);

## Database Configuration 

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/javaAPIdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080

## Postman testing API

POST - `http://localhost:8080/api/allprojects` - Add new project   
GET - `http://localhost:8080/api/allprojects`  -  List all projects   
PUT - `http://localhost:8080/api/allprojects/{id}`  -  Update project   
DELETE - `http://localhost:8080/api/allprojects/{id}`  -  Delete project   
POST - `http://localhost:8080/api/taskalltask`  -  Add new task   
GET -`http://localhost:8080/api/taskalltask`  -  List all tasks   
PUT  -`http://localhost:8080/api/taskalltask/{id}`  -  Update task   
DELETE  -`http://localhost:8080/api/taskalltask/{id}`  -  Delete task   


##  Example JSONs

### ➕ Add Project (POST)
```json
{
  "projectName": "Erp Software Development",
  "projectDesc": "Spring Boot project for managing all Employeee"
}
```

### ➕ Add Task (POST)
```json
{
  "taskName": "Database setup",
  "taskStatus": "IN_PROGRESS"
}
```

---

## 🧰 How to Run
Import the project in Eclipse (as Maven Project)  
Start MySQL and run the SQL schema (`javaAPIdb.sql`)  
Run `javaAssignment.java`  
Test in Postman → `http://localhost:8080`  


