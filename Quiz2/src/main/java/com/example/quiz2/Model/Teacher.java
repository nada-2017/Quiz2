package com.example.quiz2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Teacher {

    @NotNull(message = "ID is required ")
    @Positive(message = "ID is required ")
    private int id;

    @NotEmpty(message = "Name is require")
    private String name;

    @NotNull(message = "Salary is required ")
    @Positive(message = "Salary is required ")
    private int salary;
}
