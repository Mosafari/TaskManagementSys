package com.jproject.taskmanagementsys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String status;

    // Constructors, getters, setters
//    Constructors are used to create instances of a class.
 // No-argument constructor (required by JPA)
    public Task() {
    }

    // Parameterized constructor
//    The parameterized constructor allows you to conveniently initialize the attributes when creating instances.
    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }
}