package com.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import org.testng.*;
import org.testng.annotations.Test;

public class PutPatchDeleteExamples
{
	//put-request
	@Test
	public void testPUT()
	{
		JSONObject request=new JSONObject();
		request.put("name","Mallu");
		request.put("job", "Tester");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("contet-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("users/2").
		then().
			statusCode(201).
			log().all();
		
	}
	
	//patch request
	@Test
	public void testPATCH()
	{
		JSONObject request=new JSONObject();
		request.put("name","Mallu");
		request.put("job", "Tester");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("contet-type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/api/users/2").
		then().
			statusCode(201).
			log().all();
	
	}
	
	//patch request
	@Test
	public void testDELETE()
	{
	
		baseURI = "https://reqres.in";

		when().
				delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	
	}
	
	
	


}
