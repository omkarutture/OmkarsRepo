package basicsRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_SpecificWorkspace {

	@Test
	public void Postman_Workspace() {
		
		RestAssured.baseURI = "https://api.getpostman.com/";
		
		Response response = given()
				            .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")//header with key-value pair.
				
		                    .when()
		                    .get("workspaces/c833c758-6ad1-4823-ba63-951c029ac466")//Need to provide id value of specific workspace.
		
		                    .then().extract().response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
	}
	
}
