package com.tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.eclipse.jetty.websocket.api.StatusCode;



public class GETPOSTExamples 
{
	//get request
	//@Test
	public void test_A()
	{
	
		baseURI = "https://reqres.in/";
		given().
			get("api/users?page=2").
		then().
			statusCode(200).
			//body("data[1].id" , equalTo(8)).
			body("data[2].first_name" ,equalTo("Tobias")).
			body("data.first_name",hasItems("Rachel","George")).
			log().all();
	}
	//post request,in this we should provide body
	@Test
	public void test_B()
	{
//		Map<String , Object> map=new HashMap<String, Object>();
//		map.put("name","Mallu");
//		map.put("job", "Tester");
//		
//		System.out.println(map);
		
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
			post("users").
		then().
			statusCode(201).
			log().all();
		
	
		
		
	}
	
	
}
