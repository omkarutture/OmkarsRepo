package authorizationAuthentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class BasicAuth {
	
	//Basic Auth: has username & password combo. this is not recommended, as it get converted to Base64 which is easily decoded.
	
	@Test
	public void basicAuthorization() {
		
		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
		//.auth().basic("postman", "password") 
		//Used "auth()" : Specify authentication credentials when performing a request
		//Used "basic()" : Use http basic authentication. Parameters:userName The user name.password The password. Returns:The Request specification
		
		//As we observe, when Authorization is added, it get auto placed in Request Header with key "Authorization" & value "Basic <Base64>"
		//So, we can directly pass Basic Auth in "headers()" method as well via encoding to Base64. As below:
		.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		
		.log().all()
		
		.when().get("/basic-auth")
		
		.then().log().all().extract().response();
		
		
	}

}
