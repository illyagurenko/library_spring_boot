package org.library.library_spring.service;


import org.library.library_spring.Dto.BookDto;
import org.library.library_spring.entity.Author;
import org.library.library_spring.entity.Book;
import org.library.library_spring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }


    public void delete(int id){
        bookRepository.deleteById(id);
    }
}
