package com.canMe.task_list.service;

import com.canMe.task_list.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> listTasks(int taskListId);
    Task createTask(int taskListId, Task task);
    Optional<Task> getTask(int taskListId, int taskId);
}
