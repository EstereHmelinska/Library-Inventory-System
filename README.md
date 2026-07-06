# Library Book Tracker API + Spring Security

## Practical Task

Implemented a REST API for managing a library's book inventory using Spring Boot, Spring Data JPA and H2 database.

### Core Functionality Implemented

- Created REST endpoints for managing books.
- Implemented the ability to:
  - Create a new book.
  - Retrieve all books.
  - Retrieve a single book by its ID.
  - Update an existing book.
  - Delete a book.
- Implemented searching books by author.
- Implemented retrieving only available books.
- Used DTOs (`CreateBookRequest`, `UpdateBookRequest`, `BookResponse`) for request and response handling.
- Implemented layered architecture:
  - Controller
  - Service
  - Repository
- Used Spring Data JPA for database operations.
- Used an H2 in-memory database for data persistence.

## Bonus Features Implemented

- Added request validation using Jakarta Validation:
  - `@NotBlank`
  - `@Positive`
  - `@Valid`
- Implemented searching books published after a given year.
- Implemented searching books by partial title.
- Added an endpoint to return the total number of books in the library.
- Implemented custom exception handling using:
  - `BookNotFoundException`
  - `@ControllerAdvice`
  - `@ExceptionHandler`
  - GlobalExceptionHandler
- Added structured JSON error responses using a Java Record (`ErrorResponse`).

# Spring Security
## Basic Authentication

Implemented Spring Security using HTTP Basic Authentication.

## Features implemented:

- BCrypt password encoding.
- Two in-memory users:
  - `user` with role `USER`
  - `admin` with role `ADMIN`
- Stateless session management.
- GET endpoints accessible to authenticated users.
- POST, PUT and DELETE endpoints accessible only to users with the `ADMIN` role.

### Implementation available in branch:
`feature/basic-auth-security`

## JWT Authentication (Stretch Goal)

Extended the project by replacing Basic Authentication with JWT (JSON Web Token) authentication.

## Implemented:

- JWT token generation after successful login.
- `/auth/login` endpoint for user authentication.
- Custom `JwtAuthenticationFilter` for validating JWTs on every request.
- Token-based authentication using the `Authorization: Bearer <token>` header.
- Secret key stored in `application.properties`.
- Role-based authorization using JWT.
- Stateless authentication without server-side sessions.

### Implementation available in branch:
`feature/jwt-authentication`

## Testing

The application was tested using Postman.

Verified functionality includes:

- CRUD operations
- Request validation
- Search endpoints
- Custom exception handling
- HTTP Basic Authentication
- JWT login and token generation
- Access to protected endpoints using Bearer tokens
- Role-based authorization (`USER` vs `ADMIN`)
- Unauthorized and forbidden access scenarios

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT 
- H2 Database
- Lombok
- Maven
- Postman
