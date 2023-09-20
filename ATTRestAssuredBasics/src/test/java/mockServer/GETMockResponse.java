package mockServer;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GETMockResponse {
	
	@Test
	public void mcokserverResponse() {
		
		RestAssured.baseURI = "https://297dc1df-7b2b-48c5-b65f-5573b8772823.mock.pstmn.io";
		
		Response response = given()
		
		.when().get()
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
	System.out.println(pretty);	
	}
}
//This Mock Server is created in postman. where we can set for any collection and edit the body, status code, headers as per wish. 