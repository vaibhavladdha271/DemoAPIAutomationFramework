package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.*;

public class BaseService {
	
	public static final String BASE_URL="https://swift.techwithjatin.com/";
	
	public RequestSpecification reqSpec;
	static
	{
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		reqSpec=given().baseUri(BASE_URL);
	}
	
	public Response postRequest(Object payload,String endPoint)
	{
		return reqSpec.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	public Response getRequest(String endPoint)
	{
		return reqSpec.contentType(ContentType.JSON).get(endPoint);
	}
	public Response updateRequest(Object payload,String endPoint)
	{
		return reqSpec.contentType(ContentType.JSON).put(endPoint);
	}
	public void setAuthToken(String token)
	{
		reqSpec.header("Authorization","Bearer "+token);
	}

}
