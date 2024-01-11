package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class divSoapXMLValidator 
{
	@Test
	public void divXML() throws IOException
	{
		File file = new File("./SoapRequest/Div.xml");
		if(file.exists())
			System.out.println("file exists :     "+file);
		
		FileInputStream fileInputstrem=new FileInputStream(file);
		String requestBody=IOUtils.toString(fileInputstrem, "UTF-8");
		
		baseURI="http://www.dneonline.com/";
		
		given()
			.contentType("text/xml")//I am passing the content  type to the server is of XML type
			.accept(ContentType.XML)//I want accept return content type in XML only 
			.body(requestBody).
		when()
			.post("calculator.asmx").
		then()
			.statusCode(200).log().all().
		and()
			.body("//*:DivideResult.text()", equalTo("4"));
		
			

	}
}
