package com.canMe.task_list.service;

import com.canMe.task_list.entity.TaskList;

import java.util.List;
import java.util.Optional;

public interface TaskListService {
    List<TaskList> listTaskList();
    TaskList createTaskList(TaskList taskList);
    Optional<TaskList> getTaskList(int taskListId);
}
