package org.library.library_spring.service;

import org.library.library_spring.entity.Author;
import org.library.library_spring.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<Author> getAll(){
        return authorRepository.findAll();
    }

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public Author getById(int id){
        return authorRepository.findById(id).orElse(null);
    }

    public void delete(int id){
        authorRepository.deleteById(id);
    }
}
