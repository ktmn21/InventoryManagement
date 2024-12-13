# Inventory Management System

An Inventory Management System built with Spring Boot that allows users to manage products, categories, and inventory effectively. This application supports CRUD operations, stock management, reporting, and API documentation using Swagger.

---

## Features

- **CRUD Operations**: Create, Read, Update, and Delete for Products and Categories.
- **Inventory Management**:
  - Add stock for a product.
  - Deduct stock (with validation).
  - View low-stock products (stock below a specified threshold).
- **Search and Filter**:
  - Search products by name.
  - Filter products by category.
- **Validation**: Input validation using `javax.validation`.
- **API Documentation**: Swagger UI for interactive API documentation.
- **Logging**: Log application activities using SLF4J and Logback.

---

## Project Setup

### Prerequisites

Ensure the following are installed on your machine:
- **Java 17+**
- **Maven 3.6+**
- **MySQL Server**

## Create a database in MySQL
```
CREATE DATABASE inventory_db;
```

## Build the Project
```
mvn clean install
```

## Run the application
```
mvn spring-boot:run
```
#### The server will start at http://localhost:8080.

---
# Usage
## Access the API
 - **Swagger UI: Open http://localhost:8080/swagger-ui/index.html to explore the API documentation and test endpoints.**

## Sample API Endpoints
**Product Endpoints**
- **Get All Products:** `GET /api/products`
- **Get Product by ID:** `GET /api/products/{id}`
- **Search Product by Name:** `GET /api/products/search?name={product_name}`
- **Filter Products by Category:** `GET /api/products/filter?categoryId={category_id}`
- **Get Low-Stock Products:** `GET /api/products/low-stock/{threshold}`
- **Create a Product:** `POST /api/products`
- **Update a Product:** `PUT /api/products/{id}`
- **Delete a Product:** `DELETE /api/products/{id}`
**Category Endpoints**
- **Get All Categories:** `GET /api/categories`
- **Get Category by ID:** `GET /api/categories/{id}`
- **Create a Category:** `POST /api/categories`
- **Update a Category:** `PUT /api/categories/{id}`
- **Delete a Category:** `DELETE /api/categories/{id}`
