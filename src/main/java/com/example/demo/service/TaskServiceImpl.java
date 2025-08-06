package com.example.demo.service;

import com.example.demo.DTOs.TaskCreateDTO;
import com.example.demo.DTOs.TaskDTO;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.Task;
import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }


    @Override
    public TaskDTO createTask(TaskCreateDTO taskCreateDTO) {
        return null;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return null;
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public TaskDTO completeTask(Long id) {
        return null;
    }

    @Override
    public TaskDTO changeTaskPriority(Long id, TaskPriority priority) {
        return null;
    }

    @Override
    public TaskDTO changeTaskStatus(Long id, TaskStatus status) {
        return null;
    }
}
