package org.library.library_spring.controller;

import org.library.library_spring.Dto.BookDto;
import org.library.library_spring.entity.Book;
import org.library.library_spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto){
        return bookService.save(bookDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        bookService.delete(id);
    }
}
