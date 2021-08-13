package com.revature.controller;

import com.revature.service.AuthService;
import com.revature.service.AuthServiceImpl;

import io.javalin.http.Context;

public class AuthControllerImpl implements AuthController {
	
	private AuthService authService = new AuthServiceImpl();
	@Override
	public void login(Context ctx) {
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		if(authService.authenticateUser(username, password))
		{
			ctx.status(200);
			ctx.cookieStore("name", username);
			ctx.cookieStore("password", password);
			ctx.redirect("customer_main.html");
		}
		else 
		{
			ctx.status(507);
			ctx.redirect("login.html");
		}
		System.out.println(username);
		System.out.println(password);
	}

	@Override
	public void logout(Context ctx) {
		ctx.clearCookieStore();
		System.out.println("LOG OUT!");
		ctx.redirect("login.html");

	}

	@Override
	public boolean checkUser(Context ctx) {
		return authService.authenticateUser(ctx.cookieStore("name"), ctx.cookieStore("password"));
	}

}
