package ExcelUtils;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class TestExcelUtils 
{
	   public static void main(String[] args) {
	        String excelPath = "C:\\Users\\Mallukinnis\\eclipse-workspace\\RestAssuredAPIDemo\\RestAssuredDemo\\data\\TestData.xlsx";
	        String sheetName = "Sheet1";

	        ExcelUtilsData excel = new ExcelUtilsData(excelPath, sheetName);

	        int rowCount = excel.getrowCount();
	        System.out.println("rowCount is : "+rowCount);


	       baseURI = "http://localhost:3000/"; // Replace with your local API baseURI

	        for (int i = 1; i < rowCount; i++) 
	        {
	            JSONObject request = new JSONObject();
	            
	            request.put("firstName", excel.getCellData(i, 0));
	            request.put("lastName", excel.getCellData(i, 1));
	            request.put("subjectID", excel.getCellData(i, 2));

	            given()
	                    .header("Content-Type", "application/json")
	                    .contentType(ContentType.JSON)
	                    .accept(ContentType.JSON)
	                    .body(request.toJSONString()).
	             when()
	                    .post("/users"). // Replace with your API endpoint
	             then()
	                    .statusCode(201)
	                    .log().all();
	        }
	    }
}
