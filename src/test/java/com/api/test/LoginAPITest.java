package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
import resources.TestDataBuild;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {
	
	@Test
	public void loginUsingValidCredentials()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("vaibhav271","Test@1234");
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
	}
	@Test
	public void loginUsingInvalidCredentials()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("vaibhav271","Test@12");
		int statusCode=response.getStatusCode();
		LoginResponse loginResponse=response.as(LoginResponse.class);
		Assert.assertEquals(statusCode, 401);
		Assert.assertEquals(loginResponse.getMessage(), "Bad credentials");
	}
	@Test
	public void loginUsingEmptyUsername()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("","Test@12");
		int statusCode=response.getStatusCode();
		LoginResponse loginResponse=response.as(LoginResponse.class);
		Assert.assertEquals(statusCode, 401);
		Assert.assertEquals(loginResponse.getMessage(), "Full authentication is required to access this resource");
	}

}
