# Library Book Tracker API

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

## Testing

The application was tested using Postman to verify:

- CRUD operations
- Validation
- Search endpoints
- Custom exception handling
