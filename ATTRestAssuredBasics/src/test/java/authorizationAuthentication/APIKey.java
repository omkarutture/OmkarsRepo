package authorizationAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//API Key is secure key which is generated after login. via which can be used any where easily.
//But, What if the key exposed to anyone via GitHub public repo. in such case one can have a access to our whole project which is unsecured.
//In such case, one can have a access till you delete the current key and generate the new one.
//we can't define it's validity, till we delete it and generate new one.
//To Generate API key, just need to login Postman>>profile>>generateAPIKey>>name api key>>Done.
//this will not allow us to customize it's scope. suck like Bearer Token with GitHub.

public class APIKey {

	@Test
	public void Postman_Workspace() {
		
		RestAssured.baseURI = "https://api.getpostman.com/";
		
		Response response = given()
				            .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")//header with key-value pair.
		//Here, is the API Key with header: Key>"x-api-key" & Value>"PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a"
				            
		                    .when()
		                    .get("workspaces")
		
		                    .then().extract().response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
	}
	
}
