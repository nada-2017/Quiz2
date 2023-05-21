package com.example.quiz2.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

    @NotNull(message = "ID is required ")
    @Positive(message = "ID is required ")
    private int id;

    @NotEmpty(message = "Name is require")
    private String name;

    @NotNull(message = "Age is required ")
    @Positive(message = "Age is required ")
    private int age;

    @NotEmpty(message = "Major is require")
    private String major;
}
