package com.revature.controller;

import com.revature.models.Account;
import com.revature.service.EmployeeService;
import com.revature.service.EmployeeServiceImpl;

import io.javalin.http.Context;

public class EmployeeControllerImpl implements EmployeeController {

	private EmployeeAuthController employeeAuthController = new EmployeeAuthControllerImpl();
	private EmployeeService employeeService = new EmployeeServiceImpl();
	@Override
	public void view_all_account_status(Context ctx) {
		if(employeeAuthController.checkEmployee(ctx)) {
			ctx.status(200);
			ctx.json(employeeService.view_all_account_status());
		}
		else
		{
			
			ctx.status(405);
		}
		
	}

	@Override
	public void approve(Context ctx) {
		String username = ctx.formParam("username");
		String account_name = ctx.formParam("account_name");
		
		Account a = new Account(username, account_name, false, 0);
		if(employeeService.approve(a) && employeeAuthController.checkEmployee(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/employee_main.html");
		}
		else
		{
			ctx.status(404);
		}	
	}

	@Override
	public void reject(Context ctx) {
		String username = ctx.formParam("username");
		String account_name = ctx.formParam("account_name");
		
		Account a = new Account(username, account_name, false, 0);
		if(employeeService.reject(a) && employeeAuthController.checkEmployee(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/employee_main.html");
		}
		else
		{
			ctx.status(404);
		}	
		
	}

}
