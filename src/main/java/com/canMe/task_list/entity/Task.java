package com.canMe.task_list.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;

    private String description;
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(nullable = false)
    private LocalDateTime created;
    @Column(nullable = false)
    private LocalDateTime updated;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    @Column(name = "status", nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "priority", nullable = false)
    private TaskPriority taskPriority;
}
