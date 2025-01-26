package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.ResetPasswordRequest;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;
import resources.TestDataBuild;

public class AuthService extends BaseService {

	public static final String BASE_PATH="/api/auth";
	
	public Response login(String username,String password)
	{
		TestDataBuild testData=new TestDataBuild();
		LoginRequest loginRequest=testData.validLoginPayload(username,password);
		return postRequest(loginRequest,BASE_PATH+"/login");
	}
	public Response signUp(String username, String password, String email, String firstName, String lastName,
			String mobileNumber)
	{
		TestDataBuild testData=new TestDataBuild();
		SignupRequest signupRequest=testData.addUser(username,password,email,firstName,lastName,mobileNumber);
	    return postRequest(signupRequest,BASE_PATH+"/signup");
	}
	public Response forgotPassword(String email)
	{
		HashMap<String,String> payload=new HashMap<String,String>();
		payload.put("email", email);
		return postRequest(payload,BASE_PATH+"/forgot-password");
	}
	public Response resetPassword(String token,String newPassword,String confirmPassword)
	{
		TestDataBuild testData=new TestDataBuild();
		ResetPasswordRequest resetPasswordRequest=testData.resetPassword(token,newPassword, confirmPassword);
		return postRequest(resetPasswordRequest, BASE_PATH+"/reset-password");
	}
	
}
