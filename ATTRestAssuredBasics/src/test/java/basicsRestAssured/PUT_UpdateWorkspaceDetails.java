package basicsRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PUT_UpdateWorkspaceDetails {
	
	@Test
	public void UpdateWorkspaceDetails() {
		
		RestAssured.baseURI = "https://api.getpostman.com/";
		
		Response response = given()
		.header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
		.body("{\r\n"
				+ "    \"workspace\": {\r\n"
				+ "        \"name\": \"GeneralWorkspace\",\r\n"
				+ "        \"type\": \"team\",\r\n"
				+ "        \"description\": \"It's a comman updated workspace\",\r\n"
				+ "        \"visibility\": \"personal\"\r\n"
				+ "    }\r\n"
				+ "}")
		
		.when()
		.put("workspaces/b4455caa-16e0-4502-a082-b473a33c75f8")
		
		.then().extract().response();
		
		String pretty = response.asPrettyString();
		System.out.println(pretty);
	
	}

}
