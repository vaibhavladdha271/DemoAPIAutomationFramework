package com.api.base;

import com.api.models.request.CreateAccountRequest;

import io.restassured.response.Response;
import resources.AccountData;

public class AccountService extends AuthService {
	
	public static final String BASE_PATH="/api";
	
	public Response createAccount(String token,String accountType,String branch)
	{
		AccountData accountData=new AccountData();
		CreateAccountRequest createAccountRequest=accountData.createAccount(accountType,branch);
		setAuthToken(token);
		return postRequest(createAccountRequest, BASE_PATH+"/accounts");
	}
	public Response getAccount(String token)
	{
		setAuthToken(token);
		return getRequest(BASE_PATH+"/accounts/user");
	}
	public Response getAccountDetailsUsingAccountNumber(String token,String accountNumber)
	{
		setAuthToken(token);
		return getRequest(BASE_PATH+"/accounts/"+accountNumber);
	}

}
