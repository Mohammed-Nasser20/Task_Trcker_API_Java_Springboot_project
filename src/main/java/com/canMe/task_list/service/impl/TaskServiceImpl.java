package com.canMe.task_list.service.impl;

import com.canMe.task_list.entity.Task;
import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.entity.TaskPriority;
import com.canMe.task_list.entity.TaskStatus;
import com.canMe.task_list.repository.TaskListRepository;
import com.canMe.task_list.repository.TaskRepository;
import com.canMe.task_list.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;
    @Override
    public List<Task> listTasks(int taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(int taskListId, Task task) {
        if (task.getId() != null) {
            throw new IllegalArgumentException("This task is already has ID");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title must be not null or blank");
        }
        TaskPriority taskPriority = Optional.ofNullable(task.getTaskPriority())
                .orElse(TaskPriority.MEDIUM);
        TaskStatus taskstatus = TaskStatus.OPEN;
        LocalDateTime now = LocalDateTime.now();
        TaskList taskList = taskListRepository.findById(taskListId).orElseThrow(
                () -> new IllegalArgumentException("Invalid task list ID provided!")
        );

        return taskRepository.save(new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                now, now,taskList,taskstatus,taskPriority
        ));
    }
}
