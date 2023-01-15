package com.gl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.employee.pojo.Employee;
import com.gl.employee.service.EmployeeServices;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServices service;
	
	@GetMapping("/employee")
	public String getAllEmployee(Model model) {
		List<Employee> employee = service.getEmployees();
		model.addAttribute("employee",employee);
		return "employee";
	}
	
	@GetMapping("/employee/create_new")
	public String addNewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_new_employee";
	}
	
	@GetMapping("/employee/update/{id}")
	public String updateEmployee(Model model,@PathVariable("id") Integer id) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Integer id) {
		service.deteteEmployeeById(id);
		return "redirect:/employee";
	}
	
	@PostMapping("/employee")
	public String addEmployee(@ModelAttribute(name = "employee") Employee employee) {
			service.addNewEmployee(employee);
		return "redirect:/employee";
	}
	
	@PostMapping("/employee/{id}")
	public String updateEmployee(@ModelAttribute(name = "employee") Employee employee,@PathVariable("id") Integer id) {
		Employee employeeNew = service.getEmployeeById(id);
		if(employee.getId() == employeeNew.getId()) {
			employeeNew.setFirstName(employee.getFirstName());
			employeeNew.setLastName(employee.getLastName());
			employeeNew.setEmail(employee.getEmail());
		}
		service.addNewEmployee(employeeNew);
		return "redirect:/employee";
	}
	
}
