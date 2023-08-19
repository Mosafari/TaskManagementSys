package com.jproject.taskmanagementsys.controller;

import com.jproject.taskmanagementsys.Task;
import com.jproject.taskmanagementsys.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String listTasks(Model model) {
        // Fetch tasks from the service and add them to the model
        model.addAttribute("tasks", taskService.getAllTasks());

        // Return the view name (Thymeleaf template)
        return "tasks/list";
    }
}