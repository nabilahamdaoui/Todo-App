package com.nabila.sideproject.todo.server.respository;

import com.nabila.sideproject.todo.server.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}

