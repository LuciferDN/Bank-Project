package com.revature.Dao;

import java.util.List;

import com.revature.models.Account;
import com.revature.models.Employee;

public interface EmployeeDao {
	public boolean login(Employee employee);
	public boolean approve(Account a);
	public boolean reject(Account a);
	public void view_customer(Account a);
	public List<Account> view_all_accounts();
}
