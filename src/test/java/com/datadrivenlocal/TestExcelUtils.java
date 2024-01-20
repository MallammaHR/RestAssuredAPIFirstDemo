package com.datadrivenlocal;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class TestExcelUtils 
{
    public static void main(String[] args) 
    {
        String excelPath = "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\RestAssuredDemo\\data\\data.xlsx";
        String sheetName = "Sheet1";

        ExcelUtilsData excel = new ExcelUtilsData(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();
        System.out.println("rowCount is : " + rowCount);
        System.out.println("columnCount is : " + columnCount);

        baseURI = "http://localhost:3000/"; 

        for (int i = 1; i < rowCount; i++) 
        {
            JSONObject request = new JSONObject();

            for (int j = 0; j < columnCount; j++) {
                String columnName = excel.getCellData(0, j);
                String cellValue = excel.getCellData(i, j);
                request.put(columnName, cellValue);
            }

            // Create user
            given()
            	.header("Content-Type", "application/json")
            	.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString()).
            when()
            	.post("/users").
            then()
                    .statusCode(201).log().all();

            // Get the ID of the created user
            
            String userID = given().get("/users").then().extract().path("[0].id");

            // Delete the user
            given().header("Content-Type", "application/json").contentType(ContentType.JSON)
                    .accept(ContentType.JSON).when().delete("/users/" + userID).then().statusCode(200).log().all();
        }
    }
}