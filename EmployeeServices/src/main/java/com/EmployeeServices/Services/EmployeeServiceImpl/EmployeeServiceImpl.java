package com.EmployeeServices.Services.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.EmployeeServices.Services.Employee.Employee;
import com.EmployeeServices.Services.Employee.EmployeeRedis;
import com.EmployeeServices.Services.Employee_Repo.Employee_Repo;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private Employee_Repo employeeRepository;
	
	private HashOperations hashOps;
	private static final String RedisCache_Value="Employee";
	public static final String HASH_empkey ="EmployeeRedis";
	
    public EmployeeServiceImpl(RedisTemplate redisTemplate) {
        this.hashOps = redisTemplate.opsForHash();
    }
	

    public void saveEmp(Employee employee) {
        employeeRepository.save(employee);
         EmployeeRedis employeeredis=new EmployeeRedis(employee.getId(),employee.getDept());
         hashOps.put(HASH_empkey, employee.getId(), employeeredis);

    }
    
    public Employee getEmp_Detail(int id) {
        if( ((EmployeeRedis) hashOps.get(HASH_empkey, id)).getdept()==null) {
            EmployeeRedis employeeredis=new EmployeeRedis(id,"default_dept");
            hashOps.put(HASH_empkey, id, employeeredis);
            Employee employee=employeeRepository.findByid(id);
            employee.setDept("default_dept");
            employeeRepository.save(employee);
            System.out.println(employeeRepository.findById(id)+"heyyy");
            return employeeRepository.findByid(id);
        }
        else
            return employeeRepository.findByid(id);
    }
    
    public List<EmployeeRedis> getAllDetails() {
        return hashOps.values(HASH_empkey);
     }
     public List<Employee> getEmployees(){
         return employeeRepository.findAll();
     }
     
     public String updateEmployee(Employee employee) {
         if(((EmployeeRedis) hashOps.get(HASH_empkey, employee.getId()))==null) {
             return "This employee doesn't exist.Can't be updated";        
         }
         EmployeeRedis employeeredis=new EmployeeRedis(employee.getId(),employee.getDept());
         hashOps.put(HASH_empkey, employeeredis.getid(), employeeredis);    
         employeeRepository.save(employee);
         return "employee "+employee.getId()+" has been updated";
     }
     
     public String del_Emp(int id) {
         hashOps.delete(HASH_empkey, id);
         employeeRepository.deleteById(id);
         return "Employee "+id+" deleted Sucessfully";
     }

    // FETCHING ALL EMPLOYEE DATA
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // FETCHING EMPLOYEE BY ID
    
    public Employee getEmployeeById(int Id){
        return employeeRepository.findByid(Id);
    }

    // ADD NEW EMPLOYEE
    public void addNewEmployee(Employee empObj){
        employeeRepository.save(empObj);
    }
    // DELETING EMPLOYEE BY ID
    public void deleteEmployeeById(Employee employeeObj){
        employeeRepository.deleteById(employeeObj.getId());
    }

    // UPDATING EMPLOYEE BY ID
    public void updateEmployeeById(Employee employeeObj){
        employeeRepository.save(employeeObj);
    }



	

}
