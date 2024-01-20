package com.pojoJsonArry;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Employee;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployeeJSONArray 
{
	@Test
	public void creatJSONOArraybjectFromEmployeClassObject() throws JsonProcessingException 
	{
		//create FirstEMployee
		Employee emp1=new Employee();
		
		emp1.setFirstName("Suresh");
		emp1.setLastName("Mehara");
		emp1.setGender("male");
		emp1.setAge(35);
		emp1.setSalary(10000.27);
		
		//create FirstEMployee
		Employee emp2=new Employee();
		
		emp1.setFirstName("Dipali");
		emp2.setLastName("Sandy");
		emp2.setGender("Female");
		emp2.setAge(34);
		emp2.setSalary(20000.27);
		
		//create FirstEMployee
		Employee emp3=new Employee();
		
		emp3.setFirstName("Roopa");
		emp3.setLastName("Mahi");
		emp3.setGender("Female");
		emp3.setAge(36);
		emp3.setSalary(40000.27);
		
		List<Employee> listOfEmploye=new ArrayList<Employee>();
		
		listOfEmploye.add(emp1);
		listOfEmploye.add(emp2);
		listOfEmploye.add(emp3);
		
		ObjectMapper objectMapp=new ObjectMapper();
		
		String JSONStringEmployeeList=objectMapp.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmploye);
		System.out.println(JSONStringEmployeeList);
		//create http post resquest
		RequestSpecification reqSpe=RestAssured.given();
		
		//reqSpe.baseUri("https://reqres.in/api/users");
		reqSpe.baseUri("https://httpbin.org/post");
		
		reqSpe.contentType(ContentType.JSON);
		reqSpe.body(JSONStringEmployeeList);
		
		Response response=reqSpe.post();
		System.out.println("Response is "+response.prettyPrint());
		
		Assert.assertEquals(response.statusCode(), 200,"verify the status code");
		
		System.out.println("***************************************************************");
		
		Employee emp4=objectMapp.readValue(JSONStringEmployeeList, Employee.class);
		
		System.out.println("fiistName : "+emp4.getFirstName());
		System.out.println("lastName : "+emp4.getLastName());
		System.out.println("Gender : "+emp4.getGender());
		System.out.println("Age : "+emp4.getAge());
		System.out.println("Salary :"+emp4.getSalary());
		
		
	}
	

}
