package com.canMe.task_list.mapper;

import com.canMe.task_list.dto.TaskDto;
import com.canMe.task_list.entity.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);

}
