package com.example.demo.mapper;

import com.example.demo.DTOs.TaskCreateDTO;
import com.example.demo.DTOs.TaskDTO;
import com.example.demo.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDto(Task task);
    Task toEntity(TaskCreateDTO taskCreateDTO);

}
