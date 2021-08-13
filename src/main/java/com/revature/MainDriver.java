package com.revature;
import com.revature.controller.AuthController;
import com.revature.controller.AuthControllerImpl;
import com.revature.controller.CustomerController;
import com.revature.controller.CustomerControllerImpl;
import com.revature.controller.EmployeeAuthController;
import com.revature.controller.EmployeeAuthControllerImpl;
import com.revature.controller.EmployeeController;
import com.revature.controller.EmployeeControllerImpl;

import io.javalin.Javalin;
import io.javalin.http.Context;


public class MainDriver {
	private static final String LOGIN_PATH = "/login";
	private static final String CUSTOMER_PATH = "/customer_main";
	private static final String APPLY_PATH = "/apply_account";
	private static final String DEPOSIT_PATH = "/deposit";
	private static final String WITHDRAW_PATH = "/withdraw";
	private static final String TRANSFER_PATH = "/transfer";
	private static final String RECEIVE_PATH = "/receive";
	
	private static final String EMPLOYEE_LOGIN_PATH = "/employeelogin";
	private static final String EMPLOYEE_PATH = "employee_main";
	private static final String EMPLOYEE_APPROVE_PATH = "approve";
	private static final String EMPLOYEE_REJECT_PATH = "reject";
	
	private static AuthController authController = new AuthControllerImpl();
	private static CustomerController customerController = new CustomerControllerImpl();
	private static EmployeeAuthController employeeAuthController = new EmployeeAuthControllerImpl();
	private static EmployeeController employeeController = new EmployeeControllerImpl();
	
	
	public static void main(String[] args) {
		Javalin app = Javalin.create(
				config -> {config.addStaticFiles("/public");
				}
			).start(9000);
		
		app.post(LOGIN_PATH, ctx -> authController.login(ctx));
		app.get("/logout", ctx -> authController.logout(ctx));
		app.get("/checkUser", ctx -> authController.checkUser(ctx));
		
		app.get(CUSTOMER_PATH, ctx -> customerController.view_all_account_status(ctx));
		app.post(APPLY_PATH, ctx -> customerController.apply_account(ctx));
		app.post(DEPOSIT_PATH, ctx -> customerController.deposit(ctx));
		app.post(WITHDRAW_PATH, ctx -> customerController.withdraw(ctx));
		app.post(TRANSFER_PATH, ctx -> customerController.post(ctx));
		app.post(RECEIVE_PATH, ctx -> customerController.accept(ctx));
		
		app.post(EMPLOYEE_LOGIN_PATH, ctx -> employeeAuthController.login(ctx));
		app.get("/employeelogout", ctx -> employeeAuthController.logout(ctx));
		app.get("/checkEmployee", ctx -> employeeAuthController.checkEmployee(ctx));
		
		app.get(EMPLOYEE_PATH, ctx -> employeeController.view_all_account_status(ctx));
		app.post(EMPLOYEE_APPROVE_PATH, ctx -> employeeController.approve(ctx));
		app.post(EMPLOYEE_REJECT_PATH, ctx -> employeeController.reject(ctx));
	}

}
