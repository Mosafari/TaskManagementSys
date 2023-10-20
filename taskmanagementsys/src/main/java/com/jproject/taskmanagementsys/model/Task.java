package com.jproject.taskmanagementsys.model;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="Tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name="employee_id", unique = true)
    private Employee employee;
    @Column(name = "Status")
    @ColumnDefault("'Created'")
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
    
//    Getter Methods:
//    Getter methods allow you to access the values of the attributes of your entity objects.
    
    
    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
		return employee;
	}

	public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
    
//    Setter Methods:
//    Setter methods allow you to modify the values of the attributes of your entity objects.
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", employee=" + employee
				+ ", status=" + status + "]";
	}
	
	
}