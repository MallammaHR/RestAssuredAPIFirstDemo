package com.authentication;

import io.restassured.RestAssured;

public class PrimitiveBasicDemo
{
	public void test_1()
	{
		
		
		int code=RestAssured.given()
		.auth().preemptive()
		.basic("", "").
		when()
		.get()
		.getStatusCode();
		
		System.out.println("Response code is : "+code);
	}
}
