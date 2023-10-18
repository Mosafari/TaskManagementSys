package com.jproject.taskmanagementsys.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jproject.taskmanagementsys.model.Task;
import com.jproject.taskmanagementsys.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
    	System.out.println(task);
        return taskService.createTask(task);
    }

    @GetMapping("/by/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @PutMapping("/update/{taskId}")
    public Task updateTask(@PathVariable Long taskId,@RequestBody Task updatedTask) {
    	return taskService.updateTask(taskId, updatedTask);
    }
    
    @DeleteMapping("/del/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
    	taskService.deleteTask(taskId);
    }

}