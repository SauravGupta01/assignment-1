//package com.EmployeeServices.Services.EmployeeServiceImpl;
//
//import java.util.List;
//
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import com.EmployeeServices.Services.Employee.EmployeeRedis;
//import com.EmployeeServices.Services.Employee_Repo.Employee_RedisDao;
//
//@Service
//public class EmployeeServicesRedisImpl implements Employee_RedisDao {
//	private HashOperations hashOps;
//	public static final String HASH_empkey ="EmployeeRedis";
//	    
//	    public EmployeeServicesRedisImpl(RedisTemplate redisTemplate) {
//	    	super();
//	        this.hashOperations = redisTemplate.opsForHash();
//	    }
//
//
//	    @Override
//	    public void create(EmployeeRedis employeeRedis) {
//	        System.out.println("hello"+employeeRedis.getid() +employeeRedis.getdept());
//	        hashOperations.put(HASH_KEY, employeeRedis.getid(), employeeRedis);
//	   
//	    }
//
//	   @Override
//	    public EmployeeRedis get(int id) {
//	        return (EmployeeRedis) hashOperations.get(HASH_KEY, id);
//	    }
//
//
//
//	   @Override
//	    public List<EmployeeRedis> getAll() {
//	        return hashOperations.values(HASH_KEY);
//	    }
//
//
//
//
//	    @Override
//	    public String getDept(int id) {
//	        EmployeeRedis redis=((EmployeeRedis) hashOperations.get(HASH_KEY, id));
//	        String deptName=redis.getdept();
//	        return deptName;
//	    }
//
//
//}
