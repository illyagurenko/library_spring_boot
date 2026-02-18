package org.library.library_spring.controller;

import org.library.library_spring.entity.Author;
import org.library.library_spring.repository.AuthorRepository;
import org.library.library_spring.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable int id){
        return authorService.getById(id);
    }

    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.save(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        authorService.delete(id);
    }



}
