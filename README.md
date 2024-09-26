# BookService

# Book Management API

## Overview
This is a simple RESTful API for managing a catalog of books. The application allows users to perform basic CRUD operations such as adding, retrieving, updating, and deleting books. The API is built using Spring Boot and uses an in-memory list to store book data.

## Features
- **Get all books**: Retrieve a list of all books.
- **Get a book by ID**: Retrieve information of a book by its ID.
- **Add a book**: Add a new book to the catalog.
- **Update a book**: Update information of an existing book by its ID.
- **Delete a book**: Remove a book from the catalog by its ID.
- **Swagger Documentation**: The API is documented using Swagger and can be accessed through the Swagger UI.

## Technologies Used
- Java 11
- Spring Boot 2.x
- Spring Web
- Springfox Swagger 2 (for API documentation)
- Lombok (for reducing boilerplate code)
- Maven (for dependency management)

## Prerequisites
- Java 11 or later
- Maven

## Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/your-repository/book-api.git
    ```

2. Navigate to the project directory:
    ```bash
    cd book-api
    ```

3. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. The API will be available at `http://localhost:8080`.

## API Endpoints

### 1. Get All Books
- **Endpoint**: `/books`
- **Method**: `GET`
- **Response**: List of books

#### Example Response:
```json
[
    {
        "id": 1,
        "title": "Effective Java",
        "author": "Joshua Bloch",
        "description": "A comprehensive guide to programming in Java",
        "price": 39.99
    }
]
