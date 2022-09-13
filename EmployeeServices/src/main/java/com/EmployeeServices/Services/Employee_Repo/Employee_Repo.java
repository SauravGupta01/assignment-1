package com.EmployeeServices.Services.Employee_Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeServices.Services.Employee.Employee;
import com.EmployeeServices.Services.Employee.EmployeeRedis;



public interface Employee_Repo extends JpaRepository<Employee,Integer> {
	

	public Employee save(Employee employee);
	public Employee findByid(int Id);

}
