package com.jproject.taskmanagementsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jproject.taskmanagementsys.model.Task;


//This interface will extend the JpaRepository interface provided by Spring Data JPA. This allows you to perform CRUD operations on your Task entity.
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods if needed
}