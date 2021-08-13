package com.revature.controller;

import com.revature.models.Account;

import io.javalin.http.Context;

public interface EmployeeController {
	public void view_all_account_status(Context ctx);
	public void approve(Context ctx);
	public void reject(Context ctx);
}
