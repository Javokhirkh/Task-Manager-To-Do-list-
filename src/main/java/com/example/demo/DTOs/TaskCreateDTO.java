package com.example.demo.DTOs;

import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.time.LocalDate;

@Getter
@Setter
@ToString
public class TaskCreateDTO {
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;
    @Size(max = 500, message = "Description can be up to 500 characters")
    private String description;
    private TaskStatus status;
    @FutureOrPresent(message = "Due date cannot be in the past")
    private LocalDate dueDate;
    private TaskPriority priority;
}
