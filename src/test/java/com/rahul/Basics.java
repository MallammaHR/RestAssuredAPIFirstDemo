package com.rahul;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import java.nio.file.InvalidPathException;

import files.payload;
///Add place --->update place with new address--->Get place to validate if New Address is present in response
public class Basics
{

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
				String response = given().log().all().queryParam("key", "qaclick123").header("Contetnt-type","application/json")
				.body(payload.Addplace()).when().
		post("maps/api/place/add/json").andReturn()
		.then().assertThat().statusCode(200)
		.body("scope",equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().toString();
		//System.out.println(response);
	
		//how to parse JSON by using the "JSONPath" class
		JsonPath js=new JsonPath(response);
		String placeId=js.getString("place_id");
		System.out.println(placeId);
		
		
		//uupadte place
		given().log().all().queryParam("key", "qaclick123").header("content-type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\"39c688cb5d171f761725955c75d6c56c\",\r\n"
				+ "\"address\":\"70 Summer walk,USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "").
		put("maps/api/place/get/json?").
		then().statusCode(200).log().all();
			
			
		
		
		
	}

}
