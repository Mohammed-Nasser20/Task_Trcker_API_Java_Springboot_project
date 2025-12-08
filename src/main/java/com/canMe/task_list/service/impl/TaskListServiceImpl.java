package com.canMe.task_list.service.impl;

import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.repository.TaskListRepository;
import com.canMe.task_list.service.TaskListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskListServiceImpl implements TaskListService {
    private final TaskListRepository taskListRepository;
    @Override
    public List<TaskList> listTaskList() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (taskList.getId() != null) {
            throw new IllegalArgumentException("This task list has already id");
        }
        if (taskList.getTitle() == null || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title must be not null or blank");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(
                new TaskList(
                        null,
                        taskList.getTitle(),
                        taskList.getDescription(),now, now,null
                        )
        );
    }

    @Override
    public Optional<TaskList> getTaskList(int taskListId) {
        return taskListRepository.findById(taskListId);
    }

    @Override
    public TaskList updateTaskList(int id, TaskList taskList) {
        if (taskList.getId() == null)
            throw new IllegalArgumentException("Task list must have ID");
        if (!Objects.equals(id, taskList.getId()))
            throw new IllegalArgumentException("not allow to do that");
        TaskList existingTaskList = taskListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task List not found!"));
        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);
    }
}
