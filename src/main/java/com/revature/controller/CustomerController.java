package com.revature.controller;

import io.javalin.http.Context;

public interface CustomerController {
	public void apply_account(Context ctx);
	public void view_all_account_status(Context ctx);
	public void view_balance(Context ctx);
	public void deposit(Context ctx);
	public void withdraw(Context ctx);
	public void post(Context ctx);
	public void accept(Context ctx);
}
