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

import com.example.projects.entity.Task;
import com.example.repository.taskRepositoryInterface;

@RestController
@RequestMapping("/api/taskalltask")
public class taskController {

	@Autowired
    private taskRepositoryInterface taskRepository;

    // Creating new task
    @PostMapping
    public Task addTaskData(@Valid @RequestBody Task newtask) {
	
        return taskRepository.save(newtask);
    }

    // List of a ALL Projects
	
    @GetMapping
    public List<Task> tasksList() {
	
        return taskRepository.findAll();
    }

    // Updating the project
    @PutMapping("/{id}")
    public Task updateTaskData(@PathVariable Long id, @RequestBody Task taskId) {
	
        taskId.setId(id);
		
        return taskRepository.save(taskId);
    }

     // Deleting the project content
    @DeleteMapping("/{id}")
    public String deleteTaskData(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "Task Deleted Successfully : " +id;
    }
}
