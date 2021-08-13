package com.revature.service;

import java.util.List;

import com.revature.models.Account;

import io.javalin.http.Context;

public interface EmployeeService {

	public List<Account> view_all_account_status();

	public boolean approve(Account a);

	public boolean reject(Account a);

}
