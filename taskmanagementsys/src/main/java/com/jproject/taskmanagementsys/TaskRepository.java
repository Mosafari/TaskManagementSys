package com.jproject.taskmanagementsys;

import org.springframework.data.jpa.repository.JpaRepository;


//This interface will extend the JpaRepository interface provided by Spring Data JPA. This allows you to perform CRUD operations on your Task entity.
public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods if needed
}