package com.canMe.task_list.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        Integer id,
        String title,
        String description,
        Integer count,
        Double progress,
        List<TaskDto> tasks
) {
}
