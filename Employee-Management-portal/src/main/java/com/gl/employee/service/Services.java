package com.gl.employee.service;

import java.util.List;

import com.gl.employee.pojo.Employee;

public interface Services {
	
	public List<Employee> getEmployees();
	
	public void addNewEmployee(Employee employee);
	
	public void deteteEmployeeById(int id);
	
	public Employee getEmployeeById(int id);
}
