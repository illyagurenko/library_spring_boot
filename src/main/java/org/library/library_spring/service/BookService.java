package org.library.library_spring.service;


import org.library.library_spring.Dto.BookDto;
import org.library.library_spring.entity.Author;
import org.library.library_spring.entity.Book;
import org.library.library_spring.repository.AuthorRepository;
import org.library.library_spring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookDto convertToDto(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setPublishingYear(book.getPublishingYear());
        bookDto.setAuthorId(book.getAuthor().getId());
        return bookDto;
    }

    public Book convertToEntity(BookDto bookDto){
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPublishingYear(bookDto.getPublishingYear());

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("author not found"));
        book.setAuthor(author);
        return book;
    }

    public List<BookDto> getAll(){
        return bookRepository.findAll().stream()
                .map(this::convertToDto)
                .toList();
    }

    public BookDto getBookById(int id){
        Book book = bookRepository.findById(id).orElse(null);
        return convertToDto(book);
    }

    public BookDto save(BookDto bookDto){
        Book book = convertToEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return convertToDto(savedBook);
    }

    public void delete(int id){
        bookRepository.deleteById(id);
    }
}
