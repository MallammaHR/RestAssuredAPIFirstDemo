package com.tests;


import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SaopXLMRequest  {
	
	@Test
	public void validateSoapXML() throws IOException 
	{
		
		File file = new File("./SoapRequest/Subb.xml");
		
		if(file.exists())
			System.out.println("File Exists"+file);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		//http://www.dneonline.com/calculator.asmx
		
		given().
			contentType("text/xml").//I am passing the content  type to the server is of XML type 
			accept(ContentType.XML).//I want accept return content type in XML only 
			body(requestBody).
		when().
			post("calculator.asmx").
		then().
			statusCode(200).log().all().
		and().
			body(" //*:SubtractResult.text()", equalTo("8"));
			
		
	}

}
