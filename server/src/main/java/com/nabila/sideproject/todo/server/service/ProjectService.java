package com.nabila.sideproject.todo.server.service;

import com.nabila.sideproject.todo.server.entity.Project;
import com.nabila.sideproject.todo.server.respository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

// Extends crud service
@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class ProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;

    public Project createProject(Project project) {
        // Validation
        return projectRepository.save(project);
    }

    public Page<Project> findAll(Pageable pageRequest) {
        return projectRepository.findAll(pageRequest);
    }

}
