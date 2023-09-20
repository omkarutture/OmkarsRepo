package requestAndresponseSpecBuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LogAllMethod {
	
	@Test
	public void Postman_Workspace() {
		
		RestAssured.baseURI = "https://api.getpostman.com/";
		
		                     given()
				            .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")//header with key-value pair.
				            .log().all()
				
		                    .when()
		                    .get("workspaces")
		
		                    .then().log().all().extract().response(); 
		//log().all() will print all the response in console. Via it we can bypass syso(pretty) and related steps.
		//This log().all() can be also be used at given() level. To print all the request in console
		//.log(): Returns the RequestLogSpecification that allows you to log different parts of the RequestSpecification
		//.all(): Logs everything in the specification, including e.g. headers, cookies, body. Pretty-prints the body if content-type is either either XML, JSON or HTML
		//This method is recommended to use when we just to check the request and response behavior via printing it all in the console
		
//		System.out.println(response);
//		String prittyresponse = response.asPrettyString();
//		System.out.println(prittyresponse);
		
	}
	
}
