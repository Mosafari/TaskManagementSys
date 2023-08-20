package com.jproject.taskmanagementsys.repository;

import com.jproject.taskmanagementsys.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This interface will extend the JpaRepository interface provided by Spring Data JPA. This allows you to perform CRUD operations on your Task entity.
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods if needed
}