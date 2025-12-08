package com.canMe.task_list.service.impl;

import com.canMe.task_list.entity.Task;
import com.canMe.task_list.repository.TaskListRepository;
import com.canMe.task_list.repository.TaskRepository;
import com.canMe.task_list.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> listTasks(int taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
