package com.revature.service;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeAuthServiceImpl implements EmployeeAuthService{

	private EmployeeDao eDao = new EmployeeDaoImpl();
	
	@Override
	public boolean authenticateUser(String username, String password) {
		Employee e = new Employee(username, password);
		return eDao.login(e);
	}

}
