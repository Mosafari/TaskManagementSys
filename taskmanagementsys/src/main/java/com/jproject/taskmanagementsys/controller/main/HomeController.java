package com.jproject.taskmanagementsys.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jproject.taskmanagementsys.model.Employee;
import com.jproject.taskmanagementsys.service.EmpService;
import com.jproject.taskmanagementsys.service.TaskService;


@Controller
@RequestMapping("/home")
public class HomeController {
	private final EmpService empService;
	private final TaskService taskService;
	
	

	public HomeController(EmpService empService, TaskService taskService) {
		super();
		this.empService = empService;
		this.taskService = taskService;
	}

	@GetMapping("/welcome")
	public String welcome(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/employees")
	public String empoloyeesShow(Model model) {
		model.addAttribute("employees",empService.getAll());
		return "employees.html";
	}
	
	@GetMapping("/employee/{id}/edit")
	public String editEmployee(Model model, @PathVariable("id") Long id) {
		model.addAttribute("emp", empService.getById(id));
		model.addAttribute("id", id);
		return "editemployee";
	}
	
	@PostMapping("/employee/update/{id}")
	public String updateEmployee(@PathVariable("id") Long id, @ModelAttribute Employee emp, Model model) {
		if (emp.getEmail()=="") {
			return "createemployee";
		}
		else {
		empService.update(id, emp);
		return empoloyeesShow(model);
		}
	}
	
	@GetMapping("/employee/create")
	public String createEmployeePage( Model model) {
	
		return "createemployee" ;
	}
	
	@PostMapping("/employee/add")
	public String addEmployee(@ModelAttribute Employee emp, Model model) {
		if (emp.getEmail()=="") {
			return "createemployee";
		}
		else {
		empService.create(emp);
		return empoloyeesShow(model);
		}
	}
}
