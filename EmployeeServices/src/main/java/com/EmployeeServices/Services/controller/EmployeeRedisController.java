//package com.EmployeeServices.Services.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.EmployeeServices.Services.Employee.EmployeeRedis;
//import com.EmployeeServices.Services.EmployeeServiceImpl.EmployeeServicesRedisImpl;
//import com.EmployeeServices.Services.Employee_Repo.Employee_RedisDao;
//
//@RestController
//@RequestMapping("/Redis")
//public class EmployeeRedisController {
//	@Autowired
//	private EmployeeServicesRedisImpl employeeRediss;
//	
//	
//	  @PostMapping("/employee")
//	    public String save(@RequestBody EmployeeRedis employeeRedis) {
//	        System.out.println(employeeRedis.getEmp_id());
//	        employeeRediss.create(employeeRedis);
//	        return "details saved";
//	    }
//	    
//	    @GetMapping("/employee")
//	    public List<EmployeeRedis> allemployee(){
//	        return (List<EmployeeRedis>) employeeRediss.getAll();
//	    }
//	    
//	    @GetMapping("/{id}")
//	    public EmployeeRedis getById(@PathVariable int id) {
//	        return employeeRediss.get(id);
//	    }
//	    @GetMapping("/dept/{id}")
//	    public String getDeptname(@PathVariable int id) {
//	        return employeeRediss.getDept(id);
//	    }
//
//
//}
