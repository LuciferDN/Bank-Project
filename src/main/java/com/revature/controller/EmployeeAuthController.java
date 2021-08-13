package com.revature.controller;

import io.javalin.http.Context;

public interface EmployeeAuthController {
	public void login(Context ctx);
	public void logout(Context ctx);
	public boolean checkEmployee(Context ctx);

}
