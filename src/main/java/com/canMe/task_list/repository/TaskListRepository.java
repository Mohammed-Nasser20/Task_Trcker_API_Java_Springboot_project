package com.canMe.task_list.repository;

import com.canMe.task_list.entity.Task;
import com.canMe.task_list.entity.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {
//    Optional<Task> findByTaskListIdAndId(Integer taskListId, Integer taskId);
}
