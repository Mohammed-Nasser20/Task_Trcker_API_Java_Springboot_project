package com.canMe.task_list.controller;

import com.canMe.task_list.dto.TaskListDto;
import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.mapper.TaskListMapper;
import com.canMe.task_list.service.TaskListService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("task-lists")
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;
    @GetMapping
    public List<TaskListDto> listTaskList() {
        return taskListService.listTaskList().stream().map(taskListMapper::toDto).toList();
    }
    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskList) {
        var tasklist = taskListMapper.fromDto(taskList);
        return taskListMapper.toDto(taskListService.createTaskList(tasklist));

    }

    @GetMapping("/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") int id) {
        return taskListService.getTaskList(id).map(taskListMapper::toDto);
    }

    @PutMapping("/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") int id,
            @RequestBody TaskListDto taskList
    ) {
        return taskListMapper.toDto(
                taskListService.updateTaskList(id, taskListMapper.fromDto(taskList))
        );
    }

    @DeleteMapping("/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") int id) {
        taskListService.deleteTaskList(id);
    }
}
