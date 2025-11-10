package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.entity.ProjectManagement;
import com.example.repository.projectRepositoryInterface;

@RestController
@RequestMapping("/api/allprojects")
public class projectManagementController {
	
	@Autowired
    private projectRepositoryInterface projectRepository;

    //  Creating the new Project
    @PostMapping
    public ProjectManagement addProject(@Valid @RequestBody ProjectManagement newProject) {
	
        return projectRepository.save(newProject);
    }

    // List of a ALL Projects
	
    @GetMapping
    public List<ProjectManagement> projectsList() {
	
        return projectRepository.findAll();
    }

    // Updating the project
	
    @PutMapping("/{id}")
    public ProjectManagement updateProjectData(@PathVariable Long id, @RequestBody ProjectManagement project) {
	
        project.setId(id);
		
        return projectRepository.save(project);
    }

    // Deleting the project content
	
    @DeleteMapping("/{id}")
    public String deleteProjectData(@PathVariable Long id) {
	
        projectRepository.deleteById(id);
		
        return "Project Deleted Successfully :" +id;
    }

}
