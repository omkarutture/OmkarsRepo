package readyToUseJSON;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JSONObjectBody {
	
//We can pass JSON body in 3 ways:
	//1. Via passing it within the arguments of .body("<JSON_BODY>") method
	//2. Storing JSON_Body in another class which returns JSON_body in terms of String. And we can call with "classname.methodname()" in any class within same package.
	//3. Via HashMap() class : As mentioned below.
	
	@Test
	public void jsonobjectBody() {
		
		HashMap<String, String> value = new HashMap<String, String>();
		value.put("name", "INDIA");
		value.put("description", "WORLD SUPER POWER");
		value.put("type", "personal");
		value.put("visibility", "personal");
		
		HashMap<String, Object> jsonObject = new HashMap<String, Object>();
		jsonObject.put("workspace", value);
		
		//to use this method; ensure you have added dependency of "jackson" in xml file. 
		
        RestAssured.baseURI = "https://api.getpostman.com/";
		
		Response response = given()
				            .header("x-api-key","PMAK-64f1d9e5b52fc60029b825e7-4653a5b5bcca153b51f82cc2e2292c100a")
				            .body(jsonObject)
				
		                    .when()
		                    .post("workspaces")
		
		                    .then().extract().response();
		
		System.out.println(response);
		String prittyresponse = response.asPrettyString();
		System.out.println(prittyresponse);
		
	}

}
