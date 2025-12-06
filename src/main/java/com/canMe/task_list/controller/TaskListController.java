package com.canMe.task_list.controller;

import com.canMe.task_list.dto.TaskListDto;
import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.mapper.TaskListMapper;
import com.canMe.task_list.service.TaskListService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskListController {
    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;
    @GetMapping("task-lists")
    public List<TaskListDto> listTaskList() {
        return taskListService.listTaskList().stream().map(taskListMapper::toDto).toList();
    }
    @PostMapping("task-lists")
    public TaskListDto createTaskList(@RequestBody TaskListDto taskList) {
        var tasklist = taskListMapper.fromDto(taskList);
        return taskListMapper.toDto(taskListService.createTaskList(tasklist));

    }
}
