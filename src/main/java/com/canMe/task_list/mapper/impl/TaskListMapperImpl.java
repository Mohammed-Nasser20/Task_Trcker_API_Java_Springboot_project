package com.canMe.task_list.mapper.impl;

import com.canMe.task_list.dto.TaskListDto;
import com.canMe.task_list.entity.Task;
import com.canMe.task_list.entity.TaskList;
import com.canMe.task_list.entity.TaskStatus;
import com.canMe.task_list.mapper.TaskListMapper;
import com.canMe.task_list.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TaskListMapperImpl implements TaskListMapper {
    private final TaskMapper taskMapper;
    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                null,
                null,
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto).toList())
                        .orElse(List.of())
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks-> tasks.stream().map(taskMapper::toDto).toList())
                        .orElse(List.of())
        );
    }
    private Double calculateTaskListProgress(List<Task> tasks) {
        if(tasks == null)
            return null;
        long closedTaskCount = tasks.stream().filter(
                task -> task.getTaskStatus() == TaskStatus.CLOSE
        ).count();
        if (tasks.isEmpty()) return (double) closedTaskCount;
        return  (double) (closedTaskCount /  tasks.size());
    }
}
