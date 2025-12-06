package com.canMe.task_list.mapper;

import com.canMe.task_list.dto.TaskListDto;
import com.canMe.task_list.entity.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
