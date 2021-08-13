package com.revature.service;

import java.util.List;

import com.revature.Dao.CustomerDao;
import com.revature.Dao.CustomerDaoImpl;
import com.revature.models.Account;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao cdao = new CustomerDaoImpl();
	@Override
	public boolean apply_account(Account a) {
		return cdao.apply_account(a);
	}

	@Override
	public void view_balance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> view_all_account_status(Account a) {
		List<Account> accounts_under_same_user = cdao.view_all_account_status(a);
		return accounts_under_same_user;
	}

	@Override
	public Account init_account(Account a) {
		if(cdao.init(a))
		{
			return a;
		}
		return null;
	}

	@Override
	public boolean deposit(Account a, double deposit_amount) {
		return cdao.deposite(a, deposit_amount);
	}

	@Override
	public boolean withdraw(Account a, double withdraw_amount) {
		return cdao.withdraw(a, withdraw_amount);
	}

	@Override
	public boolean post(Account a, Account b, double transfer_amount) {
		
		return cdao.post(a, b, transfer_amount);
	}

	@Override
	public boolean accept(Account a, Account b, double receive_amount) {
		return cdao.accept(a, b, receive_amount);
	}
}
