package com.canMe.task_list.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskList {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Integer id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime updated;
    @OneToMany(
            mappedBy = "taskList"
            , cascade = CascadeType.ALL
    )
    private List<Task> tasks;
}
