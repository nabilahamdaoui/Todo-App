package com.nabila.sideproject.todo.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"project_id", "title"}))
public class Milestone implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255)
    private String title;

    @Column(columnDefinition = "DATE")
    private Date dueDate;

    @Column(columnDefinition = "DATE")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "milestone", fetch = FetchType.LAZY)
    private Set<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(columnDefinition = "DATETIME")
    private Date createdOn;

    @Column(columnDefinition = "DATETIME")
    private Date updatedOn;

}
