# Spring Security Product Management System

A Spring Boot application with JWT-based authentication and role-based authorization for product management.

## Features

- **Spring Security with JWT**: Secure authentication using JSON Web Tokens
- **Role-Based Access Control**: Different permissions for USER and ADMIN roles
- **Product Management**: CRUD operations for products with security
- **User Management**: User registration and authentication
- **H2 Database**: In-memory database for development

## Security Implementation

### Authentication
- JWT-based token authentication
- Password encryption using BCrypt
- Stateless session management

### Authorization
- **USER Role**: Can view, create, and update products
- **ADMIN Role**: Can perform all USER operations plus delete products and access admin endpoints

## API Endpoints

### Authentication Endpoints (Public)
- `POST /auth/register` - Register a new user
- `POST /auth/login` - Login and get JWT token
- `GET /auth/test` - Test authentication endpoint

### Product Endpoints (Require Authentication)
- `GET /products` - Get all products (USER, ADMIN)
- `GET /products/{id}` - Get product by ID (USER, ADMIN)
- `POST /products` - Create new product (USER, ADMIN)
- `PUT /products/{id}` - Update product (USER, ADMIN)
- `DELETE /products/{id}` - Delete product (ADMIN only)

### Admin Endpoints (ADMIN only)
- `GET /admin/dashboard` - Admin dashboard
- `POST /admin/create-admin` - Create new admin user
- `GET /admin/users` - Get all users
- `DELETE /admin/users/{userId}` - Delete user

## Default Users

The application creates default users on startup:

### Admin User
- **Username**: admin
- **Password**: admin123
- **Roles**: ADMIN, USER

### Regular User
- **Username**: user
- **Password**: user123
- **Roles**: USER

## How to Use

### 1. Start the Application
```bash
mvn spring-boot:run
```

### 2. Register a New User
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "newuser",
    "email": "newuser@example.com",
    "password": "password123"
  }'
```

### 3. Login and Get JWT Token
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'
```

### 4. Use JWT Token for Authenticated Requests
```bash
curl -X GET http://localhost:8080/products \
  -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
```

### 5. Access Admin Endpoints
```bash
curl -X GET http://localhost:8080/admin/dashboard \
  -H "Authorization: Bearer YOUR_JWT_TOKEN_HERE"
```

## Security Configuration

### JWT Configuration
- **Secret Key**: Configured in `application.properties`
- **Expiration**: 24 hours (configurable)
- **Algorithm**: HS256

### Password Security
- **Encoder**: BCrypt with default strength
- **Minimum Length**: 6 characters

### CORS Configuration
- All origins allowed for development
- Can be restricted for production

## Database

- **Type**: H2 In-Memory Database
- **Console**: Available at `http://localhost:8080/h2-console`
- **Auto-creation**: Tables and sample data created automatically

## Project Structure

```
src/main/java/com/techbros/springpp/
├── config/
│   ├── SecurityConfig.java          # Spring Security configuration
│   └── DataInitializer.java         # Data initialization
├── controller/
│   ├── AuthController.java          # Authentication endpoints
│   ├── ProductController.java       # Product management endpoints
│   └── AdminController.java         # Admin-only endpoints
├── dto/
│   ├── LoginRequest.java            # Login request DTO
│   ├── RegisterRequest.java         # Registration request DTO
│   └── AuthResponse.java            # Authentication response DTO
├── model/
│   ├── Product.java                 # Product entity
│   └── User.java                    # User entity
├── repository/
│   ├── ProductRepository.java       # Product data access
│   └── UserRepository.java          # User data access
├── security/
│   ├── JwtUtil.java                 # JWT utility functions
│   ├── JwtAuthenticationFilter.java # JWT authentication filter
│   └── CustomUserDetailsService.java # Custom user details service
└── service/
    ├── ProductService.java          # Product business logic
    └── UserService.java             # User business logic
```

## Technologies Used

- **Spring Boot 3.4.6**
- **Spring Security**
- **Spring Data JPA**
- **H2 Database**
- **JWT (JSON Web Tokens)**
- **Maven**
- **Java 21**

## Security Best Practices Implemented

1. **Password Encryption**: BCrypt password hashing
2. **JWT Token Security**: Secure token generation and validation
3. **Role-Based Access**: Method-level and URL-level security
4. **Input Validation**: Bean validation for all inputs
5. **Exception Handling**: Proper error handling and responses
6. **Stateless Authentication**: No server-side session storage
7. **CORS Configuration**: Cross-origin resource sharing setup

## Testing the Application

### 1. Test Public Endpoints
```bash
# Test authentication endpoint
curl http://localhost:8080/auth/test
```

### 2. Test User Registration
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "testpass123"
  }'
```

### 3. Test Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "testpass123"
  }'
```

### 4. Test Protected Endpoints
```bash
# Replace YOUR_TOKEN with the JWT token from login response
curl -X GET http://localhost:8080/products \
  -H "Authorization: Bearer YOUR_TOKEN"
```

### 5. Test Admin Endpoints
```bash
# Login as admin first
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "admin",
    "password": "admin123"
  }'

# Use admin token to access admin endpoints
curl -X GET http://localhost:8080/admin/dashboard \
  -H "Authorization: Bearer ADMIN_TOKEN"
```

## Error Handling

The application includes comprehensive error handling:

- **Authentication Errors**: Invalid credentials, expired tokens
- **Authorization Errors**: Insufficient permissions
- **Validation Errors**: Invalid input data
- **Resource Errors**: Not found, conflict errors

## Future Enhancements

1. **Refresh Tokens**: Implement token refresh mechanism
2. **Password Reset**: Add password reset functionality
3. **Email Verification**: Email verification for new registrations
4. **Audit Logging**: Track user actions and system events
5. **Rate Limiting**: Implement API rate limiting
6. **Two-Factor Authentication**: Add 2FA support

---

**Author:** Harninder Singh