package com.revature.service;

import com.revature.Dao.UserDao;
import com.revature.Dao.UserDaoImpl;
import com.revature.models.User;

public class AuthServiceImpl implements AuthService {
	
	private UserDao uDao = new UserDaoImpl();
	
	@Override
	public boolean authenticateUser(String username, String password) {
		
		User u = new User(username, password);
		return uDao.login(u);
	}

}
