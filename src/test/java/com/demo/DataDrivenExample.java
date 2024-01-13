package com.demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenExample 
{
	//@Test
	public void getUsers()
	{
		baseURI = "http://localhost:3000";
		
		given()
			.param("name", "Selenium")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON).
		when()
			.get("/users").
		then()
			.statusCode(200).log().all();			
	}
	
	@Test()
	public void getSubjects()
	{
		baseURI="http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON).
		when()
			.get("/subjects").
		then()
			.statusCode(200).log().all();	
		
	}
	
	@Test
	public void post()
	{
		JSONObject request=new JSONObject();
		
		request.put("firstName", "Taanya");
		request.put("lastName", "ManishShetty");
		request.put("subjectID", 4);
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.post("/users").
		then()
			.statusCode(201).log().all();				
	}
	
	//@Test
	public void put()
	{
		JSONObject request=new JSONObject();
		
		request.put("firstName", "TAANYA");
		request.put("lastName", "M  Shetty");
		request.put("subjectID", 4);
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.contentType(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.put("/users/acb6").
		then()
			.statusCode(200).log().all();				
	}
	
	//@Test
	public void patch()
	{
		JSONObject request=new JSONObject();
		
		request.put("lastName","KINNI");
		
		baseURI = "http://localhost:3000";
		
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when()
			.patch("/users/ff6c").
		then()
			.statusCode(200).log().all();
	}
	
	
	//@Test
	public void delet()
	{
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/3c73").
		then()
			.statusCode(200)
			.log().all();
		
	}
}
