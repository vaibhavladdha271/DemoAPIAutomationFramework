package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class ResetPasswordAPITest {
	
	@Test
	public void resetPassword()
	{
		AuthService authService=new AuthService();
		Response response=authService.login("vaibhav271","Test@1234");
		LoginResponse loginResponse=response.as(LoginResponse.class);
		String token=loginResponse.getToken();
		System.out.println(token);
//		response=authService.resetPassword(token, "J@imatadi123", "J@imatadi123");
//		System.out.println(response.asPrettyString());
	}

}
