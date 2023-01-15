package com.gl.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.pojo.Employee;
import com.gl.employee.repo.DatabaseRepository;

@Service
public class EmployeeServices implements Services {

	@Autowired
	DatabaseRepository databaseRepository;
	
	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return databaseRepository.findAll();
	}

	@Override
	public void addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		databaseRepository.save(employee);
		
	}

	@Override
	public void deteteEmployeeById(int id) {
		// TODO Auto-generated method stub
		databaseRepository.delete(getEmployeeById(id));
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return databaseRepository.findById(id).get();
	}

}
