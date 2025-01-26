package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import com.api.models.response.SignupResponse;

import io.restassured.response.Response;

public class SignupAPITest {

	@Test
	public void signUpUsingValidCredentials()
	{
		AuthService authService=new AuthService();
		Response response=authService.signUp("vaibhav3","Test@1234","vaibhav.laddha123@gmail.com","Vaibhav","Laddha","9021906502");
		System.out.println(response.asPrettyString());
	}
	@Test
	public void signUpUsingDuplicateEmail()
	{
		AuthService authService=new AuthService();
		Response response=authService.signUp("vaibhav3","Test@1234","vaibhav.laddha8@gmail.com","Vaibhav","Laddha","9021906502");
		System.out.println(response.asString());
//		SignupResponse signupResponse=response.as(SignupResponse.class);
//		System.out.println(signupResponse.getError());
	}
}
