package com.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidator 
{
	
	@Test
	public void test_A()
	{
	
		baseURI = "https://reqres.in/";
		given().
			get("api/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
//			//body("data[1].id" , equalTo(8)).
//			body("data[2].first_name" ,equalTo("Tobias")).
//			body("data.first_name",hasItems("Rachel","George")).
			log().all();
		
	}
}
