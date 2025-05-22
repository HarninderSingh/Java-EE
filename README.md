# Springpp - Simple Spring Boot Product CRUD (In-Memory)

This is a simple Spring Boot application demonstrating a Product CRUD API using the MVC architecture.  
**No database is required**—the app uses an in-memory list with some dummy products for demonstration and testing.

## Folder Structure

```
src/main/java/com/techbros/springpp/
│
├── controller/
│     └── ProductController.java
├── model/
│     └── Product.java
├── repository/
│     └── (not used in in-memory mode)
├── service/
│     └── ProductService.java
└── SpringppApplication.java
```

## Features

- List all products (`GET /products`)
- Get a product by ID (`GET /products/{id}`)
- Create a new product (`POST /products`)
- Update a product (`PUT /products/{id}`)
- Delete a product (`DELETE /products/{id}`)
- Returns some dummy products on startup

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

## Example Dummy Products

- Laptop
- Phone
- Headphones

## Notes

- All data is lost when the app restarts (in-memory only).
- No database configuration is needed.
- For a persistent version, implement the repository layer and connect to a database.

## Requirements

- Java 17+ (or compatible version)
- Maven or Gradle (for dependency management)
- Spring Boot

---

**Author:**  
Harninder Singh