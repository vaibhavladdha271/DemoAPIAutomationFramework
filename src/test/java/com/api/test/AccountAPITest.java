package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AccountService;
import com.api.base.AuthService;
import com.api.models.response.AccountResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountAPITest {
	
	@Test
	public void createAccount()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("vaibhav271", "Test@1234");
		LoginResponse loginResponse=response.as(LoginResponse.class);
		AccountService accountService=new AccountService();
		response=accountService.createAccount(loginResponse.getToken(), "CURRENT", "NORTH_BRANCH");
		AccountResponse accountResponse=response.as(AccountResponse.class);
		Assert.assertTrue(response.getStatusCode()==200);
		//System.out.println(response.getStatusCode());
	}
	@Test
	public void getAllAcounts()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("vaibhav271", "Test@1234");
		LoginResponse loginResponse=response.as(LoginResponse.class);
		AccountService accountService=new AccountService();
		response=accountService.getAccount(loginResponse.getToken());
		//System.out.println(response.asPrettyString());
		AccountResponse accountResponse=response.as(AccountResponse.class);
		System.out.println(accountResponse.getAccountNumber());
		}
	}
