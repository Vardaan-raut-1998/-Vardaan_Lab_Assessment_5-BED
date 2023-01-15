package com.gl.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employee.pojo.Employee;

public interface DatabaseRepository extends JpaRepository<Employee, Integer>{

}
