package org.library.library_spring.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private int id;
    @NotBlank(message = "Поле не может быть пустым")
    private String firstName;
    @NotBlank(message = "Поле не может быть пустым")
    private String lastName;
    private List<String> bookList;
}
