package com.testproject.bookApi.controller;

import com.testproject.bookApi.dto.BookRequestDto;
import com.testproject.bookApi.model.Book;
import com.testproject.bookApi.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Api(value = "Book Management", tags = {"Books"})
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ApiOperation(value = "Get all books", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of books"),
            @ApiResponse(code = 404, message = "No books found")
    })
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a book by ID", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved book"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public Book getById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a new book", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created book"),
            @ApiResponse(code = 400, message = "Invalid input")
    })
    public String addBook(@RequestBody BookRequestDto requestDto){
        bookService.addBook(requestDto);

        return "Book successfully added!";
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a book by ID", response = Book.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated book"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public String updateBook(@PathVariable Long id, @RequestBody BookRequestDto requestDto){
        bookService.updateBook(id, requestDto);

        return "Book successfully updated";
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a book by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted book"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);

        return "Book successfully deleted!";
    }
}
