package com.canMe.task_list.controller;

import com.canMe.task_list.dto.TaskDto;
import com.canMe.task_list.mapper.TaskMapper;
import com.canMe.task_list.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("task_list/{task_list_id}/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id") int id) {
        return taskService.listTasks(id).stream().map(taskMapper::toDto).toList();
    }
}
