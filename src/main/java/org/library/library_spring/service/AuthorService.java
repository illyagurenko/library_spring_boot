package org.library.library_spring.service;

import org.library.library_spring.Dto.AuthorDto;
import org.library.library_spring.entity.Author;
import org.library.library_spring.entity.Book;
import org.library.library_spring.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public AuthorDto converterToDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());

        if(author.getBooks() != null){
            List<String> titles = author.getBooks().stream()
                    .map(Book::getTitle)
                    .toList();
            authorDto.setBookList(titles);
        }
        return authorDto;
    }

    public Author convertToEntity(AuthorDto authorDto){
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return author;
    }

    public List<AuthorDto> getAll(){
        return authorRepository.findAll().stream()
                .map(this::converterToDto)
                .toList();
    }

    public AuthorDto save(AuthorDto authorDto){
        Author author = convertToEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return converterToDto(savedAuthor);
    }

    public AuthorDto getById(int id){
        Author author = authorRepository.findById(id).orElse(null);
        return converterToDto(author);
    }

    public void delete(int id){

        authorRepository.deleteById(id);
    }
}
