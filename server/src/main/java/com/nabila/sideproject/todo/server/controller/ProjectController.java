package com.nabila.sideproject.todo.server.controller;

import com.nabila.sideproject.todo.server.entity.Project;
import com.nabila.sideproject.todo.server.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(readOnly = true)// Put in service instaed??
    public Page<Project> findAll(Pageable pageable) {

        return projectService.findAll(pageable);
    }

    @Transactional // Put in service instaed??
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Project createCredential(@RequestBody Project project) {

        return projectService.createProject(project);
    }
}
