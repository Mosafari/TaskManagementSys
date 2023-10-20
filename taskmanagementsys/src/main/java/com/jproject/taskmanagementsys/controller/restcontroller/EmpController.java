package com.jproject.taskmanagementsys.controller.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jproject.taskmanagementsys.model.Employee;
import com.jproject.taskmanagementsys.service.EmpService;

@RestController
@RequestMapping("/employees")
public class EmpController {
	private final EmpService empService;

	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	@PostMapping("/create")
    public Employee create(@RequestBody Employee emp)
	{
        return empService.create(emp);
    }

    @GetMapping("/by/{id}")
    public Employee getById(@PathVariable Long id) {
        return empService.getById(id);
    }
    
    @GetMapping("/all")
    public List<Employee> getAll() {
        return empService.getAll();
    }
    
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable Long id,@RequestBody Employee updatedEmp) {
    	return empService.update(id, updatedEmp);
    }
    
    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long id) {
    	empService.delete(id);
    }
	
	

}
