package com.jproject.taskmanagementsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jproject.taskmanagementsys.model.Employee;
import com.jproject.taskmanagementsys.model.Task;
import com.jproject.taskmanagementsys.repository.EmpRepository;
import com.jproject.taskmanagementsys.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpService implements IService<Employee>{
	private final EmpRepository empRepository ;
	@Autowired
	private TaskRepository taskRepository;
	
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
		return empRepository.findById(id).orElse(null);
	}

	@Override
	public Employee update(Long id, Employee updatedType) {
		Employee existingTask = getById(id);
        if (existingTask != null) {
            existingTask.setEmail(updatedType.getEmail());
            existingTask.setFirstName(updatedType.getFirstName());
            existingTask.setLastName(updatedType.getLastName());
            return empRepository.save(existingTask);
        }
        return null;
	}

	@Override
    @Transactional
    public String delete(Long empId) {
        // Fetch the employee
        Employee employee = empRepository.findById(empId).orElse(null);

        if (employee != null) {
            // Set employee to null in associated tasks
            for (Task task : employee.getTask()) {
                task.setEmployee(null);
            }

            // Save the tasks
            taskRepository.saveAll(employee.getTask());

            // Delete the employee
            empRepository.deleteById(empId);
            return "Succesfull!";
        }
        return "Dosen't Exist";
    }
}
