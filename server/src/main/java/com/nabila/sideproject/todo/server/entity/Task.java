package com.nabila.sideproject.todo.server.entity;

import com.nabila.sideproject.todo.server.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"milestone_id", "description"}))
public class Task implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TaskStatus status = TaskStatus.OPEN;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @Column(columnDefinition = "DATETIME")
    private Date startDate;

    @Column(columnDefinition = "DATETIME")
    private Date endDate;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "task_tags")
    @BatchSize(size = 50)
    private Set<String> tags;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "milestone_id")
    private Milestone milestone;

    @Column(columnDefinition = "DATETIME")
    private Date createdOn;

    @Column(columnDefinition = "DATETIME")
    private Date updatedOn;

}
