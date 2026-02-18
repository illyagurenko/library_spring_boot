package org.library.library_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.library.library_spring.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
