package com.rahul;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetDemoForGit
{
	//
	@Test
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
}
