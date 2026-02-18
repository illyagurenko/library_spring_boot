package org.library.library_spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    public Book(String title, int year, Author author){
        this.title = title;
        this.publishingYear = year;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publishing_year")
    private int publishingYear;

    @ManyToOne
    @JsonBackReference//потомок
    @JoinColumn(name = "author_id")
    private Author author;

}
