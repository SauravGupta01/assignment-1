package com.EmployeeServices.Services.Employee;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_Data")
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dept;
    private String name;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Employee(){}
    public Employee(int id, String name,String dept) {
        this.id = id;
        this.dept = dept;
        this.name = name;
    }

	public void setDept(String Dept) {
		this.dept=Dept;
		
	}

}
