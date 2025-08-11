package com.example.demo.service;

import com.example.demo.DTOs.TaskCreateDTO;
import com.example.demo.DTOs.TaskDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.Task;
import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        Task task = taskMapper.toEntity(taskCreateDTO);
        System.out.println("taskCreateDTO = " + taskCreateDTO);
        System.out.println("task = " + task);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    @Override
    public TaskDTO updateTask(Long id, TaskCreateDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Task not found with id: " + id));

        if(taskDTO.getTitle()!=null && !taskDTO.getTitle().isBlank()){
            existingTask.setTitle(taskDTO.getTitle());
        }
        if(taskDTO.getDescription()!=null && !taskDTO.getDescription().isBlank()){
            existingTask.setDescription(taskDTO.getDescription());
        }
        if(taskDTO.getStatus()!=null){
            existingTask.setStatus(taskDTO.getStatus());
        }
        if(taskDTO.getDueDate()!=null){
            existingTask.setDueDate(taskDTO.getDueDate());
        }
        if(taskDTO.getPriority()!=null){
            existingTask.setPriority(taskDTO.getPriority());
        }
        taskRepository.save(existingTask);
        return taskMapper.toDto(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
         Task task=taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);
    }

    @Override
    public TaskDTO changeTaskPriority(Long id, TaskPriority priority) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        task.setPriority(priority);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDTO changeTaskStatus(Long id, TaskStatus status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        task.setStatus(status);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(taskMapper::toDto)
                .toList();

    }
}
