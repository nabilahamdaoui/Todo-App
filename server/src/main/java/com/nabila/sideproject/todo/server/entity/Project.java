package com.nabila.sideproject.todo.server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "name"}))
public class Project {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 255)
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @Column(columnDefinition = "DATETIME")
    private Date startDate;

    @Column(columnDefinition = "DATETIME")
    private Date dueDate;

    @Column(columnDefinition = "DATETIME")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.LAZY)
    private Set<Milestone> milestones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "DATETIME")
    private Date createdOn;

    @Column(columnDefinition = "DATETIME")
    private Date updatedOn;
}
