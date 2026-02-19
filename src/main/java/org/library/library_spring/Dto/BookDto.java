package org.library.library_spring.Dto;

import lombok.Data;

@Data
public class BookDto {
    private int id;
    private String title;
    private int publishingYear;
    private int authorId;
}
