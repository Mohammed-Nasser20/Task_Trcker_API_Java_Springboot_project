package com.canMe.task_list.service;

import com.canMe.task_list.entity.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskList();
    TaskList createTaskList(TaskList taskList);
}
