package com.example.demo.model;

import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDate dueDate;
    private TaskPriority priority;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
