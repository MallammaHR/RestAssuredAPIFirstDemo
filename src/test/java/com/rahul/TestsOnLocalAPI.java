
package com.rahul;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/*
 * given():content type,set cookies,add auth,,aad param,set headers info et...
 * when():get,post,put,delete
 * then():validate the status code,extract response,extract header cookies and response bodies...
 */
public class TestsOnLocalAPI
{
//	//get request
	//@Test
	public void get()
	{
		baseURI ="http://localhost:3000";
		
		given()
			.get("/users").
		then()
			.statusCode(200).log().all();	
	}
	
	//post request
	//@Test
	public void post()
	{
		JSONObject request=new JSONObject();
		
		request.put("firstName","Thomas");
		request.put("lastName","Edison");
		request.put("subjectID", "5");
		
		baseURI ="http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when()
		.post("/users")
		.then()
		.statusCode(201);
	
	}
	
	//@Test
	public void put()
	{
		JSONObject request=new JSONObject();
		

		request.put("firstName","Albert");
		request.put("lastName","Edson");
		request.put("subjectID", "2");
		
		baseURI ="http://localhost:3000";
		//http://localhost:3000/users
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when()
		.put("/users/2232")
		.then()
		.statusCode(201);
	
	}
	@Test
	public void patch()
	{
		JSONObject request=new JSONObject();
		
		request.put("lastName","Edison100");

		baseURI ="http://localhost:3000";
		//http://localhost:3000/users
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).
		when()
		.patch("/users/2232")
		.then()
		.statusCode(201);
	
	}
	// @Test
	 public void delete()
	 {
		 baseURI ="http://localhost:3000";
		 
		 when().delete("/users/2232").then().statusCode(200).log().all();
	 }
	

}