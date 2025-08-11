package com.example.demo.DTOs;

import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private TaskPriority priority;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
