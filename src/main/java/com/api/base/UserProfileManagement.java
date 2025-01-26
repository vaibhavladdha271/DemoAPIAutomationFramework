package com.api.base;

import io.restassured.response.Response;

public class UserProfileManagement extends BaseService {
	
	private static final String BASE_PATH="/api/users/"; 

	public Response getUserProfile(String token)
	{
		setAuthToken(token);
		return getRequest(BASE_PATH+"profile");
	}
}
