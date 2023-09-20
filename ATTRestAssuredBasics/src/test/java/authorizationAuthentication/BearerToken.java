package authorizationAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//Bearer Token: is a String which is generated as per requirement. i.e., we can customize the access for resp. services only. 
//While generating token github will ask us to mark the scope of token with validity.

//Generate Bearer Token: login in GitHub>>Setting>>Developer Option>>Personal Access Token>>Token(classic)>>Generate New Token>>check for scope & Expiration>>Generate
//After Generating token store it at safe place as it will pop-up only 2 times. 

//Only concern is it will not expire till the said period while generating. so, in between if it gets expose to anyone will be security breach.

public class BearerToken {
	
	@Test
	public void Postman_Workspace() {
		
		RestAssured.baseURI = "https://api.github.com/";
		
		Response response = given()
				            .header("Accept","application/vnd.github+json")
				            .header("Authorization","Bearer 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")
				            .header("X-GitHub-Api-Version","2022-11-28")
				            .log().all()
				            
		                    .when()
		                    .get("user/repos")
		
		                    .then().log().all().extract().response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
	}
}
