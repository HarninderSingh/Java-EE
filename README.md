# Springpp - Spring Boot Product CRUD with DAO Layer and H2 Database

This is a Spring Boot application demonstrating a Product CRUD API using the MVC architecture, a dedicated DAO layer, and an H2 in-memory database.

---

## Folder Structure

```
src/main/java/com/techbros/springpp/
│
├── controller/
│     └── ProductController.java
├── dao/
│     ├── ProductDao.java
│     └── ProductDaoImpl.java
├── model/
│     └── Product.java
├── repository/
│     └── ProductRepository.java
├── service/
│     └── ProductService.java
└── SpringppApplication.java
```

---

## Features

- List all products (`GET /products`)
- Get a product by ID (`GET /products/{id}`)
- Create a new product (`POST /products`)
- Update a product (`PUT /products/{id}`)
- Delete a product (`DELETE /products/{id}`)
- Uses H2 in-memory database for persistence
- DAO layer abstracts database operations using Spring Data JPA

---

## How to Run

1. **Clone the repository**
2. **Open in your IDE (e.g., VS Code, IntelliJ)**
3. **Run the main class:**
   ```
   SpringppApplication.java
   ```
4. **API Endpoints:**  
   - `GET     /products`  
   - `GET     /products/{id}`  
   - `POST    /products`  
   - `PUT     /products/{id}`  
   - `DELETE  /products/{id}`  

---

## H2 Database Console

- Access at: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** *(leave blank)*

---

## CSV Import

You can import CSV data into the H2 database using the H2 console and the `CSVREAD` function.  
Example:
```sql
INSERT INTO product (product_name, product_price, product_description, product_quantity)
SELECT "PRODUCT_NAME", "PRODUCT_PRICE", "PRODUCT_DESCRIPTION", "PRODUCT_QUANTITY"
FROM CSVREAD('C:/path/to/products.csv');
```

---

## Requirements

- Java 17+ (or compatible version)
- Maven or Gradle
- Spring Boot

---

## Recent Changes

- **Added DAO Layer:**  
  - `dao/ProductDao.java` (interface)
  - `dao/ProductDaoImpl.java` (implementation)
- **Service Layer** now delegates all database operations to the DAO.
- **Persistence** is handled by H2 in-memory database via Spring Data JPA.
- **Project structure** updated for better separation of concerns.

---

**Author:**  
[Your Name or GitHub Username]