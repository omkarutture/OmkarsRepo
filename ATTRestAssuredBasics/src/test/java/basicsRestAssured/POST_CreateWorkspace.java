package basicsRestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_CreateWorkspace {
	
	@Test
	public void Create_Workspace() {
		
		RestAssured.baseURI = "https://api.getpostman.com/";
		
		Response response = given()
		                    .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
		                    .body("{\r\n"
				            + "    \"workspace\": {\r\n"
				            + "        \"name\": \"PragatisWorkspace\",\r\n"
			              	+ "        \"description\": \"Personal Use Only\",\r\n"
				            + "        \"type\": \"personal\",\r\n"
				            + "        \"visibility\": \"personal\"\r\n"
			             	+ "    }\r\n"
			            	+ "}")
		
		                    .when()
	                    	.post("workspaces")
		
	                    	.then().extract().response();
		
		System.out.println(response);
		String pretty = response.asPrettyString();
		System.out.println(pretty);
		
	}

}
