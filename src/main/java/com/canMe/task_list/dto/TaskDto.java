package com.canMe.task_list.dto;

import com.canMe.task_list.entity.TaskPriority;
import com.canMe.task_list.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
        ) {
}
