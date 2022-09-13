package com.EmployeeServices.Services.Employee;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;



@RedisHash
public class EmployeeRedis implements Serializable {
//	private static final long serialVersionUID = 1L;
	private static final long serialVersionUID = -7465091770594079351L;
	@Id
	private int id;
	
	public EmployeeRedis() {
		super();
	}

	public EmployeeRedis(int id, String dept) {
		super();
		this.id = id;
		this.dept = dept;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	private String dept;

	public String getdept() {
		return dept;
	}

	public void setdept(String dept) {
		this.dept = dept;
	}




}
