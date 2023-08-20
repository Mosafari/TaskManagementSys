package com.jproject.taskmanagementsys.service;

import com.jproject.taskmanagementsys.Task;
import com.jproject.taskmanagementsys.repository.TaskRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
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