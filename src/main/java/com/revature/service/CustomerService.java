package com.revature.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.revature.models.Account;

public interface CustomerService {

	public boolean apply_account(Account a);

	public void view_balance();
	
	public List<Account> view_all_account_status(Account a);
	
	public Account init_account(Account a);

	public boolean deposit(Account a, double deposit_amount);

	public boolean withdraw(Account a, double withdraw_amount);

	public boolean post(Account a, Account b, double transfer_amount);

	public boolean accept(Account a, Account b, double receive_amount);
	

}
