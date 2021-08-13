package com.revature.Dao;

import java.util.List;

import com.revature.models.Account;

public interface CustomerDao {
	public boolean init(Account a);
	public boolean apply_account(Account a);
	public List<Account> view_all_account_status(Account a);
	public void view_balance(Account a);
	public boolean deposite(Account a, double amount);
	public boolean withdraw(Account a, double amount);
	public boolean post(Account a, Account b, double amount);
	public boolean accept(Account a, Account b, double amount);
	

}
