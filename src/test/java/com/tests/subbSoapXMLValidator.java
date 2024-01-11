package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.apache.commons.io.IOUtils;

public class subbSoapXMLValidator
{
	@Test
	public void subbXML() throws IOException
	{
		File file =new File("./SoapRequest/Subb.xml");
		if(file.exists())
		System.out.println("File Exists"+file);
		
		FileInputStream fileinputstream=new FileInputStream(file);
		String requestBody = IOUtils.toString(fileinputstream, "UTF-8");
		
		baseURI="http://www.dneonline.com/";
		
		given()
			 .contentType("text/xml")//I am passing the content  type to the server is of XML type 
			 .accept(ContentType.XML)//I want accept return content type in XML only 
			 .body(requestBody).
		when()
			.post("calculator.asmx").
		then()
			.statusCode(200).log().all();
		
		
		

	}
}
