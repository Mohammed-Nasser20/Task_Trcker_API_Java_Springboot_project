package com.canMe.task_list.repository;

import com.canMe.task_list.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByTaskListId(int id);

    Optional<Task> findByTaskListIdAndId(int taskListId, int taskId);
    void deleteByTaskListIdAndId(int taskListId, int taskId);
}
