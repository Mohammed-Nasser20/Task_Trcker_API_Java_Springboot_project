package com.canMe.task_list.controller;

import com.canMe.task_list.dto.TaskDto;
import com.canMe.task_list.entity.Task;
import com.canMe.task_list.mapper.TaskMapper;
import com.canMe.task_list.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("task-lists/{task_list_id}/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id") int id) {
        return taskService.listTasks(id).stream().map(taskMapper::toDto).toList();
    }
    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id") int id,
            @RequestBody TaskDto taskDto
    ) {
        Task task = taskService.createTask(id, taskMapper.fromDto(taskDto));
        return taskMapper.toDto(task);
    }

    @GetMapping("/{task_id}")
    public Optional<TaskDto> getTask(
            @PathVariable("task_list_id") int taskListId,
            @PathVariable("task_id") int taskId
    ) {
        return taskService.getTask(taskListId, taskId).map(taskMapper::toDto);
    }

    @PutMapping("{task_id}")
    public TaskDto updateTask(
            @PathVariable("task_list_id") int taskListId,
            @PathVariable("task_id") int taskId,
            @RequestBody  TaskDto taskDto
    ) {
        Task task = taskService.updateTask(taskListId, taskId, taskMapper.fromDto(taskDto));
        return taskMapper.toDto(task);
    }

    @DeleteMapping("{task_id}")
    public void deleteTask(
            @PathVariable("task_list_id") int taskListId,
            @PathVariable("task_id") int taskId
    ) {
        taskService.deleteTask(taskListId, taskId);
    }
}
