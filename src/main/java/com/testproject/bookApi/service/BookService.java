package com.testproject.bookApi.service;

import com.testproject.bookApi.dto.BookRequestDto;
import com.testproject.bookApi.exception.NotFoundException;
import com.testproject.bookApi.model.Book;
import com.testproject.bookApi.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Provided id does not exist"));
    }

    public void addBook(BookRequestDto requestDto){
        Book book = Book.builder()
                .title(requestDto.getTitle())
                .author(requestDto.getAuthor())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .build();

        bookRepository.save(book);
    }

    public void updateBook(Long id, BookRequestDto requestDto){

        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Provided id does not exist"));

        existingBook.setTitle(requestDto.getTitle());
        existingBook.setAuthor(requestDto.getAuthor());
        existingBook.setDescription(requestDto.getDescription());
        existingBook.setPrice(requestDto.getPrice());

        bookRepository.save(existingBook);

    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
