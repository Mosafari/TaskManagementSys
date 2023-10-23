package com.jproject.taskmanagementsys.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jproject.taskmanagementsys.model.Employee;
import com.jproject.taskmanagementsys.model.Task;
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
			return "redirect:/home/employee/create";
		}
		else {
		empService.create(emp);
		return empoloyeesShow(model);
		}
	}
	
	@GetMapping("/tasks")
	public String tasksShow(Model model) {
		model.addAttribute("tasks",taskService.getAllTasks());
		return "tasks.html";
	}
	
	@GetMapping("/task/{id}/edit")
	public String editTask(Model model, @PathVariable("id") Long id) {
		model.addAttribute("task", taskService.getTaskById(id));
		model.addAttribute("id", id);
		model.addAttribute("currentEmp", taskService.getTaskById(id).getEmployee());
		model.addAttribute("employees", empService.getAll());
		return "edittask";
	}
	
	@PostMapping("/task/update/{id}")
	public String updateTask(@PathVariable("id") Long id, @ModelAttribute Task task, Model model) {
		if (task.getDescription()=="") {
			return "createtask";
		}
		else {
			System.out.println(task);
		taskService.updateTask(id, task);
		return tasksShow(model);
		}
	}
	
	@GetMapping("/task/create")
	public String createTaskPage( Model model) {
	
		return "createtask" ;
	}
	
	@PostMapping("/task/add")
	public String addTask(@ModelAttribute Task task, Model model) {
		if (task.getDescription()=="") {
			return "redirect:/home/employee/create";
		}
		else {
		taskService.createTask(task);
		return tasksShow(model);
		}
	}
}
