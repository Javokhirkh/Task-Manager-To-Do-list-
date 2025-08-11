package com.example.demo.service;

import com.example.demo.DTOs.TaskCreateDTO;
import com.example.demo.DTOs.TaskDTO;
import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;

import java.util.List;

public interface TaskService {
    TaskDTO createTask(TaskCreateDTO taskCreateDTO);
    TaskDTO getTaskById(Long id);
    TaskDTO updateTask(Long id, TaskCreateDTO taskCreateDTO);
    void deleteTask(Long id);
    TaskDTO changeTaskPriority(Long id, TaskPriority priority);
    TaskDTO changeTaskStatus(Long id, TaskStatus status);
    List<TaskDTO> getAllTasks();
}
