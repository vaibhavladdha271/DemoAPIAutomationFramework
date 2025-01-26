package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {

	@Test
	public void verifyForgotPasswordFunctionality()
	{
		AuthService authService=new AuthService();
		Response response=authService.forgotPassword("vaibhavladdha271@gmail.com");
		System.out.println(response.asPrettyString());
	}
}
