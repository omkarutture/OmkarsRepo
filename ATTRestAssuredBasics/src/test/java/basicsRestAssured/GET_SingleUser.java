package basicsRestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_SingleUser {
	
	@Test
	public void GET_Single_User() {
		
       RestAssured.baseURI = "https://reqres.in/";
		
		 Response response = given()
		
		                    .when() 
	       	                .get("api/users/2")
		
		                    .then()
		                    .extract()
		                    .response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
	}

}
