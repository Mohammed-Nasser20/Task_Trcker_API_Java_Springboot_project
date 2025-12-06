package com.canMe.task_list.service.impl;

import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.repository.TaskListRepository;
import com.canMe.task_list.service.TaskListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
}
