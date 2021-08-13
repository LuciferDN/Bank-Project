package com.revature.controller;

import com.revature.service.EmployeeAuthService;
import com.revature.service.EmployeeAuthServiceImpl;

import io.javalin.http.Context;

public class EmployeeAuthControllerImpl implements EmployeeAuthController {
	private EmployeeAuthService employeeAuthService = new EmployeeAuthServiceImpl();
	
	@Override
	public void login(Context ctx) {
		System.out.println("Employer Login Called");
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		if(employeeAuthService.authenticateUser(username, password))
		{
			ctx.status(200);
			ctx.cookieStore("employee_name", username);
			ctx.cookieStore("employee_password", password);
			ctx.redirect("employee_main.html");
		}
		else 
		{
			ctx.status(507);
			ctx.redirect("employee_login.html");
		}
	}

	@Override
	public void logout(Context ctx) {
		ctx.clearCookieStore();
		System.out.println("LOG OUT!");
		ctx.redirect("login.html");

	}
	
	@Override
	public boolean checkEmployee(Context ctx) {
		// TODO Auto-generated method stub
		return employeeAuthService.authenticateUser(ctx.cookieStore("employee_name"), ctx.cookieStore("employee_password"));
	}

}
