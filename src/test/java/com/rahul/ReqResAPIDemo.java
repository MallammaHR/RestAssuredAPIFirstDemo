package com.rahul;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class ReqResAPIDemo 
{
	//@Test
	public void get()
	{
		baseURI = "https://reqres.in/";
		
		given()
			.get("api/users?page=2").
		then()
			.statusCode(200)
			.body("data[0].id",equalTo(7))
			.body("data[0].first_name", equalTo("Michael")).
			log().all();
	}
	
	//@Test
	
	public void post()
	{
		JSONObject request=new JSONObject();
		
		request.put("name","Mallu");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in/api/";
		
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when().
			post("users").
		then().
			statusCode(201).log().all();
	}
	
	//@Test
	public void put()
	{
		JSONObject request=new JSONObject();
		
		request.put("name","Mallu");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in/api/";
		
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when().
			put("users/2").
		then().
			statusCode(200).log().all();
	}
		
	@Test
	public void patch()
	{
		JSONObject request=new JSONObject();
		
		request.put("name","TAANVI");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in/api/";
		
		given()
			.header("content-type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString()).
		when().
			patch("users/2").
		then().
			statusCode(200).log().all();
	}
	
	@Test
	public void delete()
	{	
		baseURI = "https://reqres.in/api/";
		
		when().
			delete("users/2").
		then().
			statusCode(204).log().all();
	}
	
}
