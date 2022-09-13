package com.EmployeeServices.Services.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.EmployeeServices.Services.Employee.Employee;
import com.EmployeeServices.Services.Employee.EmployeeRedis;
import com.EmployeeServices.Services.EmployeeServiceImpl.EmployeeServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
@CrossOrigin
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	
	
    @GetMapping("/redis_getalldata")
    public List<EmployeeRedis> getAllMappingDetails() {
        return employeeService.getAllDetails();
    }
	
    
    @GetMapping("/employee/{id}")
    public Employee getDeptName(@PathVariable int id) {
       return employeeService.getEmp_Detail(id);
    }

    // END POINT TO FETCH ALL EMPLOYEES
    @GetMapping(value = "/allEmployees")
    public ResponseEntity<Map<String, Object>> findAllEmployees(){
    	Map<String, Object> response = new LinkedHashMap<String, Object>();//RESPONSE MAP
    	List<Employee> userList =employeeService.getAllEmployees();
    	if (!userList.isEmpty()) {
			response.put("status", 1);
			response.put("data", userList);
			response.put("RESPONSE:-", "Data found sucesfully");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.clear();
			response.put("status", 0);
			response.put("RESPONSE:-", "Data not found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
    }

    // END POINT TO FETCH SINGLE EMPLOYEE
    @GetMapping(value = "/findEmployee/{id}")
    public Employee findEmployeeById(@PathVariable(value = "id") int empId){
        return employeeService.getEmp_Detail(empId);
    }

    // END POINT TO ADD NEW EMPLOYEE
    @PostMapping(value = "/addEmployee")
    public ResponseEntity<Map<String, Object>> addNewEmployee(@RequestBody Employee empObj){
    	Map<String, Object> response = new LinkedHashMap<String, Object>();//RESPONSE MAP
        employeeService.saveEmp(empObj);
        response.put("status", 1);
		response.put("RESPONSE:-", "Employee Record is Saved Successfully!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // END POINT TO UPDATE AN EMPLOYEE
    @PutMapping(value = "/updateEmployee")
    public void updateNewEmployee(@RequestBody Employee empObj){
        employeeService.updateEmployeeById(empObj);
    }

    // END POINT TO DELETE AN EMPLOYEE
    @DeleteMapping(value = "/deleteEmployee")
    public void deleteNewEmployee(@RequestBody Employee empObj){
        employeeService.deleteEmployeeById(empObj);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.del_Emp(id);            
    }


	
}
