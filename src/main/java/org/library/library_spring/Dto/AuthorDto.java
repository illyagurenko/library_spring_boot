package org.library.library_spring.Dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private int id;
    private String firstName;
    private String lastName;
    private List<String> bookList;
}
