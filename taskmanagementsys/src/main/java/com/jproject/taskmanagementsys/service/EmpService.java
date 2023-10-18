package com.jproject.taskmanagementsys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jproject.taskmanagementsys.model.Employee;
import com.jproject.taskmanagementsys.repository.EmpRepository;

@Service
public class EmpService implements IService<Employee>{
	private final EmpRepository empRepository ;
	
	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public Employee create(Employee t) {
		return empRepository.save(t);
	}

	@Override
	public List<Employee> getAll() {
		return empRepository.findAll();
	}

	@Override
	public Employee getById(Long id) {
		return empRepository.getById(id);
	}

	@Override
	public Employee updateTask(Long id, Employee updatedType) {

		return null;
	}

	@Override
	public String deleteTask(Long id) {
		Employee existingTask = getById(id);
        if (existingTask != null) {
        	empRepository.deleteById(id);
        	return "Succesfull!";
        }
        return "Dosen't Exist";
    }
}