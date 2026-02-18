package org.library.library_spring.controller;

import org.library.library_spring.entity.Author;
import org.library.library_spring.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    //внедрение di спринг создаст репозиторий и передаст в конструктор
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }


}
