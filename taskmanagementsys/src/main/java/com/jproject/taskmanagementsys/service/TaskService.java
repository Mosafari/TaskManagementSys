package com.jproject.taskmanagementsys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jproject.taskmanagementsys.model.Task;
import com.jproject.taskmanagementsys.repository.TaskRepository;

// dont implements iservice 
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Add methods to handle business logic (CRUD operations, etc.)

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = getTaskById(taskId);
        if (existingTask != null) {
        	existingTask.setEmployee(updatedTask.getEmployee());
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public String deleteTask(Long taskId) {
    	Task existingTask = getTaskById(taskId);
        if (existingTask != null) {
        	taskRepository.deleteById(taskId);
        	return "Succesfull!";
        }
        return "Dosen't Exist";
    }
}