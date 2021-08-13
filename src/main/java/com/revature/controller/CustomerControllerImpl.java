package com.revature.controller;

import java.util.HashMap;

import org.eclipse.jetty.util.ajax.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Account;
import com.revature.service.CustomerService;
import com.revature.service.CustomerServiceImpl;

import io.javalin.http.Context;

public class CustomerControllerImpl implements CustomerController {

	private CustomerService customerService = new CustomerServiceImpl();
	private AuthController authController = new AuthControllerImpl();

	@Override
	public void apply_account(Context ctx) {
		
		String account_name = ctx.formParam("account_name");		
		double balance = Double.parseDouble(ctx.formParam("initial_amount"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, false, balance);
	
		if(customerService.apply_account(a) && authController.checkUser(ctx))
		{
			ctx.status(201);
			ctx.redirect("http://localhost:9000/customer_main.html");
		}
		else
		{
			ctx.status(500);
		}
		
	}
	
	@Override
	public void view_all_account_status(Context ctx) {
		
		Account a = new Account(ctx.cookieStore("name"), null, true, 0);
		if(authController.checkUser(ctx)) {
			ctx.status(200);
			ctx.json(customerService.view_all_account_status(a));
		}
		else
		{
			
			ctx.status(405);
		}
		
	}

	@Override
	public void view_balance(Context ctx) {
		
		String account_name = ctx.formParam("account_name");		
		double balance = Double.parseDouble(ctx.formParam("balance"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, true, balance);
		if(authController.checkUser(ctx)) {
			ctx.status(200);
			ctx.json(customerService.view_all_account_status(a));
		}
		else
		{
			ctx.status(405);
		}
		
	}

	@Override
	public void deposit(Context ctx) {
		String account_name = ctx.formParam("account_name");
		double deposit_amount = Double.parseDouble(ctx.formParam("deposit_amount"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, true, 0);
		a = customerService.init_account(a);
		if(customerService.deposit(a, deposit_amount) && authController.checkUser(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/customer_main.html");
		}
		else
		{
			ctx.status(404);
		}
	}

	@Override
	public void withdraw(Context ctx) {
		String account_name = ctx.formParam("account_name");
		double withdraw_amount = Double.parseDouble(ctx.formParam("withdraw_amount"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, true, 0);
		a = customerService.init_account(a);
		if(customerService.withdraw(a, withdraw_amount) && authController.checkUser(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/customer_main.html");
		}
		else
		{
			ctx.status(404);
		}
	}

	@Override
	public void post(Context ctx) {
		String account_name = ctx.formParam("account_name");
		String otherparty_username = ctx.formParam("otherparty_username");
		String otherparty_account_name = ctx.formParam("otherparty_account_name");
		double transfer_amount = Double.parseDouble(ctx.formParam("transfer_amount"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, true, 0);
		Account b = new Account(otherparty_username, otherparty_account_name, true, 0);
		
		a = customerService.init_account(a);
		b = customerService.init_account(b);
		if(customerService.post(a, b, transfer_amount) && authController.checkUser(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/customer_main.html");
		}
		else
		{
			ctx.status(404);
		}		
	}

	@Override
	public void accept(Context ctx) {
		String account_name = ctx.formParam("account_name");
		String otherparty_username = ctx.formParam("otherparty_username");
		String otherparty_account_name = ctx.formParam("otherparty_account_name");
		double receive_amount = Double.parseDouble(ctx.formParam("receive_amount"));
		
		Account a = new Account(ctx.cookieStore("name"), account_name, true, 0);
		Account b = new Account(otherparty_username, otherparty_account_name, true, 0);
		
		a = customerService.init_account(a);
		b = customerService.init_account(b);
		if(customerService.accept(a, b, receive_amount) && authController.checkUser(ctx))
		{
			ctx.status(200);
			ctx.redirect("http://localhost:9000/customer_main.html");
		}
		else
		{
			ctx.status(404);
		}
		
	}

}
