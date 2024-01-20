package ExcelUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestExample 
{
	
		@Test
		public void test_A()
		{
			Response response = RestAssured.get("https://reqres.in/api/users?page=2");
			int status_code=response.getStatusCode();
			System.out.println("The status cod is :"+status_code);
			System.out.println(response.getTime());
			System.out.println(response.getBody().toString());
			Assert.assertEquals(status_code, 200);
		}
		
		@Test
		public void test_B()
		{
			baseURI ="https://reqres.in/api";
			given().
			get("/users?page=2").
			then().
			body("data[1].id", equalTo(5)).
			log().all();
			
					
		
		}
}
