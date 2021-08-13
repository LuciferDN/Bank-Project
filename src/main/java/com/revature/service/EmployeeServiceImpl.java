package com.revature.service;

import java.util.List;

import com.revature.Dao.EmployeeDao;
import com.revature.Dao.EmployeeDaoImpl;
import com.revature.models.Account;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao eDao = new EmployeeDaoImpl();
	@Override
	public List<Account> view_all_account_status() {
		List<Account> all_accounts = eDao.view_all_accounts();
		return all_accounts;
	}

	@Override
	public boolean approve(Account a) {
		return eDao.approve(a);
	}

	@Override
	public boolean reject(Account a) {
		return eDao.reject(a);
	}

}
