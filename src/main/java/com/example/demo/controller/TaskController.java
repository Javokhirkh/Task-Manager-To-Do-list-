package com.example.demo.controller;

import com.example.demo.DTOs.TaskCreateDTO;
import com.example.demo.DTOs.TaskDTO;
import com.example.demo.model.enums.TaskPriority;
import com.example.demo.model.enums.TaskStatus;
import com.example.demo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    // GET all tasks
    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET task by id
    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // POST create task
    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody  @Valid TaskCreateDTO dto) {
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    // PUT update task
    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody @Valid TaskCreateDTO dto) {
        return ResponseEntity.ok(taskService.updateTask(id, dto));
    }

    // DELETE task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // PATCH change task priority
    @PatchMapping("/{id}/priority")
    public ResponseEntity<TaskDTO> changePriority(@PathVariable Long id, @RequestParam TaskPriority priority) {
        return ResponseEntity.ok(taskService.changeTaskPriority(id, priority));
    }

    // PATCH change task status
    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskDTO> changeStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.changeTaskStatus(id, status));
    }
}
