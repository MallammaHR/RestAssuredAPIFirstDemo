package com.pojo;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerilizationAndDesrialization 
{

	@Test
	public void creatJSONObjectFromEmployeClassObject() throws IOException
	{
		Employee emp1=new Employee();
		
		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehara");
		emp1.setGender("male");
		emp1.setAge(35);
		emp1.setSalary(10000.27);
	
		//convert employee class Object to JSON
		ObjectMapper objMapper=new ObjectMapper();
		
		String employeJSON=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		System.out.println(employeJSON);
		
		//create Request Specification
		RequestSpecification reSpec=RestAssured.given();
		
		reSpec.contentType(ContentType.JSON);
		reSpec.body(employeJSON);
		
		reSpec.baseUri("https://httpbin.org/post");
		//perfor post()
		Response response=reSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(),200,"Check for status code");
		//System.out.println("*********************************************************************************");
		
		//convert (emplyoJSON)JSON string class Object(Employee)
		Employee emp2=objMapper.readValue(employeJSON, Employee.class);
		
		System.out.println("firstName:"+emp2.getFirstName());
		System.out.println("lastName:"+emp2.getLastName());
		System.out.println("Gender: "+emp2.getGender());
		System.out.println("Age :"+emp2.getAge());
		System.out.println("Salary:"+emp2.getSalary());
		
		
		
	}
}
